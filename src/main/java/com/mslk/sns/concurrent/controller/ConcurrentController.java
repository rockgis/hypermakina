package com.mslk.sns.concurrent.controller;

import com.mslk.common.paging.Pagination;
import com.mslk.common.paging.dto.SearchDto;
import com.mslk.sns.concurrent.dto.ConcurrentDto;
import com.mslk.sns.concurrent.service.ConcurrentService;
import com.mslk.sns.department.dto.DepartmentDto;
import com.mslk.sns.department.service.DepartmentService;
import com.mslk.sns.position.dto.PositionDto;
import com.mslk.sns.position.service.PositionService;
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
public class ConcurrentController {
    private ConcurrentService concurrentService;

    private RankService rankService;

    private PositionService positionService;

    private DepartmentService departmentService;

    private final Logger logger = LoggerFactory.getLogger(this.getClass());


    /* 게시글 목록 */

    @GetMapping("/snsad/concurrentlist")
    public String concurrentlist(Model model, @ModelAttribute("params") final SearchDto params) {

        List<ConcurrentDto> concurrentList = concurrentService.getConcurrentlist(params.getPage());

        // 총 게시글 갯수
        double  count = Double.valueOf(concurrentService.getConcurrentCount());
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

        model.addAttribute("concurrentList", concurrentList);
        model.addAttribute("pagination", pagination);

        List<RankDto> ranklist = rankService.getRanklistAll();

        model.addAttribute("ranklist", ranklist);


        List<PositionDto> positionlist = positionService.getPositionlistAll();
        model.addAttribute("positionlist", positionlist);


        List<DepartmentDto> departmentlist = departmentService.getDepartmentlistAll();
        model.addAttribute("departmentlist", departmentlist);



        return "sns/concurrent/list";
    }


    @GetMapping("/snsad/concurrentpost/{no}")
    public String concurrentdetail(@PathVariable("no") Long no, Model model) {
        ConcurrentDto concurrentDto = concurrentService.getPost(no);

        model.addAttribute("concurrentDto", concurrentDto);

        List<RankDto> ranklist = rankService.getRanklistAll();

        model.addAttribute("ranklist", ranklist);


        List<PositionDto> positionlist = positionService.getPositionlistAll();
        model.addAttribute("positionlist", positionlist);


        List<DepartmentDto> departmentlist = departmentService.getDepartmentlistAll();
        model.addAttribute("departmentlist", departmentlist);

        return "sns/concurrent/read";
    }

    @PutMapping("/snsad/concurrentpost/edit/{no}")
    public String update(ConcurrentDto concurrentDto) {
        concurrentService.savePost(concurrentDto);

        return "redirect:/snsad/concurrentlist";
    }

    @PostMapping("/snsad/concurrentpost")
    public String userpost(Principal principal, ConcurrentDto concurrentDto) {

        LocalDateTime now = LocalDateTime.now();

        // System.out.println(now);

        concurrentService.savePost(concurrentDto);

        return "redirect:/snsad/concurrentlist";
    }



    @PostMapping("/snsad/concurrentuppost")
    public String uppost(Principal principal, ConcurrentDto concurrentDto) {

        LocalDateTime now = LocalDateTime.now();

        concurrentDto.setModifiedDate(now);

        concurrentService.savePost(concurrentDto);

        return "redirect:/snsad/concurrentlist";
    }


    @GetMapping("/snsad/concurrentdel")
    public String userdelete(@RequestParam(value="idx") String idx) {

        long no = 0;

        int beginIndex = idx.indexOf(",");

        if(beginIndex > 0){

            String[] ArraysStr = idx.split(",");

            for(String s : ArraysStr){
                no = Long.parseLong(s);
                concurrentService.deletePost(no);
            }

        }else{

            no = Long.parseLong(idx);
            concurrentService.deletePost(no);

        }
        return "redirect:/snsad/concurrentlist";
    }


    @PostMapping("/snsad/concurrentsearch")
    public String concurrentsearch(@RequestParam(value="keyword") String keyword, @ModelAttribute("params") final SearchDto params , Model model) {

        logger.info("/snsad/concurrentsearch ===>  keyword : "+ keyword);

        logger.info("/snsad/concurrentsearch ==> getKeyword : "+params.getKeyword());

        logger.info("/snsad/concurrentsearch ==> getSearchType : "+params.getSearchType());

        List<ConcurrentDto> concurrentList = concurrentService.searchPosts(params);

        // 총 게시글 갯수
        double  count = Double.valueOf(concurrentList.size());
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

        model.addAttribute("concurrentList", concurrentList);
        model.addAttribute("pagination", pagination);


        return "sns/concurrent/list";
    }

}
