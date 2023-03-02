package com.mslk.hypermakina.logmng.controller;

import com.mslk.common.paging.Pagination;
import com.mslk.common.paging.dto.SearchDto;
import com.mslk.hypermakina.logmng.dto.Gitte0001Dto;
import com.mslk.hypermakina.logmng.service.Gitte0001Service;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@AllArgsConstructor
public class LogmngController {
    private Gitte0001Service gitte0001Service;

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    /* Main Page */
    @GetMapping("/admin/logmng")
    public String list(Model model ,@ModelAttribute("params") final SearchDto params) {

        List<Gitte0001Dto> gitte0001List = gitte0001Service.getGitte0001list(params.getPage());

        double  count = Double.valueOf(gitte0001Service.getGitte001Count());
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

        model.addAttribute("gitte0001List", gitte0001List);
        model.addAttribute("pagination", pagination);


        return "manager/logmng/main.html";
    }





}
