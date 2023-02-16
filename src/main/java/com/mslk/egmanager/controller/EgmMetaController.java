package com.mslk.egmanager.controller;

import com.mslk.hypermakina.board.service.BoardService;
import com.mslk.egmanager.dto.EgmMetaDto;
import com.mslk.egmanager.service.EgmMetaService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.oauth2.client.web.OAuth2AuthorizationRequestRedirectFilter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;
import java.time.LocalDateTime;
import java.util.List;

@Slf4j
@Controller
@AllArgsConstructor
public class EgmMetaController {

    private static String authorizationRequestBaseUri = OAuth2AuthorizationRequestRedirectFilter.DEFAULT_AUTHORIZATION_REQUEST_BASE_URI;

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    private BoardService boardService;

    private EgmMetaService egmMetaService;

    @GetMapping("/admin/egnmetalist")
    public String egnmeta(Principal principal, Model model, @RequestParam(value="page", defaultValue = "1") Integer pageNum) {

        List<EgmMetaDto> egmMetaList = egmMetaService.getEgmMetalist(pageNum);
        Integer[] pageList = egmMetaService.getPageList(pageNum);

        double  count = Double.valueOf(egmMetaService.getEgmMetaCount());
        Integer postsTotalCount = (int) count;

        model.addAttribute("egmMetaList", egmMetaList);
        model.addAttribute("pageList", pageList);
        model.addAttribute("page", pageNum);
        model.addAttribute("postsTotalCount", postsTotalCount);

        return "egnmeta/index.html";
    }


    @PostMapping("/admin/egnmetapost")
    public String egnmetapost(Principal principal, EgmMetaDto egmMetaDto) {

        LocalDateTime now = LocalDateTime.now();

        egmMetaDto.setAltEn(principal.getName());

        // System.out.println(now);

        egmMetaService.savePost(egmMetaDto);

        return "redirect:/admin/egnmetalist";
    }


    @GetMapping("/admin/egnmetadel")
    public String egnmetadelete(@RequestParam(value="idx") String idx) {

        long no = 0;

        int beginIndex = idx.indexOf(",");

        if(beginIndex > 0){

            String[] ArraysStr = idx.split(",");

            for(String s : ArraysStr){
                no = Long.parseLong(s);
                egmMetaService.deletePost(no);
            }

        }else{

            no = Long.parseLong(idx);
            egmMetaService.deletePost(no);

        }
        return "redirect:/admin/egnmetalist";
    }


    @PostMapping("/admin/egnmetasearch")
    public String egnmetasearch(EgmMetaDto egmMetaDto, Model model) {

        List<EgmMetaDto> egmMetaList = egmMetaService.getEgmMetalist(10); //hyperRestApiService.searchPosts(hyperRestApiDto);
        Integer[] pageList = egmMetaService.getPageList(10);

        double  count = Double.valueOf(egmMetaList.size());
        Integer postsTotalCount = (int) count;

        model.addAttribute("egmMetaList", egmMetaList);
        model.addAttribute("pageList", pageList);
        model.addAttribute("postsTotalCount", postsTotalCount);


        return "egnmeta/index.html";
    }




}
