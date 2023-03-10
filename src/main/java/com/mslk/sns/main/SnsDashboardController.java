package com.mslk.sns.main;

import com.mslk.common.paging.Pagination;
import com.mslk.common.paging.dto.SearchDto;
import com.mslk.dashboard.dto.DashBoardMngDto;
import com.mslk.dashboard.service.DashBoardMngService;
import com.mslk.egmanager.service.EgmMetaService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.*;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Slf4j
@Controller
@AllArgsConstructor
public class SnsDashboardController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());


    private DashBoardMngService dashBoardMngService;



    private EgmMetaService egmMetaService;

    @GetMapping("/sns/main")
    public String sns(  Model model, @ModelAttribute("params") final SearchDto params) throws Exception {

        logger.info("URL : /sns/main");

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

        String apiUrl = "http://192.168.10.62:7077/api/eg/analytics/getAlarmCount";    // ?????? ????????? ?????? IP & url ??????
       // String managerurl = "http://172.30.1.109:7077";
        String managerurl = "http://192.168.10.62:7077";
        String user = "admin";
        //String pwd ="bHlpanVuIUAwOQ==";
        String pwd ="c25zMTIzNCE=";

        logger.info("Rest URL :" + apiUrl);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON_UTF8);
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        headers.add("managerurl", managerurl);
        headers.add("user", user);
        headers.add("pwd", pwd);

        HttpEntity<String> req = new HttpEntity<>("", headers);

        CloseableHttpClient httpClient = HttpClients.custom()
                .setMaxConnTotal(100)
                .setMaxConnPerRoute(10)
                .disableCookieManagement()
                .build();
        HttpComponentsClientHttpRequestFactory requestFactory = new HttpComponentsClientHttpRequestFactory();
        requestFactory.setHttpClient(httpClient);
        RestTemplate loginRestTemplate = new RestTemplate(requestFactory);

        ResponseEntity<String> res = loginRestTemplate.exchange(apiUrl, HttpMethod.POST, req, String.class);


        /*


        ResponseEntity<Object> resultMap = restApiService.postData(apiUrl, managerurl,user,pwd);

        logger.info("Rest postresult :" + resultMap.getBody());

         */

        String result = res.getBody().toString();

        JSONParser parser = new JSONParser();
        JSONObject jsonObject = (JSONObject) parser.parse(result);

        logger.info("Rest total :" + jsonObject.get("total").toString());

        model.addAttribute("total", jsonObject.get("total").toString());
        model.addAttribute("critical", jsonObject.get("critical").toString());
        model.addAttribute("major", jsonObject.get("major").toString());
        model.addAttribute("minor", jsonObject.get("minor").toString());

        return "sns/sns_main";

    }

    @GetMapping("/sns/dashboard")
    public String dashboard( Model model, @RequestParam(value="idx", defaultValue = "1") Integer idx) {

        logger.info("URL : /sns/dashboard");

        String imgUrl ="/images/dashboard/CPU_dark.png";

        switch (idx) {
            case 1:
                imgUrl ="/images/dashboard/CPU_dark.png";
                break;
            case 2:
                imgUrl ="/images/dashboard/CPU_white.png";
                break;
            case 3:
                imgUrl ="/images/dashboard/Nw_dark.png";
                break;
            case 4:
                imgUrl ="/images/dashboard/NW_white.png";
                break;
            default:
                imgUrl ="/images/dashboard/CPU_dark.png";
                break;
        }



        model.addAttribute("imgUrl", imgUrl);


        return "sns/dashboard/main";

    }
}
