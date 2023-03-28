package com.mslk.sns.department.controller;

import com.mslk.common.paging.Pagination;
import com.mslk.common.paging.dto.SearchDto;
import com.mslk.sns.department.dto.DepartmentDto;
import com.mslk.sns.department.service.DepartmentService;
import com.mslk.sns.staff.dto.StaffDto;
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
public class DepartmentController {
    private DepartmentService departmentService;

    private final Logger logger = LoggerFactory.getLogger(this.getClass());


    /* 게시글 목록 */

    @GetMapping("/snsad/departmentlist")
    public String index(Model model, @ModelAttribute("params") final SearchDto params) {
        List<DepartmentDto> departmentlist = departmentService.getDepartmentlist(params.getPage());

        double  count = Double.valueOf(departmentService.getDepartmentCount());
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

        model.addAttribute("departmentlist", departmentlist);
        model.addAttribute("pagination", pagination);

        List<DepartmentDto> departmentlist_top = departmentService.getDepartmentlistAll();
        model.addAttribute("departmentlist_top", departmentlist_top);

        model.addAttribute("pageURL", "/snsad/departmentlist");

        return "sns/department/list";
    }

    @PostMapping("/snsad/departmentpost")
    public String userpost(Principal principal, DepartmentDto departmentDto) {

        LocalDateTime now = LocalDateTime.now();

        // System.out.println(now);

        departmentService.savePost(departmentDto);

        return "redirect:/snsad/departmentlist";
    }


    @GetMapping("/snsad/departmentpost/{no}")
    public String departmentdetail(@PathVariable("no") Long no, Model model) {
        DepartmentDto departmentDto = departmentService.getPost(no);

        model.addAttribute("departmentDto", departmentDto);
        return "sns/department/read";
    }

    @PutMapping("/snsad/departmentpost/edit/{no}")
    public String update(DepartmentDto departmentDto) {
        departmentService.savePost(departmentDto);

        return "redirect:/snsad/departmentlist";
    }


    @GetMapping("/snsad/departmentdel")
    public String userdelete(@RequestParam(value="idx") String idx) {

        long no = 0;

        int beginIndex = idx.indexOf(",");

        if(beginIndex > 0){

            String[] ArraysStr = idx.split(",");

            for(String s : ArraysStr){
                no = Long.parseLong(s);
                departmentService.deletePost(no);
            }

        }else{

            no = Long.parseLong(idx);
            departmentService.deletePost(no);

        }
        return "redirect:/snsad/departmentlist";
    }

    @GetMapping("/snsad/departmentdelyn")
    public String departmentdelyn(@RequestParam(value="idx") String idx) {

        DepartmentDto departmentDto = new DepartmentDto();

        long no = 0;

        int beginIndex = idx.indexOf(",");

        if(beginIndex > 0){

            String[] ArraysStr = idx.split(",");

            for(String s : ArraysStr){
                no = Long.parseLong(s);

                departmentDto = departmentService.getPost(no);

                departmentDto.setDel(1);

                departmentService.savePost(departmentDto);
            }

        }else{

            no = Long.parseLong(idx);
            departmentDto = departmentService.getPost(no);

            departmentDto.setDel(1);

            departmentService.savePost(departmentDto);

        }
        return "redirect:/snsad/departmentlist";
    }


    @PostMapping("/snsad/departmentsearch")
    public String departmentsearch(@RequestParam(value="keyword") String keyword, @ModelAttribute("params") final SearchDto params , Model model) {

        logger.info("/snsad/departmentsearch ===>  keyword : "+ keyword);

        logger.info("/snsad/departmentsearch ==> getKeyword : "+params.getKeyword());

        logger.info("/snsad/departmentsearch ==> getSearchType : "+params.getSearchType());

        List<DepartmentDto> departmentlist = departmentService.searchPosts(params);

        // 총 게시글 갯수
        double  count = Double.valueOf(departmentlist.size());
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

        model.addAttribute("departmentlist", departmentlist);
        model.addAttribute("pagination", pagination);

        model.addAttribute("pageURL", "/snsad/departmentsearch");


        return "sns/department/list";
    }

}
