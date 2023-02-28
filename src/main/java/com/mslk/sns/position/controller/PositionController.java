package com.mslk.sns.position.controller;

import com.mslk.common.paging.Pagination;
import com.mslk.common.paging.dto.SearchDto;
import com.mslk.sns.department.dto.DepartmentDto;
import com.mslk.sns.position.dto.PositionDto;
import com.mslk.sns.position.service.PositionService;
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
public class PositionController {
    private PositionService positionService;

    private final Logger logger = LoggerFactory.getLogger(this.getClass());


    /* 게시글 목록 */

    @GetMapping("/snsad/positionlist")
    public String index(Model model, @ModelAttribute("params") final SearchDto params) {
        List<PositionDto> positionlist = positionService.getPositionlist(params.getPage());

        double  count = Double.valueOf(positionService.getPositionCount());
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

        model.addAttribute("positionlist", positionlist);
        model.addAttribute("pagination", pagination);

        return "sns/position/list";
    }

    @PostMapping("/snsad/positionpost")
    public String positiopost(Principal principal, PositionDto positionDto) {

        LocalDateTime now = LocalDateTime.now();


        positionService.savePost(positionDto);

        return "redirect:/snsad/positionlist";
    }

    @GetMapping("/snsad/positionpost/{no}")
    public String positiondetail(@PathVariable("no") Long no, Model model) {
        PositionDto positionDto = positionService.getPost(no);

        model.addAttribute("positionDto", positionDto);
        return "sns/position/read";
    }

    @PutMapping("/snsad/positionpost/edit/{no}")
    public String update(PositionDto positionDto) {
        positionService.savePost(positionDto);

        return "redirect:/snsad/positionlist";
    }


    @GetMapping("/snsad/positiondel")
    public String userdelete(@RequestParam(value="idx") String idx) {

        long no = 0;

        int beginIndex = idx.indexOf(",");

        if(beginIndex > 0){

            String[] ArraysStr = idx.split(",");

            for(String s : ArraysStr){
                no = Long.parseLong(s);
                positionService.deletePost(no);
            }

        }else{

            no = Long.parseLong(idx);
            positionService.deletePost(no);

        }
        return "redirect:/snsad/positionlist";
    }


    @PostMapping("/snsad/positionsearch")
    public String usersearch(PositionDto gitta0001Dto, Model model) {


        return "sns/position/list";
    }

}
