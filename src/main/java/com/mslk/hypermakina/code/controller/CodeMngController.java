package com.mslk.hypermakina.code.controller;

import com.mslk.common.paging.Pagination;
import com.mslk.common.paging.dto.SearchDto;
import com.mslk.hypermakina.code.dto.CodeMngDto;
import com.mslk.hypermakina.code.service.CodeMngService;
import com.mslk.hypermakina.board.service.BoardService;
import com.mslk.sns.position.dto.PositionDto;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.oauth2.client.web.OAuth2AuthorizationRequestRedirectFilter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.time.LocalDateTime;
import java.util.List;

@Slf4j
@Controller
@AllArgsConstructor
public class CodeMngController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    private CodeMngService codeMngService;




    @GetMapping("/admin/codemnglist")
    public String codemnglist(Principal principal, Model model, @ModelAttribute("params") final SearchDto params) {

        List<CodeMngDto> codeMngList = codeMngService.getCodeMnglist(params.getPage());

        double  count = Double.valueOf(codeMngService.getCodeMngCount());
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

        model.addAttribute("codeMngList", codeMngList);
        model.addAttribute("pagination", pagination);

        model.addAttribute("pageURL", "/admin/codemnglist");

        return "system/codemng/index";
    }


    @PostMapping("/admin/codemngpost")
    public String codemngpost(Principal principal, CodeMngDto codeMngDto) {

        LocalDateTime now = LocalDateTime.now();

        codeMngDto.setAltEn(principal.getName());

        // System.out.println(now);

        codeMngService.savePost(codeMngDto);

        return "redirect:/admin/codemnglist";
    }


    @GetMapping("/admin/codemngdel")
    public String codemngdelete(@RequestParam(value="idx") String idx) {

        long no = 0;

        int beginIndex = idx.indexOf(",");

        if(beginIndex > 0){

            String[] ArraysStr = idx.split(",");

            for(String s : ArraysStr){
                no = Long.parseLong(s);
                codeMngService.deletePost(no);
            }

        }else{

            no = Long.parseLong(idx);
            codeMngService.deletePost(no);

        }
        return "redirect:/admin/codemnglist";
    }

    @GetMapping("/admin/codemngpost/{no}")
    public String positiondetail(@PathVariable("no") Long no, Model model) {
        CodeMngDto codeMngDto = codeMngService.getPost(no);

        model.addAttribute("codeMngDto", codeMngDto);
        return "system/codemng/read";
    }

    @PutMapping("/admin/codemngpost/edit/{no}")
    public String update(Principal principal, CodeMngDto codeMngDto ) {

        LocalDateTime now = LocalDateTime.now();

        codeMngDto.setAltEn(principal.getName());


        codeMngService.savePost(codeMngDto);

        return "redirect:/admin/codemnglist";
    }


    @PostMapping("/admin/codemngearch")
    public String codemngearch(CodeMngDto codeMngDto, Model model) {


        return "system/codemng/index";
    }
}
