package com.mslk.sns.logmng.controller;

import com.mslk.common.paging.Pagination;
import com.mslk.common.paging.dto.SearchDto;
import com.mslk.sns.logmng.dto.MmsLogDto;
import com.mslk.sns.logmng.service.MmsLogService;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.List;

@Controller
@AllArgsConstructor
public class MmsmngController {
    private MmsLogService mmsLogService;

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    /* Main Page */
    @GetMapping("/snsad/logmng")
    public String logmng(Model model ,@ModelAttribute("params") final SearchDto params) {

        List<MmsLogDto> mmsLogList = mmsLogService.getMmsLoglist(params.getPage());

        double  count = Double.valueOf(mmsLogService.getMmsLogCount());
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

        model.addAttribute("mmsLogList", mmsLogList);
        model.addAttribute("pagination", pagination);

        model.addAttribute("pageURL", "/snsad/logmng");


        return "sns/logmng/main.html";
    }





}
