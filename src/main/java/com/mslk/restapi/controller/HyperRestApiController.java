package com.mslk.restapi.controller;

import com.mslk.hypermakina.board.service.BoardService;

import com.mslk.restapi.dto.HyperRestApiDto;
import com.mslk.restapi.service.HyperRestApiService;

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
public class HyperRestApiController {

    private static String authorizationRequestBaseUri = OAuth2AuthorizationRequestRedirectFilter.DEFAULT_AUTHORIZATION_REQUEST_BASE_URI;

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    private BoardService boardService;

    private  HyperRestApiService  hyperRestApiService;

    @GetMapping("/admin/restlist")
    public String hyperrestapi(Principal principal, Model model, @RequestParam(value="page", defaultValue = "1") Integer pageNum) {

        List<HyperRestApiDto> hyperRestApiList = hyperRestApiService.getHyperRestlist(pageNum);
        Integer[] pageList = hyperRestApiService.getPageList(pageNum);

        double  count = Double.valueOf(hyperRestApiService.getHyperRestApiCount());
        Integer postsTotalCount = (int) count;

        model.addAttribute("hyperRestApiList", hyperRestApiList);
        model.addAttribute("pageList", pageList);
        model.addAttribute("postsTotalCount", postsTotalCount);

        return "manager/restapimng/index.html";
    }


    @PostMapping("/admin/restpost")
    public String restpost(Principal principal, HyperRestApiDto hyperRestApiDto) {

        LocalDateTime now = LocalDateTime.now();

        hyperRestApiDto.setAltEn(principal.getName());

        // System.out.println(now);

        hyperRestApiService.savePost(hyperRestApiDto);

        return "redirect:/admin/restlist";
    }


    @GetMapping("/admin/restdel")
    public String restdelete(@RequestParam(value="idx") String idx) {

        long no = 0;

        int beginIndex = idx.indexOf(",");

        if(beginIndex > 0){

            String[] ArraysStr = idx.split(",");

            for(String s : ArraysStr){
                no = Long.parseLong(s);
                hyperRestApiService.deletePost(no);
            }

        }else{

            no = Long.parseLong(idx);
            hyperRestApiService.deletePost(no);

        }
        return "redirect:/admin/restlist";
    }


    @PostMapping("/admin/restsearch")
    public String restsearch(HyperRestApiDto hyperRestApiDto, Model model) {

        List<HyperRestApiDto> hyperRestApiList = hyperRestApiService.getHyperRestlist(10); //hyperRestApiService.searchPosts(hyperRestApiDto);
        Integer[] pageList = hyperRestApiService.getPageList(10);

        double  count = Double.valueOf(hyperRestApiList.size());
        Integer postsTotalCount = (int) count;

        model.addAttribute("hyperRestApiList", hyperRestApiList);
        model.addAttribute("pageList", pageList);
        model.addAttribute("postsTotalCount", postsTotalCount);


        return "manager/restapimng/index.html";
    }


}
