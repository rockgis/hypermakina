package com.mslk.sns.staff.controller;

import com.mslk.hypermakina.board.dto.BoardDto;
import com.mslk.sns.staff.dto.StaffDto;
import com.mslk.sns.staff.service.StaffService;
import lombok.AllArgsConstructor;
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


    /* 게시글 목록 */

    @GetMapping("/snsad/stafflist")
    public String index(Model model, @RequestParam(value="page", defaultValue = "1") Integer pageNum) {
        List<StaffDto> staffList = staffService.getStafflist(pageNum);
        Integer[] pageList = staffService.getPageList(pageNum);

        double  count = Double.valueOf(staffService.getStaffCount());
        Integer postsTotalCount = (int) count;

        model.addAttribute("staffList", staffList);
        model.addAttribute("pageList", pageList);
        model.addAttribute("postsTotalCount", postsTotalCount);

        return "sns/stafflist";
    }


    @GetMapping("/snsad/post/{no}")
    public String staffdetail(@PathVariable("no") Long no, Model model) {
        StaffDto staffDto = staffService.getPost(no);

        model.addAttribute("staffDto", staffDto);
        return "sns/staffread";
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
    public String usersearch(StaffDto staffDto, Model model) {

        /* List<StaffDto> gitta0001DtoList = staffService.searchPosts(gitta0001Dto);

        double  count = Double.valueOf(gitta0001DtoList.size());
        Integer postsTotalCount = (int) count;

        model.addAttribute("gitta0001List", gitta0001DtoList);
        model.addAttribute("pageList", postsTotalCount);
        model.addAttribute("postsTotalCount", postsTotalCount);

         */


        return "sns/stafflist";
    }

}
