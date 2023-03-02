package com.mslk.hypermakina.inspectionmng.controller;


import com.mslk.common.paging.Pagination;
import com.mslk.common.paging.dto.SearchDto;
import com.mslk.hypermakina.inspectionmng.service.Gittd0003Service;
import com.mslk.hypermakina.inspectionmng.service.Gittd0004Service;
import com.mslk.hypermakina.inspectionmng.dto.Gittd0001Dto;
import com.mslk.hypermakina.inspectionmng.service.Gittd0001Service;
import com.mslk.hypermakina.inspectionmng.dto.Gittd0002Dto;
import com.mslk.hypermakina.inspectionmng.service.Gittd0002Service;

import com.mslk.hypermakina.inspectionmng.dto.Gittd0003Dto;
import com.mslk.hypermakina.inspectionmng.dto.Gittd0004Dto;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@AllArgsConstructor
public class InspectionmngController {


    private Gittd0001Service gittd0001Service;
    private Gittd0002Service gittd0002Service;

    private Gittd0003Service gittd0003Service;

    private Gittd0004Service gittd0004Service;


    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    /* 인증감사 */
    @GetMapping("/admin/inspectionmng")
    public String inspectionmng(Model model, @RequestParam(value="page", defaultValue = "1") Integer pageNum) {
        List<Gittd0001Dto> gittd0001List = gittd0001Service.getGittd0001list(pageNum);
        Integer[] pageList = gittd0001Service.getPageList(pageNum);

        double  count = Double.valueOf(gittd0001Service.getGittd001Count());
        Integer postsTotalCount = (int) count;

        model.addAttribute("gittd0001List", gittd0001List);
        model.addAttribute("pageList", pageList);
        model.addAttribute("postsTotalCount", postsTotalCount);

        return "manager/inspectionmng/main.html";
    }

    /* 계정감사 */
    @GetMapping("/admin/accountaudit")
    public String accountaudit(Model model, @ModelAttribute("params") final SearchDto params) {
        List<Gittd0002Dto> gittd0002List = gittd0002Service.getGittd0002list(params.getPage());


        double  count = Double.valueOf(gittd0002Service.getGittd002Count());
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

        model.addAttribute("gittd0002List", gittd0002List);
        model.addAttribute("pagination", pagination);

        return "manager/accountaudit/main.html";
    }

    /* 권한감사 */
    @GetMapping("/admin/authorityaudit")
    public String authorityaudit(Model model, @ModelAttribute("params") final SearchDto params) {
        List<Gittd0003Dto> gittd0003List = gittd0003Service.getGittd0003list(params.getPage());

        double  count = Double.valueOf(gittd0003Service.getGittd003Count());
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

        model.addAttribute("gittd0003List", gittd0003List);
        model.addAttribute("pagination", pagination);

        return "manager/authorityaudit/main.html";
    }

    /* 앱점속감사 */
    @GetMapping("/admin/appstoreaudit")
    public String list(Model model, @RequestParam(value="page", defaultValue = "1") Integer pageNum) {
        List<Gittd0004Dto> gittd0004List = gittd0004Service.getGittd0004list(pageNum);
        Integer[] pageList = gittd0004Service.getPageList(pageNum);

        double  count = Double.valueOf(gittd0004Service.getGittd004Count());
        Integer postsTotalCount = (int) count;

        model.addAttribute("gittd0004List", gittd0004List);
        model.addAttribute("pageList", pageList);
        model.addAttribute("postsTotalCount", postsTotalCount);

        return "manager/appstoreaudit/main.html";
    }

}
