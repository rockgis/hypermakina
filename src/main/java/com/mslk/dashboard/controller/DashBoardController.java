package com.mslk.dashboard.controller;

import com.mslk.common.paging.Pagination;
import com.mslk.common.paging.dto.SearchDto;
import com.mslk.egmanager.service.EgmMetaService;
import com.mslk.hypermakina.board.dto.BoardDto;
import com.mslk.hypermakina.board.service.BoardService;
import com.mslk.dashboard.dto.DashBoardMngDto;
import com.mslk.dashboard.service.DashBoardMngService;
import com.mslk.restapi.service.HyperRestApiService;
import com.mslk.sns.staff.dto.StaffDto;
import com.mslk.sns.staff.service.StaffService;
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
public class DashBoardController {

    private static String authorizationRequestBaseUri = OAuth2AuthorizationRequestRedirectFilter.DEFAULT_AUTHORIZATION_REQUEST_BASE_URI;

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    private BoardService boardService;

    private DashBoardMngService dashBoardMngService;

    private EgmMetaService egmMetaService;

    private StaffService staffService;

    private HyperRestApiService hyperRestApiService;


    @GetMapping("/admin/dbmnglist")
    public String dbmnglist(Principal principal, Model model, @ModelAttribute("params") final SearchDto params) {

        List<DashBoardMngDto> dashBoardMngList = dashBoardMngService.getDashBoardMnglist(params.getPage());

        double  count = Double.valueOf(dashBoardMngService.getDashBoardMngCount());
        Integer postsTotalCount = (int) count;

        logger.info("params : " + params.getPage());


        Pagination pagination = new Pagination(postsTotalCount, params);

        logger.info("totalRecordCount : " + pagination.getTotalRecordCount());
        logger.info("totalPageCount : " + pagination.getTotalPageCount());
        logger.info("startPage : " + pagination.getStartPage());
        logger.info("endPage : " + pagination.getEndPage());
        logger.info("limitStart : " + pagination.getLimitStart());
        logger.info("existPrevPage : " + pagination.isExistPrevPage());
        logger.info("existNextPage : " + pagination.isExistNextPage());

        model.addAttribute("dashBoardMngList", dashBoardMngList);
        model.addAttribute("pagination", pagination);


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

        model.addAttribute("pageURL", "/admin/dbmnglist");


        return "dashboard/admin/index";
    }


    @PostMapping("/admin/dbmngpost")
    public String dbmngpost(Principal principal, DashBoardMngDto egmMetaDto) {


        egmMetaDto.setAltEn(principal.getName());

        // System.out.println(now);

        dashBoardMngService.savePost(egmMetaDto);

        return "redirect:/admin/dbmnglist";
    }


    @GetMapping("/admin/dbmngdel")
    public String dbmngdelete(@RequestParam(value="idx") String idx) {

        long no = 0;

        int beginIndex = idx.indexOf(",");

        if(beginIndex > 0){

            String[] ArraysStr = idx.split(",");

            for(String s : ArraysStr){
                no = Long.parseLong(s);
                dashBoardMngService.deletePost(no);
            }

        }else{

            no = Long.parseLong(idx);
            dashBoardMngService.deletePost(no);

        }
        return "redirect:/admin/dbmnglist";
    }


    @GetMapping("/admin/dbmngpost/{no}")
    public String dbmngdetail(@PathVariable("no") Long no, Model model) {
        DashBoardMngDto egmMetaDto = dashBoardMngService.getPost(no);

        model.addAttribute("egmMetaDto", egmMetaDto);
        return "dashboard/admin/read";
    }

    @PutMapping("/admin/dbmngpost/edit/{no}")
    public String dbmngupdate(Principal principal, DashBoardMngDto egmMetaDto) {

        LocalDateTime now = LocalDateTime.now();

        egmMetaDto.setModifiedDate(now);
        egmMetaDto.setAltEn(principal.getName());

        dashBoardMngService.savePost(egmMetaDto);

        return "redirect:/admin/dbmnglist";
    }


    @PostMapping("/admin/dbmngsearch")
    public String dbmngsearch(@ModelAttribute("params") final SearchDto params , Model model) {

        logger.info("/snsad/staffsearch ==> getKeyword : "+params.getKeyword());

        logger.info("/snsad/staffsearch ==> getSearchType : "+params.getSearchType());

        List<DashBoardMngDto> dashBoardMngList = dashBoardMngService.searchPosts(params);

        // 총 게시글 갯수
        double  count = Double.valueOf(dashBoardMngList.size());
        Integer postsTotalCount = (int) count;

        logger.info("params : " + params.getPage());


        Pagination pagination = new Pagination(postsTotalCount, params);

        logger.info("totalRecordCount : " + pagination.getTotalRecordCount());
        logger.info("totalPageCount : " + pagination.getTotalPageCount());
        logger.info("startPage : " + pagination.getStartPage());
        logger.info("endPage : " + pagination.getEndPage());
        logger.info("limitStart : " + pagination.getLimitStart());
        logger.info("existPrevPage : " + pagination.isExistPrevPage());
        logger.info("existNextPage : " + pagination.isExistNextPage());

        model.addAttribute("dashBoardMngList", dashBoardMngList);
        model.addAttribute("pagination", pagination);


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


        return "dashboard/admin/index";
    }




    @GetMapping("/dashboard")
    public String dashboard( Model model, @RequestParam(value="page", defaultValue = "1") Integer pageNum) {


        logger.info("URL : /dashboard");

        List<BoardDto> boardList = boardService.getBoardlist(pageNum);
        Integer[] pageList = boardService.getPageList(pageNum);

        double  count = Double.valueOf(boardService.getBoardCount());
        Integer postsTotalCount = (int) count;

        model.addAttribute("boardList", boardList);
        model.addAttribute("pageList", pageList);
        model.addAttribute("postsTotalCount", postsTotalCount);


        return "dashboard/dashboard";

    }

    @GetMapping("/dashboard1")
    public String dashboard1( Model model, @RequestParam(value="page", defaultValue = "1") Integer pageNum) {


        logger.info("URL : /dashboard1");


        return "dashboard/dashboard1";

    }

    @GetMapping("/dashboard2")
    public String dashboard2( Model model, @RequestParam(value="page", defaultValue = "1") Integer pageNum) {


        logger.info("URL : /dashboard2");


        return "dashboard/dashboard2";

    }

    @GetMapping("/dashboard3")
    public String dashboard3( Model model, @RequestParam(value="page", defaultValue = "1") Integer pageNum) {


        logger.info("URL : /dashboard3");


        return "dashboard/dashboard3";

    }



    @GetMapping("/chart1")
    public String chart1( Model model, @RequestParam(value="page", defaultValue = "1") Integer pageNum) {


        logger.info("URL : /chart1");


        return "dashboard/chart1";

    }


    @GetMapping("/chart2")
    public String chart2( Model model, @RequestParam(value="page", defaultValue = "1") Integer pageNum) {


        logger.info("URL : /chart2");


        return "dashboard/chart2";

    }

    @GetMapping("/chart3")
    public String chart3( Model model, @RequestParam(value="page", defaultValue = "1") Integer pageNum) {


        logger.info("URL : /chart3");


        return "dashboard/chart3";

    }

    @GetMapping("/chart4")
    public String chart4( Model model, @RequestParam(value="page", defaultValue = "1") Integer pageNum) {


        logger.info("URL : /chart4");


        return "dashboard/chart4";

    }


}
