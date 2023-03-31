package com.mslk.sns.staff.controller;

import com.google.gson.Gson;
import com.mslk.common.paging.Pagination;
import com.mslk.common.paging.dto.SearchDto;
import com.mslk.hypermakina.board.dto.BoardDto;
import com.mslk.sns.department.dto.DepartmentDto;
import com.mslk.sns.department.service.DepartmentService;
import com.mslk.sns.position.dto.PositionDto;
import com.mslk.sns.position.service.PositionService;
import com.mslk.sns.rank.dto.RankDto;
import com.mslk.sns.rank.service.RankService;
import com.mslk.sns.staff.dto.StaffDto;
import com.mslk.sns.staff.service.StaffService;
import com.mslk.sns.syncsvr.dto.SyncsvrDto;
import com.mslk.sns.syncsvr.service.SyncsvrService;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.security.NoSuchAlgorithmException;
import java.security.Principal;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import com.mslk.common.util.SHA256;

@Controller
@AllArgsConstructor
public class StaffController {
    private StaffService staffService;

    private final Logger logger = LoggerFactory.getLogger(this.getClass());


    private RankService rankService;

    private PositionService positionService;

    private DepartmentService departmentService;

    private SyncsvrService syncsvrService;




    /* 게시글 목록 */

    @GetMapping("/snsad/stafflist")
    public String index(Model model, @ModelAttribute("params") final SearchDto params) {

        List<StaffDto> staffList = staffService.getStafflist(params.getPage());

        // 총 게시글 갯수
        double  count = Double.valueOf(staffService.getStaffCount());
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

        model.addAttribute("staffList", staffList);
        model.addAttribute("pagination", pagination);

        List<RankDto> ranklist = rankService.getRanklistAll();

        model.addAttribute("ranklist", ranklist);


        List<PositionDto> positionlist = positionService.getPositionlistAll();
        model.addAttribute("positionlist", positionlist);


        List<DepartmentDto> departmentlist = departmentService.getDepartmentlistAll();
        model.addAttribute("departmentlist", departmentlist);


        List<SyncsvrDto> syncsvrlist = syncsvrService.getSyncsvrlistAll();
        model.addAttribute("syncsvrlist", syncsvrlist);

        model.addAttribute("pageURL", "/snsad/stafflist");


        return "sns/staff/list";
    }


    @GetMapping("/snsad/post/{no}")
    public String staffdetail(@PathVariable("no") Long no, Model model) {
        StaffDto staffDto = staffService.getPost(no);

        logger.info("사용자 ID : " + no);

        model.addAttribute("staffDto", staffDto);

        List<RankDto> ranklist = rankService.getRanklistAll();

        model.addAttribute("ranklist", ranklist);


        List<PositionDto> positionlist = positionService.getPositionlistAll();
        model.addAttribute("positionlist", positionlist);


        List<DepartmentDto> departmentlist = departmentService.getDepartmentlistAll();
        model.addAttribute("departmentlist", departmentlist);


        List<SyncsvrDto> syncsvrlist = syncsvrService.getSyncsvrlistAll();
        model.addAttribute("syncsvrlist", syncsvrlist);

        return "sns/staff/read";
    }

    @PutMapping("/snsad/post/edit/{no}")
    public String update(StaffDto staffDto) throws NoSuchAlgorithmException {

        staffService.savePost(staffDto);

        return "redirect:/snsad/stafflist";
    }

    @PutMapping("/sns/user/edit/{no}")
    public String userupdate(StaffDto staffDto) throws NoSuchAlgorithmException {

        logger.info("staffDto.getPw() ===>  pw : "+ staffDto.getPw().toString());
        logger.info("staffDto.getPassword() ===>  password : "+ staffDto.getPassword().toString());


        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        staffDto.setPassword(passwordEncoder.encode(staffDto.getPw().toString()));

        SHA256 sha256 = new SHA256();
        staffDto.setPw(sha256.encrypt(staffDto.getPw().toString()));


        staffService.savePost(staffDto);

        return "redirect:/user/login";
    }

