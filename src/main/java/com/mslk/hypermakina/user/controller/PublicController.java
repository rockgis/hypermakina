package com.mslk.hypermakina.user.controller;

import com.mslk.common.paging.Pagination;
import com.mslk.common.paging.dto.SearchDto;
import com.mslk.hypermakina.user.dto.Gitta0001Dto;
import com.mslk.hypermakina.user.dto.Gitta0002Dto;
import com.mslk.hypermakina.user.service.Gitta0001Service;
import com.mslk.hypermakina.user.service.Gitta0002Service;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
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
@Slf4j
@Controller
@AllArgsConstructor
public class PublicController {

    private Gitta0002Service gitta0002Service;

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @GetMapping("/admin/publiclist")
    public String publiclist(Model model, @ModelAttribute("params") final SearchDto params) {
        List<Gitta0002Dto> gitta0002List = gitta0002Service.getGitta0002list(params.getPage());

        double  count = Double.valueOf(gitta0002Service.getGitta002Count());
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

        model.addAttribute("gitta0002List", gitta0002List);
        model.addAttribute("pagination", pagination);

        model.addAttribute("pageURL", "/admin/publiclist");



        return "public/publiclist";
    }

    @PostMapping("/admin/publicpost")
    public String publicpost(Principal principal, Gitta0002Dto gitta0002Dto) {

        LocalDateTime now = LocalDateTime.now();

        gitta0002Dto.setAltEn(principal.getName());
        gitta0002Dto.setModifiedDate(now);
        // System.out.println(now);

        gitta0002Service.savePost(gitta0002Dto);

        return "redirect:/admin/publiclist";
    }


    @GetMapping("/admin/publicdel")
    public String publicdelete(@RequestParam(value="idx") String idx) {

        long no = 0;

        int beginIndex = idx.indexOf(",");

        if(beginIndex > 0){

            String[] ArraysStr = idx.split(",");

            for(String s : ArraysStr){
                no = Long.parseLong(s);
                gitta0002Service.deletePost(no);
            }

        }else{

            no = Long.parseLong(idx);
            gitta0002Service.deletePost(no);

        }
        return "redirect:/admin/publiclist";
    }

}
