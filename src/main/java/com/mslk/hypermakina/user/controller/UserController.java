package com.mslk.hypermakina.user.controller;

import com.mslk.common.paging.Pagination;
import com.mslk.common.paging.dto.SearchDto;
import com.mslk.hypermakina.user.service.Gitta0001Service;
import com.mslk.hypermakina.user.service.Gitta0002Service;
import com.mslk.hypermakina.user.dto.Gitta0001Dto;

import com.mslk.hypermakina.user.dto.Gitta0002Dto;

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
public class UserController {
    private Gitta0001Service gitta0001Service;

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    /* 게시글 목록 */

    @GetMapping("/admin/userlist")
    public String index(Model model, @ModelAttribute("params") final SearchDto params) {
        List<Gitta0001Dto> gitta0001List = gitta0001Service.getGitta0001list(params.getPage());

        double  count = Double.valueOf(gitta0001Service.getGitta001Count());
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

        model.addAttribute("gitta0001List", gitta0001List);
        model.addAttribute("pagination", pagination);

        model.addAttribute("pageURL", "/admin/userlist");

        return "admin/userlist";
    }

    @PostMapping("/admin/userpost")
    public String userpost(Principal principal, Gitta0001Dto gitta0001Dto) {

        LocalDateTime now = LocalDateTime.now();

        gitta0001Dto.setRgEn(principal.getName());

        // System.out.println(now);

        gitta0001Service.savePost(gitta0001Dto);

        return "redirect:/admin/userlist";
    }


    @GetMapping("/admin/userdel")
    public String userdelete(@RequestParam(value="idx") String idx) {

        long no = 0;

        int beginIndex = idx.indexOf(",");

        if(beginIndex > 0){

            String[] ArraysStr = idx.split(",");

            for(String s : ArraysStr){
                no = Long.parseLong(s);
                gitta0001Service.deletePost(no);
            }

        }else{

            no = Long.parseLong(idx);
            gitta0001Service.deletePost(no);

        }
        return "redirect:/admin/userlist";
    }


    @PostMapping("/admin/usersearch")
    public String usersearch(Gitta0001Dto gitta0001Dto, Model model) {

        List<Gitta0001Dto> gitta0001DtoList = gitta0001Service.searchPosts(gitta0001Dto);

        double  count = Double.valueOf(gitta0001DtoList.size());
        Integer postsTotalCount = (int) count;

        model.addAttribute("gitta0001List", gitta0001DtoList);
        model.addAttribute("pageList", postsTotalCount);
        model.addAttribute("postsTotalCount", postsTotalCount);


        return "admin/userlist";
    }

}
