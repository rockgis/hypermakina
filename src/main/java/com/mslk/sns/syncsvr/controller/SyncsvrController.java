package com.mslk.sns.syncsvr.controller;

import com.mslk.sns.syncsvr.dto.SyncsvrDto;
import com.mslk.sns.syncsvr.service.SyncsvrService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.time.LocalDateTime;
import java.util.List;

@Controller
@AllArgsConstructor
public class SyncsvrController {
    private SyncsvrService syncsvrService;


    /* 게시글 목록 */

    @GetMapping("/snsad/syncsvrlist")
    public String index(Model model, @RequestParam(value="page", defaultValue = "1") Integer pageNum) {
        List<SyncsvrDto> syncsvrlist = syncsvrService.getSyncsvrlist(pageNum);
        Integer[] pageList = syncsvrService.getPageList(pageNum);

        double  count = Double.valueOf(syncsvrService.getSyncsvrCount());
        Integer postsTotalCount = (int) count;

        model.addAttribute("syncsvrlist", syncsvrlist);
        model.addAttribute("pageList", pageList);
        model.addAttribute("postsTotalCount", postsTotalCount);

        return "sns/syncsvr/list";
    }

    @PostMapping("/snsad/syncsvrpost")
    public String positiopost(Principal principal, SyncsvrDto syncsvrDto) {

        LocalDateTime now = LocalDateTime.now();

        syncsvrDto.setModiId(principal.getName());

        syncsvrService.savePost(syncsvrDto);

        return "redirect:/snsad/syncsvrlist";
    }

    @GetMapping("/snsad/syncsvrpost/{no}")
    public String syncsvrdetail(@PathVariable("no") Long no, Model model) {
        SyncsvrDto syncsvrDto = syncsvrService.getPost(no);

        model.addAttribute("syncsvrDto", syncsvrDto);

        return "sns/syncsvr/read";
    }

    @PutMapping("/snsad/syncsvrpost/edit/{no}")
    public String update(SyncsvrDto syncsvrDto) {
        syncsvrService.savePost(syncsvrDto);

        return "redirect:/snsad/syncsvrlist";
    }


    @GetMapping("/snsad/syncsvrdel")
    public String userdelete(@RequestParam(value="idx") String idx) {

        long no = 0;

        int beginIndex = idx.indexOf(",");

        if(beginIndex > 0){

            String[] ArraysStr = idx.split(",");

            for(String s : ArraysStr){
                no = Long.parseLong(s);
                syncsvrService.deletePost(no);
            }

        }else{

            no = Long.parseLong(idx);
            syncsvrService.deletePost(no);

        }
        return "redirect:/snsad/syncsvrlist";
    }


    @PostMapping("/snsad/syncsvrsearch")
    public String usersearch(SyncsvrDto gitta0001Dto, Model model) {


        return "sns/syncsvr/list";
    }

}
