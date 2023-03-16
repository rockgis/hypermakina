package com.mslk.sns.main;

import com.mslk.common.paging.Pagination;
import com.mslk.common.paging.dto.SearchDto;
import com.mslk.dashboard.dto.DashBoardMngDto;
import com.mslk.dashboard.service.DashBoardMngService;
import com.mslk.egmanager.service.EgmMetaService;
import com.mslk.restapi.dto.HyperRestApiDto;
import com.mslk.restapi.egmanager.domain.DiskSpaceVO;
import com.mslk.restapi.egmanager.domain.NetworkVO;
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

        ArrayList systemSummarylist = new ArrayList();
        String uptime ="";
        String usedmn ="";
        String cpumn ="";
        String diskmn="";

        switch (idx) {
            case 1:

                model.addAttribute("server", String.format("%02d", 7));
                model.addAttribute("was", String.format("%02d", 3));
                model.addAttribute("DB", String.format("%02d", 2));

                model.addAttribute("hosnm", "MES-App_1_t");
                model.addAttribute("cpucore", "16");
                model.addAttribute("ramuse", "64 GB");


                 uptime = this.UptimeGet("MES_App_1_t", hyperRestApiDto);

                model.addAttribute("uptime", uptime);

                 usedmn = this.UsageGet("MES_App_1_t","Memory Usage",16 ,hyperRestApiDto);

                model.addAttribute("usedmn", usedmn);

                 cpumn = this.UsageGet("MES_App_1_t","System Details",16 ,hyperRestApiDto);

                model.addAttribute("cpumn", cpumn);


                 diskmn = this.UsageGet("MES_App_1_t","Disk Space",6 ,hyperRestApiDto);

                model.addAttribute("diskmn", diskmn);


                //System summary


                systemSummarylist = this.SystemSummaryGet("MES_App_1_t",hyperRestApiDto);

                model.addAttribute("systemSummarylist", systemSummarylist);


                ArrayList diskSpacelist =  this.DiskspaceGet("MES_App_1_t","Disk Space",hyperRestApiDto );

                model.addAttribute("diskSpacelist", diskSpacelist);


                ArrayList networklist =  this.NetworkGet("MES_App_1_t","Network Packet Traffic",hyperRestApiDto );

                model.addAttribute("networklist", networklist);



                urlgo =  "sns/dashboard/host";
                break;
            case 2:

                String hosnm ="MES_Tibero_1_t";

                model.addAttribute("hosnm", hosnm);


                model.addAttribute("mssql", String.format("%02d", 1));
                model.addAttribute("tibero", String.format("%02d", 2));

                uptime = this.UptimeGet("MES_App_1_t", hyperRestApiDto);

                model.addAttribute("uptime", uptime);

                usedmn = this.UsageGet(hosnm,"Memory Usage",16 ,hyperRestApiDto);

                model.addAttribute("usedmn", usedmn);

                cpumn = this.UsageGet(hosnm,"System Details",16 ,hyperRestApiDto);

                model.addAttribute("cpumn", cpumn);


                diskmn = this.UsageGet(hosnm,"Disk Space",6 ,hyperRestApiDto);

                model.addAttribute("diskmn", diskmn);

                systemSummarylist = this.SystemSummaryGet(hosnm,hyperRestApiDto);

                model.addAttribute("systemSummarylist", systemSummarylist);


                urlgo =  "sns/dashboard/db";
                break;
            case 3:

                model.addAttribute("lan", String.format("%02d", 1));
                model.addAttribute("switch", String.format("%02d", 14));



                urlgo = "sns/dashboard/network";
                break;
        }


        return urlgo;


    }


    private String  UsageGet(String componetName,String usage,int index, HyperRestApiDto hyperRestApiDto){

        String usageerest = restApiService.getDataUptime(componetName, hyperRestApiDto,usage, -10).getBody().toString();

        String usagedata[]=usageerest.split(",");

        logger.info("usagedata :" + usagedata[usagedata.length - 1 ].toString());

        String usageresult[] = usagedata[usagedata.length - 1 ].split(" ");

        logger.info("Rest Get usage result :" + usageresult[usageresult.length - index ].toString() );

        String usagere = usageresult[usageresult.length - index ].toString();

        return usagere;
    }


    private String UptimeGet(String componetName,HyperRestApiDto hyperRestApiDto){

        String uptimerest = restApiService.getDataUptime(componetName, hyperRestApiDto,"Uptime", -10).getBody().toString();

        String uptimedata[]=uptimerest.split(",");

        logger.info("uptimedata :" + uptimedata[uptimedata.length - 1 ].toString());

        String uptimeresult[] = uptimedata[uptimedata.length - 1 ].split(" ");

        logger.info("Rest Get uptimeresult :" + uptimeresult[uptimeresult.length - 2 ].toString() );


        double day =  (Double.parseDouble(uptimeresult[uptimeresult.length - 2 ].toString()) / 60)/24;

        String uptime = String.format("%.1f", day) + " day";


        return uptime;
    }

    private ArrayList NetworkGet(String componetName,String test, HyperRestApiDto hyperRestApiDto ){

        String resultdata = restApiService.getTestData( componetName, test ,hyperRestApiDto).getBody().toString();

        logger.info("Rest Get resultdata :" + resultdata);

        String chartdata[]=resultdata.split(",");

        ArrayList<NetworkVO> networklist = new ArrayList<>();
        String systemsummary[] = {};

        logger.info("Rest Get chartdata :" + chartdata.length);

        for(int i = 1 ; i < chartdata.length ;i++){

            logger.info("chartdata["+i+"] :" + chartdata[i].toString());

            systemsummary = chartdata[i].split(" ");

            NetworkVO networkVO = new NetworkVO();

            networkVO.setTrgt_host(systemsummary[0]); //TRGT_HOST
            networkVO.setPort_no(systemsummary[1]); // PORT_NO
            networkVO.setSite_name(systemsummary[2]); // SITE_NAME
            networkVO.setInfo(systemsummary[3]); // INFO
            networkVO.setMsmt_host(systemsummary[4]); // MSMT_HOST
            networkVO.setMsmt_time(systemsummary[6]);// MSMT_TIME
            networkVO.setInp_pkt_rate(systemsummary[8]);// INP_PKT_RATE
            networkVO.setInp_pkt_rate_st(systemsummary[9]); // INP_PKT_RATE_ST
            networkVO.setOut_pkt_rate(systemsummary[10]);// OUT_PKT_RATE
            networkVO.setOut_pkt_rate_st(systemsummary[11]); // OUT_PKT_RATE_ST


            logger.debug("diskSpaceVO [0] :" + networkVO.getMsmt_time().toString());

            networklist.add(networkVO);

        }

        return networklist;

    }


    private ArrayList DiskspaceGet(String componetName,String test, HyperRestApiDto hyperRestApiDto ){

        String resultdata = restApiService.getTestData( componetName, test ,hyperRestApiDto).getBody().toString();

        logger.info("Rest Get resultdata :" + resultdata);

        String chartdata[]=resultdata.split(",");

        ArrayList<DiskSpaceVO> diskSpacelist = new ArrayList<>();
        String systemsummary[] = {};

        logger.info("Rest Get chartdata :" + chartdata.length);

        for(int i = 1 ; i < chartdata.length ;i++){

            logger.info("chartdata["+i+"] :" + chartdata[i].toString());

            systemsummary = chartdata[i].split(" ");

            DiskSpaceVO diskSpaceVO = new DiskSpaceVO();

            diskSpaceVO.setTrgt_host(systemsummary[0]); //TRGT_HOST
            diskSpaceVO.setPort_no(systemsummary[1]); // PORT_NO
            diskSpaceVO.setSite_name(systemsummary[2]); // SITE_NAME
            diskSpaceVO.setInfo(systemsummary[3]); // INFO
            diskSpaceVO.setMsmt_host(systemsummary[4]); // MSMT_HOST
            diskSpaceVO.setMsmt_time(systemsummary[6]);// MSMT_TIME
            diskSpaceVO.setTotal_capacity(systemsummary[8]);// TOTAL_CAPACITY
            diskSpaceVO.setTotal_capacity_st(systemsummary[9]); // TOTAL_CAPACITY_ST
            diskSpaceVO.setUsed_space(systemsummary[10]);// USED_SPACE
            diskSpaceVO.setUsed_space_st(systemsummary[11]); // USED_SPACE_ST
            diskSpaceVO.setFree_space(systemsummary[12]);// FREE_SPACE
            diskSpaceVO.setFree_space_st(systemsummary[13]); // FREE_SPACE_ST
            diskSpaceVO.setPercent_usage(systemsummary[14]);// PERCENT_USAGE
            diskSpaceVO.setPercent_usage_st(systemsummary[15]);// PERCENT_USAGE_ST
            diskSpaceVO.setDrive_avail(systemsummary[16]);// DRIVE_AVAIL
            diskSpaceVO.setDrive_avail_st(systemsummary[17]);// DRIVE_AVAIL_ST
            diskSpaceVO.setAutomation_status(systemsummary[18]);// AUTOMATION_STATUS
            diskSpaceVO.setAutomation_status_st(systemsummary[19]);// AUTOMATION_STATUS_ST

            logger.debug("diskSpaceVO [0] :" + diskSpaceVO.getMsmt_time().toString());

            diskSpacelist.add(diskSpaceVO);

        }

        return diskSpacelist;

    }


    private ArrayList SystemSummaryGet(String componetName,HyperRestApiDto hyperRestApiDto ){

        String resultdata = restApiService.getData( componetName, hyperRestApiDto).getBody().toString();

        logger.info("Rest Get resultdata :" + resultdata);

        String chartdata[]=resultdata.split(",");

        ArrayList<SystemSummaryVO> systemSummarylist = new ArrayList<>();
        String systemsummary[] = {};

        logger.info("Rest Get chartdata :" + chartdata.length);

        for(int i = 1 ; i < chartdata.length ;i++){

            logger.info("chartdata["+i+"] :" + chartdata[i].toString());

            systemsummary = chartdata[i].split(" ");

            SystemSummaryVO systemSummaryVO = new SystemSummaryVO();

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

            logger.debug("systemSummaryVO [0] :" + systemSummaryVO.getMsmt_time().toString());

            systemSummarylist.add(systemSummaryVO);

        }

        return systemSummarylist;

    }


}
