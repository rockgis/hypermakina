package com.mslk.sns.main;

import com.mslk.common.paging.Pagination;
import com.mslk.common.paging.dto.SearchDto;
import com.mslk.dashboard.dto.DashBoardMngDto;
import com.mslk.dashboard.service.DashBoardMngService;
import com.mslk.egmanager.service.EgmMetaService;
import com.mslk.restapi.dto.HyperRestApiDto;
import com.mslk.restapi.egmanager.domain.SystemSummaryVO;
import com.mslk.restapi.egmanager.service.RestApiService;
import com.mslk.restapi.service.HyperRestApiService;
import com.mslk.common.util.DayUtil;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.json.simple.parser.ParseException;
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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Slf4j
@Controller
@AllArgsConstructor
public class SnsDashboardController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());


    private DashBoardMngService dashBoardMngService;



    private EgmMetaService egmMetaService;

    private RestApiService restApiService;

    private HyperRestApiService hyperRestApiService;

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


        HyperRestApiDto hyperRestApiDto =  hyperRestApiService.getPost("getAlarmCount");

        String result = restApiService.getAlarmCountData(hyperRestApiDto).getBody().toString();

        logger.info("Rest Get getAlarmCount :" + result);

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
    public String dashboard( Model model, @RequestParam(value="idx", defaultValue = "1") Integer idx) throws Exception {

        logger.info("URL : /sns/dashboard");

        double  regcount = Double.valueOf(egmMetaService.getEgmMetaCount());
        Integer regCount = (int) regcount;

        model.addAttribute("regCount", String.format("%02d", regCount) );

        HyperRestApiDto hyperRestApiDto =  hyperRestApiService.getPost("getAlarmCount");

        logger.info("Rest Get hyperRestApiDto :" + hyperRestApiDto.toString());

        String result = restApiService.getAlarmCountData(hyperRestApiDto).getBody().toString();

        logger.info("Rest Get getAlarmCount :" + result);

        JSONParser parser = new JSONParser();
        JSONObject jsonObject = (JSONObject) parser.parse(result);

        logger.info("Rest total :" + jsonObject.get("total").toString());

        Integer itotal = Integer.valueOf(jsonObject.get("total").toString());
        Integer icritical = Integer.valueOf(jsonObject.get("critical").toString());
        Integer imajor = Integer.valueOf(jsonObject.get("major").toString());
        Integer iminor = Integer.valueOf(jsonObject.get("minor").toString());

        model.addAttribute("total", String.format("%02d", itotal) );
        model.addAttribute("critical", String.format("%02d", icritical));
        model.addAttribute("major", String.format("%02d", imajor));
        model.addAttribute("minor", String.format("%02d", iminor));


        hyperRestApiDto =  hyperRestApiService.getPost("getTestData");


        String urlgo="";

        switch (idx) {
            case 1:

                model.addAttribute("server", String.format("%02d", 7));
                model.addAttribute("was", String.format("%02d", 3));
                model.addAttribute("DB", String.format("%02d", 2));

                model.addAttribute("hosnm", "MES-App_1_t");
                model.addAttribute("cpucore", "16");
                model.addAttribute("ramuse", "64 GB");


                String uptimerest = restApiService.getDataUptime("MES_App_1_t", hyperRestApiDto,"uptime", -10).getBody().toString();

                String uptimedata[]=uptimerest.split(",");

                logger.info("uptimedata :" + uptimedata[uptimedata.length - 1 ].toString());

                String uptimeresult[] = uptimedata[uptimedata.length - 1 ].split(" ");

                logger.info("Rest Get uptimeresult :" + uptimeresult[uptimeresult.length - 2 ].toString() );

                String uptime = uptimeresult[uptimeresult.length - 2 ].toString();  // MinuteTODay  로 시간 확인

                model.addAttribute("uptime",uptime );


                urlgo =  "sns/dashboard/host";
                break;
            case 2:
                model.addAttribute("mssql", String.format("%02d", 3));
                model.addAttribute("tibreo", String.format("%02d", 2));

                urlgo =  "sns/dashboard/db";
                break;
            case 3:

                model.addAttribute("imgUrl", "/images/dashboard/NW_dark.png");

                urlgo = "sns/dashboard/network";
                break;
        }

        //서버 정보




        String resultdata = restApiService.getData("MES_App_1_t", hyperRestApiDto).getBody().toString();

        logger.info("Rest Get resultdata :" + resultdata);

        String chartdata[]=resultdata.split(",");

       // JSONObject resultObject = (JSONObject) parser.parse(cpuresult);

        //logger.info("resultObject total :" + resultObject.);

        ArrayList<SystemSummaryVO> systemSummarylist = new ArrayList<>();
        SystemSummaryVO systemSummaryVO = new SystemSummaryVO();
        String systemsummary[] = {};


        logger.info("Rest Get chartdata :" + chartdata.length);

        for(int i = 1 ; i < chartdata.length ;i++){

            logger.info("chartdata["+i+"] :" + chartdata[i].toString());

            systemsummary = chartdata[i].split(" ");

           // for(int j = 0 ; j < systemsummary.length ; j++){
           //     logger.info("systemsummary ["+j+"] :" + systemsummary[j]);
           // }

            systemSummaryVO.setTrgt_host(systemsummary[0]); //TRGT_HOST
            systemSummaryVO.setPort_no(systemsummary[1]); // PORT_NO
            systemSummaryVO.setSite_name(systemsummary[2]); // SITE_NAME
            systemSummaryVO.setInfo(systemsummary[3]); // INFO
            systemSummaryVO.setMsmt_host(systemsummary[4]); // MSMT_HOST
            systemSummaryVO.setMsmt_time(systemsummary[6]);// MSMT_TIME
            systemSummaryVO.setCpu_util(systemsummary[8]);// CPU_UTIL
            systemSummaryVO.setCpu_util_st(systemsummary[9]); // CPU_UTIL_ST
            systemSummaryVO.setSys_cpu_util(systemsummary[10]);// SYS_CPU_UTIL
            systemSummaryVO.setSys_cpu_util_st(systemsummary[11]); // SYS_CPU_UTIL_ST
            systemSummaryVO.setRunning_proc(systemsummary[12]);// RUNNING_PROC
            systemSummaryVO.setRunning_proc_st(systemsummary[13]); // RUNNING_PROC_ST
            systemSummaryVO.setBlocked_proc(systemsummary[14]);// BLOCKED_PROC
            systemSummaryVO.setBlocked_proc_st(systemsummary[15]);// BLOCKED_PROC_ST
            systemSummaryVO.setSwap_avail(systemsummary[16]);// SWAP_AVAIL
            systemSummaryVO.setSwap_avail_st(systemsummary[17]);// SWAP_AVAIL_ST
            systemSummaryVO.setFree_mem_avail(systemsummary[18]);// FREE_MEM_AVAIL
            systemSummaryVO.setFree_mem_avail_st(systemsummary[19]);// FREE_MEM_AVAIL_ST
            systemSummaryVO.setMem_scan_rate(systemsummary[20]);// MEM_SCAN_RATE
            systemSummaryVO.setMem_scan_rate_st(systemsummary[21]);// MEM_SCAN_RATE_ST
            systemSummaryVO.setSteal_time(systemsummary[22]);// STEAL_TIME
            systemSummaryVO.setSteal_time_st(systemsummary[23]);// STEAL_TIME_ST

            logger.info("systemSummaryVO [0] :" + systemSummaryVO.getMsmt_time().toString());

            systemSummarylist.add(systemSummaryVO);

        }

        model.addAttribute("systemSummarylist", systemSummarylist);

        logger.info("arrayList :" + systemSummarylist.size());


        return urlgo;



    }
}
