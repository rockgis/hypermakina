package com.mslk.sns.position.controller;

import com.mslk.sns.department.dto.DepartmentDto;
import com.mslk.sns.position.dto.PositionDto;
import com.mslk.sns.position.service.PositionService;
import lombok.AllArgsConstructor;
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


    /* 게시글 목록 */

    @GetMapping("/snsad/positionlist")
    public String index(Model model, @RequestParam(value="page", defaultValue = "1") Integer pageNum) {
        List<PositionDto> positionlist = positionService.getPositionlist(pageNum);
        Integer[] pageList = positionService.getPageList(pageNum);

        double  count = Double.valueOf(positionService.getPositionCount());
        Integer postsTotalCount = (int) count;

        model.addAttribute("positionlist", positionlist);
        model.addAttribute("pageList", pageList);
        model.addAttribute("postsTotalCount", postsTotalCount);

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
