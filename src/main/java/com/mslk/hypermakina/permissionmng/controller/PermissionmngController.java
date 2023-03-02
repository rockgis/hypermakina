package com.mslk.hypermakina.permissionmng.controller;

import com.mslk.common.paging.Pagination;
import com.mslk.common.paging.dto.SearchDto;
import com.mslk.hypermakina.permissionmng.service.Gittc0001Service;
import com.mslk.hypermakina.permissionmng.dto.Gittc0001Dto;
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
public class PermissionmngController {

    private Gittc0001Service gittc0001Service;

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    /* Main Page */
    @GetMapping("/admin/permissionmng")
    public String list(Model model, @ModelAttribute("params") final SearchDto params) {
        List<Gittc0001Dto> gittc0001List = gittc0001Service.getGittc0001list(params.getPage());


        double  count = Double.valueOf(gittc0001Service.getGittc001Count());
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

        model.addAttribute("gittc0001List", gittc0001List);
        model.addAttribute("pagination", pagination);


        return "manager/permissionmng/main.html";
    }

    @GetMapping("/admin/permissionmng/search")
    public String search(@RequestParam(value="keyword") String keyword, Model model) {
        //List<BoardDto> boardDtoList = boardService.searchPosts(keyword);

        return "manager/permissionmng/main.html";
    }

    @PostMapping("/admin/permissionpost")
    public String permissionpost(Principal principal, Gittc0001Dto gittc0001Dto) {

        LocalDateTime now = LocalDateTime.now();
        gittc0001Dto.setAltEn(principal.getName());

        gittc0001Dto.setModifiedDate(now);

        // System.out.println(now);

        gittc0001Service.savePost(gittc0001Dto);

        return "redirect:/admin/permissionmng";
    }


    @GetMapping("/admin/permissiondel")
    public String permissiondelete(@RequestParam(value="idx") String idx) {

        long no = 0;

        int beginIndex = idx.indexOf(",");

        if(beginIndex > 0){

            String[] ArraysStr = idx.split(",");

            for(String s : ArraysStr){
                no = Long.parseLong(s);
                gittc0001Service.deletePost(no);
            }

        }else{

            no = Long.parseLong(idx);
            gittc0001Service.deletePost(no);

        }
        return "redirect:/admin/permissionmng";
    }

}
