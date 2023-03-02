package com.mslk.egmanager.controller;

import com.mslk.common.paging.Pagination;
import com.mslk.common.paging.dto.SearchDto;
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

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    private EgmMetaService egmMetaService;

    private EgmDataService egmDataService;

    @GetMapping("/admin/egmmetalist")
    public String egmmetalist(Principal principal, Model model, @ModelAttribute("params") final SearchDto params) {

        List<EgmMetaDto> egmMetaList = egmMetaService.getEgmMetalist(params.getPage());

        double  count = Double.valueOf(egmMetaService.getEgmMetaCount());
        Integer postsTotalCount = (int) count;

        logger.info("params : " + params.getPage());


        Pagination pagination = new Pagination(postsTotalCount, params);

        logger.info("totalRecordCount : " + pagination.getTotalRecordCount());
        logger.info("totalPageCount : " + pagination.getTotalPageCount());
        logger.info("startPage : " + pagination.getStartPage());
        logger.info("endPage : " + pagination.getEndPage());
        logger.info("limitStart : " + pagination.getLimitStart());
        logger.info("existPrevPage : " + pagination.isExistPrevPage());
        logger.info("existNextPage : " + pagination.isExistNextPage());

        model.addAttribute("egmMetaList", egmMetaList);
        model.addAttribute("pagination", pagination);


        return "egmmeta/index.html";
    }


    @PostMapping("/admin/egmmetapost")
    public String egmmetapost(Principal principal, EgmMetaDto egmMetaDto) {

        LocalDateTime now = LocalDateTime.now();

        egmMetaDto.setAltEn(principal.getName());

        // System.out.println(now);

        egmMetaService.savePost(egmMetaDto);

        return "redirect:/admin/egmmetalist";
    }


    @GetMapping("/admin/egmmetadel")
    public String egmmetadelete(@RequestParam(value="idx") String idx) {

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
        return "redirect:/admin/egmmetalist";
    }


    @GetMapping("/egmmeta/post/{no}")
    public String egmmetadetail(@PathVariable("no") Long no, Model model) {
        EgmMetaDto egmMetaDto = egmMetaService.getPost(no);

        model.addAttribute("egmMetaDto", egmMetaDto);


        logger.info("no : "+ no);

        List<EgmDataDto> egmDataList = egmDataService.getEgmMetaIDlist(no);


        model.addAttribute("egmDataList", egmDataList);


        return "egmmeta/read";
    }

    @PutMapping("/egmmeta/post/edit/{no}")
    public String egmmetaupdate(EgmMetaDto egmMetaDto) {
        egmMetaService.savePost(egmMetaDto);

        return "redirect:/admin/egmmetalist";
    }


    @PostMapping("/admin/egmmetasearch")
    public String egmmetasearch(@RequestParam(value="keyword") String keyword, @RequestParam(value="searchType") String searchType ,Model model, @RequestParam(value="page", defaultValue = "1") Integer pageNum) {

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

        return "egmmeta/search.html";
    }




}
