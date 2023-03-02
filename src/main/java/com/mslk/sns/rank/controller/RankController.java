package com.mslk.sns.rank.controller;

import com.mslk.common.paging.Pagination;
import com.mslk.common.paging.dto.SearchDto;
import com.mslk.sns.position.dto.PositionDto;
import com.mslk.sns.rank.dto.RankDto;
import com.mslk.sns.rank.service.RankService;
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
public class RankController {
    private RankService rankService;

    private final Logger logger = LoggerFactory.getLogger(this.getClass());


    /* 게시글 목록 */

    @GetMapping("/snsad/ranklist")
    public String index(Model model, @ModelAttribute("params") final SearchDto params) {
        List<RankDto> ranklist = rankService.getRanklist(params.getPage());

        double  count = Double.valueOf(rankService.getRankCount());
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

        model.addAttribute("ranklist", ranklist);
        model.addAttribute("pagination", pagination);

        return "sns/rank/list";
    }

    @PostMapping("/snsad/rankpost")
    public String positiopost(Principal principal, RankDto rankDto) {

        LocalDateTime now = LocalDateTime.now();


        rankService.savePost(rankDto);

        return "redirect:/snsad/ranklist";
    }

    @GetMapping("/snsad/rankpost/{no}")
    public String rankdetail(@PathVariable("no") Long no, Model model) {
        RankDto rankDto = rankService.getPost(no);

        model.addAttribute("rankDto", rankDto);
        return "sns/rank/read";
    }

    @PutMapping("/snsad/rankpost/edit/{no}")
    public String update(RankDto rankDto) {
        rankService.savePost(rankDto);

        return "redirect:/snsad/ranklist";
    }


    @GetMapping("/snsad/rankdel")
    public String userdelete(@RequestParam(value="idx") String idx) {

        long no = 0;

        int beginIndex = idx.indexOf(",");

        if(beginIndex > 0){

            String[] ArraysStr = idx.split(",");

            for(String s : ArraysStr){
                no = Long.parseLong(s);
                rankService.deletePost(no);
            }

        }else{

            no = Long.parseLong(idx);
            rankService.deletePost(no);

        }
        return "redirect:/snsad/ranklist";
    }


    @PostMapping("/snsad/ranksearch")
    public String ranksearch(@RequestParam(value="keyword") String keyword, @ModelAttribute("params") final SearchDto params , Model model) {

        logger.info("/snsad/ranksearch ===>  keyword : "+ keyword);

        logger.info("/snsad/ranksearch ==> getKeyword : "+params.getKeyword());

        logger.info("/snsad/ranksearch ==> getSearchType : "+params.getSearchType());

        List<RankDto> ranklist = rankService.searchPosts(params);

        // 총 게시글 갯수
        double  count = Double.valueOf(ranklist.size());
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

        model.addAttribute("ranklist", ranklist);
        model.addAttribute("pagination", pagination);

        return "sns/rank/list";
    }
}
