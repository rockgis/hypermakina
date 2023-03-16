package com.mslk.restapi.controller;

import com.mslk.common.paging.Pagination;
import com.mslk.common.paging.dto.SearchDto;
import com.mslk.dashboard.service.DashBoardMngService;
import com.mslk.egmanager.service.EgmMetaService;
import com.mslk.hypermakina.board.service.BoardService;

import com.mslk.restapi.dto.HyperRestApiDto;
import com.mslk.restapi.service.HyperRestApiService;

import com.mslk.sns.staff.service.StaffService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.oauth2.client.web.OAuth2AuthorizationRequestRedirectFilter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
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

    private EgmMetaService egmMetaService;

    private StaffService staffService;

    private DashBoardMngService dashBoardMngService;

    @GetMapping("/admin/restlist")
    public String hyperrestapi(Principal principal, Model model, @ModelAttribute("params") final SearchDto params) {

        List<HyperRestApiDto> hyperRestApiList = hyperRestApiService.getHyperRestlist(params.getPage());


        double  count = Double.valueOf(hyperRestApiService.getHyperRestApiCount());
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

        model.addAttribute("hyperRestApiList", hyperRestApiList);
        model.addAttribute("pagination", pagination);


        double  regcount = Double.valueOf(egmMetaService.getEgmMetaCount());
        Integer regCount = (int) regcount;
        model.addAttribute("regCount", regCount);

        double  staffcount = Double.valueOf(staffService.getStaffCount());
        Integer staffCount = (int) staffcount;
        model.addAttribute("staffCount", staffCount);

        double  restcount = Double.valueOf(hyperRestApiService.getHyperRestApiCount());
        Integer restCount = (int) restcount;
        model.addAttribute("restCount", restCount);

        double  dashcount = Double.valueOf(dashBoardMngService.getDashBoardMngCount());
        Integer dashCount = (int) dashcount;
        model.addAttribute("dashCount", dashCount);

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
    public String restsearch(HyperRestApiDto hyperRestApiDto, Model model, @ModelAttribute("params") final SearchDto params) {

        List<HyperRestApiDto> hyperRestApiList = hyperRestApiService.getHyperRestlist(10); //hyperRestApiService.searchPosts(hyperRestApiDto);

        double  count = Double.valueOf(hyperRestApiList.size());
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

        model.addAttribute("hyperRestApiList", hyperRestApiList);
        model.addAttribute("pagination", pagination);

        return "manager/restapimng/index.html";
    }


}
