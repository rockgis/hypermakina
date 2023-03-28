package com.mslk.hypermakina.ipusenm.controller;

import com.mslk.common.paging.Pagination;
import com.mslk.common.paging.dto.SearchDto;
import com.mslk.hypermakina.ipusenm.dto.Gittf0002Dto;
import com.mslk.hypermakina.ipusenm.service.Gittf0002Service;
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
public class IpusenmController {
    private Gittf0002Service gittf0002Service;

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    /* Main Page */
    @GetMapping("/admin/ipusenm")
    public String list(Model model, @ModelAttribute("params") final SearchDto params) {

        List<Gittf0002Dto> gittf0002List = gittf0002Service.getGittf0002list(params.getPage());

        double  count = Double.valueOf(gittf0002Service.getGitta002Count());
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

        model.addAttribute("gittf0002List", gittf0002List);
        model.addAttribute("pagination", pagination);

        model.addAttribute("pageURL", "/admin/ipusenm");



        return "manager/ipusenm/main.html";
    }

    @PostMapping("/admin/ipusenmpost")
    public String ipusenmpost(Principal principal, Gittf0002Dto gittf0002Dto) {

        LocalDateTime now = LocalDateTime.now();

        gittf0002Dto.setRgEn(principal.getName());
        gittf0002Dto.setAltEn(principal.getName());

        // System.out.println(now);

        gittf0002Service.savePost(gittf0002Dto);

        return "redirect:/admin/ipusenm";
    }

    @GetMapping("/admin/ipusenmdel")
    public String ipusenmdelete(@RequestParam(value="idx") String idx) {

        long no = 0;

        int beginIndex = idx.indexOf(",");

        if(beginIndex > 0){

            String[] ArraysStr = idx.split(",");

            for(String s : ArraysStr){
                no = Long.parseLong(s);
                gittf0002Service.deletePost(no);
            }

        }else{

            no = Long.parseLong(idx);
            gittf0002Service.deletePost(no);

        }
        return "redirect:/admin/ipusenm";
    }

}