    @PostMapping("/snsad/staffpost")
    public String userpost(Principal principal, StaffDto staffDto) throws NoSuchAlgorithmException {

        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        staffDto.setPassword(passwordEncoder.encode(staffDto.getPw()));
        SHA256 sha256 = new SHA256();
        staffDto.setPw(sha256.encrypt(staffDto.getPw().toString()));

        staffService.savePost(staffDto);

        return "redirect:/snsad/stafflist";
    }



    @PostMapping("/snsad/staffuppost")
    public String uppost(Principal principal, StaffDto staffDto) throws NoSuchAlgorithmException {

        LocalDateTime now = LocalDateTime.now();

        staffDto.setModifiedDate(now);

        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        staffDto.setPassword(passwordEncoder.encode(staffDto.getPw()));
        SHA256 sha256 = new SHA256();
        staffDto.setPw(sha256.encrypt(staffDto.getPw().toString()));

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

    @GetMapping("/snsad/staffdelyn")
    public String staffdelyn(@RequestParam(value="idx") String idx) {

        StaffDto staffDto = new StaffDto();

        long no = 0;

        int beginIndex = idx.indexOf(",");

        if(beginIndex > 0){

            String[] ArraysStr = idx.split(",");

            for(String s : ArraysStr){
                no = Long.parseLong(s);

                 staffDto = staffService.getPost(no);

                staffDto.setDel(1);
                staffService.savePost(staffDto);
            }

        }else{

            no = Long.parseLong(idx);
            staffDto = staffService.getPost(no);

            staffDto.setDel(1);
            staffService.savePost(staffDto);

        }
        return "redirect:/snsad/stafflist";
    }


    @PostMapping("/snsad/staffsearch")
    public String staffsearch(@RequestParam(value="keyword") String keyword, @ModelAttribute("params") final SearchDto params , Model model) {

        logger.info("/snsad/staffsearch ===>  keyword : "+ keyword);

        logger.info("/snsad/staffsearch ==> getKeyword : "+params.getKeyword());

        logger.info("/snsad/staffsearch ==> getSearchType : "+params.getSearchType());

        List<StaffDto> staffList = staffService.searchPosts(params);

        // 총 게시글 갯수
        double  count = Double.valueOf(staffList.size());
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

        model.addAttribute("staffList", staffList);
        model.addAttribute("pagination", pagination);

        model.addAttribute("pageURL", "/snsad/staffsearch");


        return "sns/staff/list";
    }


    @PostMapping(value="/id_check")
    @ResponseBody
    public String id_check(@RequestBody String info) {
        String json = null;
        String input_json = null;

        try {
            Gson gson = new Gson();
            Map<Object, Object> map = new HashMap<Object, Object>();
            map = (Map<Object, Object>) gson.fromJson(info, map.getClass());

            input_json = gson.toJson(map);

        logger.info("info : " + input_json );

            // -> info : {"id":"m","pw":"서울"}
            logger.info("uid : " + map.get("uid").toString() );
            logger.info("check : " + map.get("check").toString() );

            int id_check = staffService.getStaffCountUid(map.get("uid").toString(),  map.get("check").toString());


            String requestJson = "{\n" +
                    "  \"check\": \""+map.get("check")+"\",\n" +
                    "  \"result\":\""+id_check+"\"\n"+
                    "}";


            json = gson.toJson(requestJson);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return json;
    }


    @PostMapping("/sns/staffcheck")
    public String staff_check(@RequestParam(value="uid") String uid , @RequestParam(value="pw") String pw, Model model) throws NoSuchAlgorithmException {

        logger.info("/user/staffcheck ===>  uid : "+ uid);
        logger.info("/user/staffcheck ===>  pw : "+ pw);

        SHA256 sha256 = new SHA256();



        Long no =staffService.getfindeUserNo(uid,sha256.encrypt(pw));


        if(no == null){

            return "redirect:/user/login";

        }else{
            StaffDto staffDto = staffService.getPost(no);

            logger.info("사용자 ID : " + no);

            model.addAttribute("staffDto", staffDto);


            return "sns/staff/user_read";
        }




    }


}
