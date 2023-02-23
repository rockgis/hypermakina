package com.mslk.main.controller;

import com.mslk.dashboard.dto.DashBoardMngDto;
import com.mslk.dashboard.service.DashBoardMngService;
import com.mslk.hypermakina.board.dto.BoardDto;
import com.mslk.hypermakina.board.service.BoardService;
import com.mslk.egmanager.service.EgmMetaService;
import com.mslk.main.service.RestApiService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.*;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.security.oauth2.client.web.OAuth2AuthorizationRequestRedirectFilter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Slf4j
@Controller
@AllArgsConstructor
public class SnsDashboardController {

    private static final String authorizationRequestBaseUri = OAuth2AuthorizationRequestRedirectFilter.DEFAULT_AUTHORIZATION_REQUEST_BASE_URI;

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    private BoardService boardService;

    private DashBoardMngService dashBoardMngService;

    private RestApiService restApiService;


    private EgmMetaService egmMetaService;

    @GetMapping("/sns/main")
    public String sns(  Model model, @RequestParam(value="page", defaultValue = "1") Integer pageNum) throws Exception {

        logger.info("URL : /sns/main");

        List<DashBoardMngDto> dashBoardMngList = dashBoardMngService.getDashBoardMnglist(pageNum);
        Integer[] pageList = dashBoardMngService.getPageList(pageNum);

        double  count = Double.valueOf(dashBoardMngService.getDashBoardMngCount());
        Integer postsTotalCount = (int) count;

        model.addAttribute("dashBoardMngList", dashBoardMngList);
        model.addAttribute("pageList", pageList);
        model.addAttribute("page", pageNum);
        model.addAttribute("postsTotalCount", postsTotalCount);


        double  regcount = Double.valueOf(egmMetaService.getEgmMetaCount());
        Integer regCount = (int) regcount;
        model.addAttribute("regCount", regCount);

        String apiUrl = "http://172.30.1.109:7077/api/eg/analytics/getAlarmCount";    // 각자 상황에 맞는 IP & url 사용
        String managerurl = "http://172.30.1.109:7077";
        String user = "admin";
        String pwd ="bHlpanVuIUAwOQ==";

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
