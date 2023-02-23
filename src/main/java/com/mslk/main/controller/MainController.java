package com.mslk.main.controller;

import com.mslk.dashboard.service.DashBoardMngService;
import com.mslk.egmanager.service.EgmMetaService;
import com.mslk.hypermakina.board.dto.BoardDto;
import com.mslk.hypermakina.board.service.BoardService;
import com.mslk.hypermakina.inspectionmng.service.Gittd0004Service;
import com.mslk.hypermakina.permissionmng.dto.Gittc0001Dto;
import com.mslk.hypermakina.permissionmng.service.Gittc0001Service;
import com.mslk.restapi.service.HyperRestApiService;
import com.mslk.sns.staff.service.StaffService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.client.web.OAuth2AuthorizationRequestRedirectFilter;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;
import java.util.List;

@Slf4j
@Controller
@AllArgsConstructor
public class MainController {
    private BoardService boardService;


    private Gittd0004Service gittd0004Service;

    private Gittc0001Service gittc0001Service;


    private EgmMetaService egmMetaService;

    private StaffService staffService;

    private HyperRestApiService hyperRestApiService;

    private DashBoardMngService dashBoardMngService;


    private static String authorizationRequestBaseUri = OAuth2AuthorizationRequestRedirectFilter.DEFAULT_AUTHORIZATION_REQUEST_BASE_URI;

    private final Logger logger = LoggerFactory.getLogger(this.getClass());


    /* Main Page */
    @GetMapping("/")
    public String main(Authentication authentication, Model model) {

        if (authentication != null) {
            logger.info("타입정보 : " + authentication.getClass());
            logger.info("권한 정보 : " + authentication.getAuthorities().toString().equals("[ROLE_ADMIN]"));

            // 세션 정보 객체 반환
            WebAuthenticationDetails web = (WebAuthenticationDetails) authentication.getDetails();
            logger.info("세션ID : " + web.getSessionId());
            logger.info("접속IP : " + web.getRemoteAddress());

            if (authentication.getAuthorities().toString().equals("[ROLE_ADMIN]")) {
                return "redirect:/admin";
            } else {
                return "redirect:/user";
            }

        } else {

            return "redirect:/dashboard";

        }


    }

    @GetMapping("/admin")
    public String admin(Principal principal, Model model, @RequestParam(value = "page", defaultValue = "1") Integer pageNum) {

        List<BoardDto> boardList = boardService.getBoardlist(pageNum);
        Integer[] pageList = boardService.getPageList(pageNum);

        double count = Double.valueOf(boardService.getBoardCount());
        Integer postsTotalCount = (int) count;

        model.addAttribute("boardList", boardList);
        model.addAttribute("pageList", pageList);
        model.addAttribute("postsTotalCount", postsTotalCount);


        double  regcount = Double.valueOf(egmMetaService.getEgmMetaCount());
        Integer regCount = (int) regcount;
        model.addAttribute("regCount", regCount);

        double  staffcount = Double.valueOf(staffService.getStaffCount());
        Integer staffCount = (int) staffcount;
        model.addAttribute("staffCount", staffCount);

        double  restcount = Double.valueOf(hyperRestApiService.getHyperRestApiCount());
        Integer restCount = (int) restcount;
        model.addAttribute("restCount", restCount);

        double  dashcount = Double.valueOf(dashBoardMngService.getDashBoardMngCount());
        Integer dashCount = (int) dashcount;
        model.addAttribute("dashCount", dashCount);

        return "main/index.html";
    }

    @GetMapping("/login")
    public String getLoginPage(Model model) {

        return "member/login.html";

        //return "redirect:"+authorizationRequestBaseUri+"/wso2";
    }


    @GetMapping("/help")
    public String gethelp(Model model) {

        return "redirect:/swagger-ui.html";
    }

}
