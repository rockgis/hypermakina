package com.mslk.hypermakina.code.controller;

import com.mslk.hypermakina.code.dto.CodeMngDto;
import com.mslk.hypermakina.code.service.CodeMngService;
import com.mslk.hypermakina.board.service.BoardService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.oauth2.client.web.OAuth2AuthorizationRequestRedirectFilter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;
import java.time.LocalDateTime;
import java.util.List;

@Slf4j
@Controller
@AllArgsConstructor
public class CodeMngController {

    private static String authorizationRequestBaseUri = OAuth2AuthorizationRequestRedirectFilter.DEFAULT_AUTHORIZATION_REQUEST_BASE_URI;

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    private BoardService boardService;

    private CodeMngService codeMngService;




    @GetMapping("/admin/codemnglist")
    public String codemnglist(Principal principal, Model model, @RequestParam(value="page", defaultValue = "1") Integer pageNum) {

        List<CodeMngDto> codeMngList = codeMngService.getCodeMnglist(pageNum);
        Integer[] pageList = codeMngService.getPageList(pageNum);

        double  count = Double.valueOf(codeMngService.getCodeMngCount());
        Integer postsTotalCount = (int) count;

        model.addAttribute("codeMngList", codeMngList);
        model.addAttribute("pageList", pageList);
        model.addAttribute("page", pageNum);
        model.addAttribute("postsTotalCount", postsTotalCount);

        return "system/codemng//index";
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


    @PostMapping("/admin/codemngearch")
    public String codemngearch(CodeMngDto codeMngDto, Model model) {

        List<CodeMngDto> codeMngList = codeMngService.getCodeMnglist(10); //hyperRestApiService.searchPosts(hyperRestApiDto);
        Integer[] pageList = codeMngService.getPageList(10);

        double  count = Double.valueOf(codeMngList.size());
        Integer postsTotalCount = (int) count;

        model.addAttribute("codeMngList", codeMngList);
        model.addAttribute("pageList", pageList);
        model.addAttribute("postsTotalCount", postsTotalCount);


        return "system/codemng/index";
    }
}
