package com.mslk.sns.staff.controller;

import com.mslk.common.paging.Pagination;
import com.mslk.common.paging.dto.SearchDto;
import com.mslk.hypermakina.board.dto.BoardDto;
import com.mslk.sns.staff.dto.StaffDto;
import com.mslk.sns.staff.service.StaffService;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.security.Principal;
import java.time.LocalDateTime;
import java.util.List;

@Controller
@AllArgsConstructor
public class StaffController {
    private StaffService staffService;

    private final Logger logger = LoggerFactory.getLogger(this.getClass());


    /* 게시글 목록 */

    @GetMapping("/snsad/stafflist")
    public String index(Model model, @ModelAttribute("params") final SearchDto params) {

        List<StaffDto> staffList = staffService.getStafflist(params.getPage());

        // 총 게시글 갯수
        double  count = Double.valueOf(staffService.getStaffCount());
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

        model.addAttribute("staffList", staffList);
        model.addAttribute("pagination", pagination);


        return "sns/staff/list";
    }


    @GetMapping("/snsad/post/{no}")
    public String staffdetail(@PathVariable("no") Long no, Model model) {
        StaffDto staffDto = staffService.getPost(no);

        model.addAttribute("staffDto", staffDto);
        return "sns/staff/read";
    }

    @PutMapping("/snsad/post/edit/{no}")
    public String update(StaffDto staffDto) {
        staffService.savePost(staffDto);

        return "redirect:/snsad/stafflist";
    }

    @PostMapping("/snsad/staffpost")
    public String userpost(Principal principal, StaffDto staffDto) {

        LocalDateTime now = LocalDateTime.now();

        // System.out.println(now);

        staffService.savePost(staffDto);

        return "redirect:/snsad/stafflist";
    }



    @PostMapping("/snsad/staffuppost")
    public String uppost(Principal principal, StaffDto staffDto) {

        LocalDateTime now = LocalDateTime.now();

        staffDto.setModifiedDate(now);

        staffService.savePost(staffDto);

        return "redirect:/snsad/stafflist";
    }


    @GetMapping("/snsad/staffdel")
    public String userdelete(@RequestParam(value="idx") String idx) {

        long no = 0;

        int beginIndex = idx.indexOf(",");

        if(beginIndex > 0){

            String[] ArraysStr = idx.split(",");

            for(String s : ArraysStr){
                no = Long.parseLong(s);
                staffService.deletePost(no);
            }

        }else{

            no = Long.parseLong(idx);
            staffService.deletePost(no);

        }
        return "redirect:/snsad/stafflist";
    }


    @PostMapping("/snsad/staffsearch")
    public String staffsearch(@RequestParam(value="keyword") String keyword, @ModelAttribute("params") final SearchDto params , Model model) {

        logger.info("/snsad/staffsearch ===>  keyword : "+ keyword);

        logger.info("/snsad/staffsearch ==> getKeyword : "+params.getKeyword());

        logger.info("/snsad/staffsearch ==> getSearchType : "+params.getSearchType());

        List<StaffDto> staffList = staffService.searchPosts(params);

        // 총 게시글 갯수
        double  count = Double.valueOf(staffList.size());
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

        model.addAttribute("staffList", staffList);
        model.addAttribute("pagination", pagination);


        return "sns/staff/list";
    }

}
