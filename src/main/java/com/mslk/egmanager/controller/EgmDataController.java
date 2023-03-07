package com.mslk.egmanager.controller;

import com.mslk.egmanager.dto.EgmDataDto;
import com.mslk.egmanager.dto.EgmMetaDto;
import com.mslk.egmanager.service.EgmDataService;
import com.mslk.egmanager.service.EgmMetaService;
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
public class EgmDataController {

    private static String authorizationRequestBaseUri = OAuth2AuthorizationRequestRedirectFilter.DEFAULT_AUTHORIZATION_REQUEST_BASE_URI;

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    private EgmDataService egmDataService;


    @PostMapping("/admin/egmdatapost")
    public String egmdatapost(Principal principal, EgmDataDto egmDataDto) {

        LocalDateTime now = LocalDateTime.now();

        egmDataDto.setAltEn(principal.getName());

        String metaId = egmDataDto.getMetaId().toString();

        egmDataService.savePost(egmDataDto);

        return "redirect:/egmmeta/post/"+metaId;
    }


    @GetMapping("/admin/egmdatadel")
    public String egmdatadel(@RequestParam(value="idx") String idx, @RequestParam(value="metaId") String metaId) {

        long no = 0;

        int beginIndex = idx.indexOf(",");

        if(beginIndex > 0){

            String[] ArraysStr = idx.split(",");

            for(String s : ArraysStr){
                no = Long.parseLong(s);
                egmDataService.deletePost(no);
            }

        }else{

            no = Long.parseLong(idx);
            egmDataService.deletePost(no);

        }
        return "redirect:/egmmeta/post/"+metaId;
    }


    @GetMapping("/egmdata/post/{no}")
    public String egndatadetail(@PathVariable("no") Long no, Model model) {
        EgmDataDto egmDataDto = egmDataService.getPost(no);

        model.addAttribute("egmDataDto", egmDataDto);

        logger.info("no : "+ no);


        return "egmmeta/restmnt/read";
    }

    @PutMapping("/egmdata/post/edit/{no}")
    public String update(EgmDataDto egmDataDto, @RequestParam(value="metaId") String metaId) {
        egmDataService.savePost(egmDataDto);

        return "redirect:/egmmeta/post/"+metaId;
    }




}
