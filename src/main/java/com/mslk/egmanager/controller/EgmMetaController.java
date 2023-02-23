package com.mslk.egmanager.controller;

import com.mslk.egmanager.dto.EgmDataDto;
import com.mslk.hypermakina.board.dto.BoardDto;
import com.mslk.hypermakina.board.service.BoardService;
import com.mslk.egmanager.dto.EgmMetaDto;
import com.mslk.egmanager.service.EgmMetaService;
import com.mslk.egmanager.service.EgmDataService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.oauth2.client.web.OAuth2AuthorizationRequestRedirectFilter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Controller
@AllArgsConstructor
public class EgmMetaController {

    private static String authorizationRequestBaseUri = OAuth2AuthorizationRequestRedirectFilter.DEFAULT_AUTHORIZATION_REQUEST_BASE_URI;

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    private EgmMetaService egmMetaService;

    private EgmDataService egmDataService;

    @GetMapping("/admin/egnmetalist")
    public String egnmeta(Principal principal, Model model, @RequestParam(value="page", defaultValue = "1") Integer pageNum) {

        List<EgmMetaDto> egmMetaList = egmMetaService.getEgmMetalist(pageNum);

        double  count = Double.valueOf(egmMetaService.getEgmMetaCount());
        Integer[] pageList = egmMetaService.getPageList(pageNum, count);

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


    @GetMapping("/egnmeta/post/{no}")
    public String staffdetail(@PathVariable("no") Long no, Model model) {
        EgmMetaDto egmMetaDto = egmMetaService.getPost(no);

        model.addAttribute("egmMetaDto", egmMetaDto);

        List<EgmDataDto> egmDataList = egmDataService.getEgmDatalist(20);


        model.addAttribute("egmDataList", egmDataList);


        return "egnmeta/read";
    }

    @PutMapping("/egnmeta/post/edit/{no}")
    public String update(EgmMetaDto egmMetaDto) {
        egmMetaService.savePost(egmMetaDto);

        return "redirect:/admin/egnmetalist";
    }


    @PostMapping("/admin/egnmetasearch")
    public String egnmetasearch(@RequestParam(value="keyword") String keyword, @RequestParam(value="searchType") String searchType ,Model model, @RequestParam(value="page", defaultValue = "1") Integer pageNum) {

        logger.info("searchType : " + searchType);
        logger.info("keyword : " + keyword);

        List<EgmMetaDto> egmMetaList = egmMetaService.searchPosts(searchType, keyword); //

        double  count = Double.valueOf(egmMetaList.size());
        Integer[] pageList = egmMetaService.getPageList(pageNum, count);

        Integer postsTotalCount = (int) count;

        model.addAttribute("egmMetaList", egmMetaList);
        model.addAttribute("pageList", pageList);
        model.addAttribute("page", pageNum);
        model.addAttribute("postsTotalCount", postsTotalCount);
        model.addAttribute("searchType", searchType);
        model.addAttribute("keyword", keyword);

        return "egnmeta/search.html";
    }




}
