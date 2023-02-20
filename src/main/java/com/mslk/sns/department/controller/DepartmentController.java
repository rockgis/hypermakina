package com.mslk.sns.department.controller;

import com.mslk.sns.department.dto.DepartmentDto;
import com.mslk.sns.department.service.DepartmentService;
import com.mslk.sns.staff.dto.StaffDto;
import lombok.AllArgsConstructor;
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


    /* 게시글 목록 */

    @GetMapping("/snsad/departmentlist")
    public String index(Model model, @RequestParam(value="page", defaultValue = "1") Integer pageNum) {
        List<DepartmentDto> departmentlist = departmentService.getDepartmentlist(pageNum);
        Integer[] pageList = departmentService.getPageList(pageNum);

        double  count = Double.valueOf(departmentService.getDepartmentCount());
        Integer postsTotalCount = (int) count;

        model.addAttribute("departmentlist", departmentlist);
        model.addAttribute("pageList", pageList);
        model.addAttribute("postsTotalCount", postsTotalCount);

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


    @PostMapping("/snsad/departmentsearch")
    public String usersearch(DepartmentDto departmentDto, Model model) {


        return "sns/departmentlist";
    }

}
