package com.mslk.sns.sms.controller;

import com.mslk.common.paging.Pagination;
import com.mslk.common.paging.dto.SearchDto;
import com.mslk.hypermakina.code.dto.CodeMngDto;
import com.mslk.hypermakina.code.service.CodeMngService;
import com.mslk.sns.department.dto.DepartmentDto;
import com.mslk.sns.department.service.DepartmentService;
import com.mslk.sns.sms.dto.MmsDto;
import com.mslk.sns.sms.service.MmsService;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.time.LocalDateTime;
import java.util.List;

@Controller
@AllArgsConstructor
public class MmsController {
    private MmsService mmsService;

    private CodeMngService codeMngService;

    private final Logger logger = LoggerFactory.getLogger(this.getClass());


    /* 게시글 목록 */

    @GetMapping("/snsad/mmslist")
    public String mmslist(Model model, @ModelAttribute("params") final SearchDto params) {
        List<MmsDto> mmslist = mmsService.getMmslist(params.getPage());

        double  count = Double.valueOf(mmsService.getMmsCount());
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

        model.addAttribute("mmslist", mmslist);
        model.addAttribute("pagination", pagination);

        List<CodeMngDto> codeMngList = codeMngService.getCodeMnglistAll("EGM","EGBODY");
        model.addAttribute("codeMngList", codeMngList);

        model.addAttribute("pageURL", "/snsad/mmslist");

        return "sns/mms/list";
    }

    @PostMapping("/snsad/mmspost")
    public String userpost(Principal principal, MmsDto mmsDto) {

        LocalDateTime now = LocalDateTime.now();

        // System.out.println(now);

        mmsService.savePost(mmsDto);

        return "redirect:/snsad/mmslist";
    }


    @GetMapping("/snsad/mmspost/{no}")
    public String Mmsdetail(@PathVariable("no") Long no, Model model) {
        MmsDto mmsDto = mmsService.getPost(no);

        model.addAttribute("mmsDto", mmsDto);
        return "sns/mms/read";
    }

    @PutMapping("/snsad/mmspost/edit/{no}")
    public String update(MmsDto MmsDto) {
        mmsService.savePost(MmsDto);

        return "redirect:/snsad/mmslist";
    }


    @GetMapping("/snsad/mmsdel")
    public String userdelete(@RequestParam(value="idx") String idx) {

        long no = 0;

        int beginIndex = idx.indexOf(",");

        if(beginIndex > 0){

            String[] ArraysStr = idx.split(",");

            for(String s : ArraysStr){
                no = Long.parseLong(s);
                mmsService.deletePost(no);
            }

        }else{

            no = Long.parseLong(idx);
            mmsService.deletePost(no);

        }
        return "redirect:/snsad/mmslist";
    }


    @PostMapping("/snsad/mmssearch")
    public String Mmssearch(@RequestParam(value="keyword") String keyword, @ModelAttribute("params") final SearchDto params , Model model) {

        logger.info("/snsad/Mmssearch ===>  keyword : "+ keyword);

        logger.info("/snsad/Mmssearch ==> getKeyword : "+params.getKeyword());

        logger.info("/snsad/Mmssearch ==> getSearchType : "+params.getSearchType());

        List<MmsDto> mmslist = mmsService.searchPosts(params);

        // 총 게시글 갯수
        double  count = Double.valueOf(mmslist.size());
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

        model.addAttribute("mmslist", mmslist);
        model.addAttribute("pagination", pagination);

        model.addAttribute("pageURL", "/snsad/mmssearch");


        return "sns/mms/list";
    }

}
