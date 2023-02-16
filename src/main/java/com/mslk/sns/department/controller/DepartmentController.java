package com.mslk.sns.department.controller;

import com.mslk.hypermakina.user.dto.Gitta0001Dto;
import com.mslk.hypermakina.user.service.Gitta0001Service;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;
import java.time.LocalDateTime;
import java.util.List;

@Controller
@AllArgsConstructor
public class DepartmentController {
    private Gitta0001Service gitta0001Service;


    /* 게시글 목록 */

    @GetMapping("/snsad/departmentlist")
    public String index(Model model, @RequestParam(value="page", defaultValue = "1") Integer pageNum) {
        List<Gitta0001Dto> gitta0001List = gitta0001Service.getGitta0001list(pageNum);
        Integer[] pageList = gitta0001Service.getPageList(pageNum);

        double  count = Double.valueOf(gitta0001Service.getGitta001Count());
        Integer postsTotalCount = (int) count;

        model.addAttribute("gitta0001List", gitta0001List);
        model.addAttribute("pageList", pageList);
        model.addAttribute("postsTotalCount", postsTotalCount);

        return "sns/departmentlist";
    }

    @PostMapping("/snsad/departmentpost")
    public String userpost(Principal principal, Gitta0001Dto gitta0001Dto) {

        LocalDateTime now = LocalDateTime.now();

        gitta0001Dto.setRgEn(principal.getName());

        // System.out.println(now);

        gitta0001Service.savePost(gitta0001Dto);

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
                gitta0001Service.deletePost(no);
            }

        }else{

            no = Long.parseLong(idx);
            gitta0001Service.deletePost(no);

        }
        return "redirect:/snsad/departmentlist";
    }


    @PostMapping("/snsad/departmentsearch")
    public String usersearch(Gitta0001Dto gitta0001Dto, Model model) {

        List<Gitta0001Dto> gitta0001DtoList = gitta0001Service.searchPosts(gitta0001Dto);

        double  count = Double.valueOf(gitta0001DtoList.size());
        Integer postsTotalCount = (int) count;

        model.addAttribute("gitta0001List", gitta0001DtoList);
        model.addAttribute("pageList", postsTotalCount);
        model.addAttribute("postsTotalCount", postsTotalCount);


        return "sns/departmentlist";
    }

}
