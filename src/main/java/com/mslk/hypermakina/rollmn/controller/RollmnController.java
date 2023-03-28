package com.mslk.hypermakina.rollmn.controller;

import com.mslk.common.paging.Pagination;
import com.mslk.common.paging.dto.SearchDto;
import com.mslk.hypermakina.rollmn.dto.Gittf0001Dto;
import com.mslk.hypermakina.rollmn.service.Gittf0001Service;
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
public class RollmnController {
    private Gittf0001Service gittf0001Service;
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    /* Main Page */
    @GetMapping("/admin/rollmn")
    public String list(Model model, @ModelAttribute("params") final SearchDto params) {
        List<Gittf0001Dto> gittf0001List = gittf0001Service.getGittf0001list(params.getPage());

        // 총 게시글 갯수
        double  count = Double.valueOf(gittf0001Service.getGitta001Count());
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

        model.addAttribute("gittf0001List", gittf0001List);
        model.addAttribute("pagination", pagination);

        model.addAttribute("pageURL", "/admin/rollmn");


        return "manager/rollmn/main.html";
    }

    @PostMapping("/admin/rollmnpost")
    public String rollmnpost(Principal principal, Gittf0001Dto gittf0001Dto) {

        LocalDateTime now = LocalDateTime.now();

        gittf0001Dto.setRgEn(principal.getName());
        gittf0001Dto.setAltEn(principal.getName());

        // System.out.println(now);

        gittf0001Service.savePost(gittf0001Dto);

        return "redirect:/admin/rollmn";
    }

    @GetMapping("/admin/rollmndel")
    public String rollmndelete(@RequestParam(value="idx") String idx) {

        long no = 0;

        int beginIndex = idx.indexOf(",");

        if(beginIndex > 0){

            String[] ArraysStr = idx.split(",");

            for(String s : ArraysStr){
                no = Long.parseLong(s);
                gittf0001Service.deletePost(no);
            }

        }else{

            no = Long.parseLong(idx);
            gittf0001Service.deletePost(no);

        }
        return "redirect:/admin/rollmn";
    }


}
