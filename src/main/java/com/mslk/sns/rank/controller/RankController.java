package com.mslk.sns.rank.controller;

import com.mslk.sns.rank.dto.RankDto;
import com.mslk.sns.rank.service.RankService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.time.LocalDateTime;
import java.util.List;

@Controller
@AllArgsConstructor
public class RankController {
    private RankService rankService;


    /* 게시글 목록 */

    @GetMapping("/snsad/ranklist")
    public String index(Model model, @RequestParam(value="page", defaultValue = "1") Integer pageNum) {
        List<RankDto> ranklist = rankService.getRanklist(pageNum);
        Integer[] pageList = rankService.getPageList(pageNum);

        double  count = Double.valueOf(rankService.getRankCount());
        Integer postsTotalCount = (int) count;

        model.addAttribute("ranklist", ranklist);
        model.addAttribute("pageList", pageList);
        model.addAttribute("postsTotalCount", postsTotalCount);

        return "sns/rank/list";
    }

    @PostMapping("/snsad/rankpost")
    public String positiopost(Principal principal, RankDto rankDto) {

        LocalDateTime now = LocalDateTime.now();


        rankService.savePost(rankDto);

        return "redirect:/snsad/ranklist";
    }

    @GetMapping("/snsad/rankpost/{no}")
    public String rankdetail(@PathVariable("no") Long no, Model model) {
        RankDto rankDto = rankService.getPost(no);

        model.addAttribute("rankDto", rankDto);
        return "sns/rank/read";
    }

    @PutMapping("/snsad/rankpost/edit/{no}")
    public String update(RankDto rankDto) {
        rankService.savePost(rankDto);

        return "redirect:/snsad/ranklist";
    }


    @GetMapping("/snsad/rankdel")
    public String userdelete(@RequestParam(value="idx") String idx) {

        long no = 0;

        int beginIndex = idx.indexOf(",");

        if(beginIndex > 0){

            String[] ArraysStr = idx.split(",");

            for(String s : ArraysStr){
                no = Long.parseLong(s);
                rankService.deletePost(no);
            }

        }else{

            no = Long.parseLong(idx);
            rankService.deletePost(no);

        }
        return "redirect:/snsad/ranklist";
    }


    @PostMapping("/snsad/ranksearch")
    public String usersearch(RankDto gitta0001Dto, Model model) {


        return "sns/rank/list";
    }
}
