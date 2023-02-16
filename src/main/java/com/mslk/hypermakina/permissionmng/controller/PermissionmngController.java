package com.mslk.hypermakina.permissionmng.controller;

import com.mslk.hypermakina.permissionmng.service.Gittc0001Service;
import com.mslk.hypermakina.permissionmng.dto.Gittc0001Dto;
import lombok.AllArgsConstructor;
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

    /* Main Page */
    @GetMapping("/admin/permissionmng")
    public String list(Model model, @RequestParam(value="page", defaultValue = "1") Integer pageNum) {
        List<Gittc0001Dto> gittc0001List = gittc0001Service.getGittc0001list(pageNum);
        Integer[] pageList = gittc0001Service.getPageList(pageNum);

        double  count = Double.valueOf(gittc0001Service.getGittc001Count());
        Integer postsTotalCount = (int) count;

        model.addAttribute("gittc0001List", gittc0001List);
        model.addAttribute("pageList", pageList);
        model.addAttribute("postsTotalCount", postsTotalCount);

        return "permissionmng/main.html";
    }

    @GetMapping("/admin/permissionmng/search")
    public String search(@RequestParam(value="keyword") String keyword, Model model) {
        //List<BoardDto> boardDtoList = boardService.searchPosts(keyword);

        return "permissionmng/main.html";
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
