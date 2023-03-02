package com.mslk.sns.syncsvr.controller;

import com.mslk.common.paging.Pagination;
import com.mslk.common.paging.dto.SearchDto;
import com.mslk.sns.rank.dto.RankDto;
import com.mslk.sns.syncsvr.dto.SyncsvrDto;
import com.mslk.sns.syncsvr.service.SyncsvrService;
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
public class SyncsvrController {
    private SyncsvrService syncsvrService;

    private final Logger logger = LoggerFactory.getLogger(this.getClass());


    /* 게시글 목록 */

    @GetMapping("/snsad/syncsvrlist")
    public String index(Model model,@ModelAttribute("params") final SearchDto params) {
        List<SyncsvrDto> syncsvrlist = syncsvrService.getSyncsvrlist(params.getPage());

        double  count = Double.valueOf(syncsvrService.getSyncsvrCount());
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

        model.addAttribute("syncsvrlist", syncsvrlist);
        model.addAttribute("pagination", pagination);

        return "sns/syncsvr/list";
    }

    @PostMapping("/snsad/syncsvrpost")
    public String positiopost(Principal principal, SyncsvrDto syncsvrDto) {

        LocalDateTime now = LocalDateTime.now();

        syncsvrDto.setModiId(principal.getName());

        syncsvrService.savePost(syncsvrDto);

        return "redirect:/snsad/syncsvrlist";
    }

    @GetMapping("/snsad/syncsvrpost/{no}")
    public String syncsvrdetail(@PathVariable("no") Long no, Model model) {
        SyncsvrDto syncsvrDto = syncsvrService.getPost(no);

        model.addAttribute("syncsvrDto", syncsvrDto);

        return "sns/syncsvr/read";
    }

    @PutMapping("/snsad/syncsvrpost/edit/{no}")
    public String update(SyncsvrDto syncsvrDto) {
        syncsvrService.savePost(syncsvrDto);

        return "redirect:/snsad/syncsvrlist";
    }


    @GetMapping("/snsad/syncsvrdel")
    public String userdelete(@RequestParam(value="idx") String idx) {

        long no = 0;

        int beginIndex = idx.indexOf(",");

        if(beginIndex > 0){

            String[] ArraysStr = idx.split(",");

            for(String s : ArraysStr){
                no = Long.parseLong(s);
                syncsvrService.deletePost(no);
            }

        }else{

            no = Long.parseLong(idx);
            syncsvrService.deletePost(no);

        }
        return "redirect:/snsad/syncsvrlist";
    }


    @PostMapping("/snsad/syncsvrsearch")
    public String syncsvrsearch(@RequestParam(value="keyword") String keyword, @ModelAttribute("params") final SearchDto params , Model model) {

        logger.info("/snsad/syncsvrsearch ===>  keyword : "+ keyword);

        logger.info("/snsad/syncsvrsearch ==> getKeyword : "+params.getKeyword());

        logger.info("/snsad/syncsvrsearch ==> getSearchType : "+params.getSearchType());

        List<SyncsvrDto> syncsvrlist = syncsvrService.searchPosts(params);

        // 총 게시글 갯수
        double  count = Double.valueOf(syncsvrlist.size());
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

        model.addAttribute("syncsvrlist", syncsvrlist);
        model.addAttribute("pagination", pagination);

        return "sns/syncsvr/list";
    }

}
