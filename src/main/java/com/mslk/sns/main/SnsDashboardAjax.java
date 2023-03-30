package com.mslk.sns.main;

import com.google.gson.Gson;
import com.mslk.egmanager.dto.EgmMetaDto;
import com.mslk.egmanager.service.EgmMetaService;
import com.mslk.restapi.dto.HyperRestApiDto;
import com.mslk.restapi.egmanager.service.RestApiService;
import com.mslk.restapi.service.HyperRestApiService;
import com.mslk.sns.sms.dto.LguMmsDto;
import com.mslk.sns.sms.dto.MmsDto;
import com.mslk.sns.sms.service.LguMmsService;
import com.mslk.sns.sms.service.MmsService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@Controller
@AllArgsConstructor
public class SnsDashboardAjax {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    private EgmMetaService egmMetaService;

    private RestApiService restApiService;

    private HyperRestApiService hyperRestApiService;

    private MmsService mmsService;

    private LguMmsService lguMmsService;



    @PostMapping(value="/network_check")
    @ResponseBody
    public String networkcheck(@RequestBody String info) {
        String json = null;
        String input_json = null;

        HyperRestApiDto hyperRestApiDto =  hyperRestApiService.getPost("getTestData");

        try {
            Gson gson = new Gson();
            Map<Object, Object> map = new HashMap<Object, Object>();
            map = (Map<Object, Object>) gson.fromJson(info, map.getClass());

            input_json = gson.toJson(map);

            logger.info("info : " + input_json );

            String componetName = map.get("componetName").toString();
            String testdata = map.get("testdata").toString();

            String result_rest = restApiService.getDataUptime(componetName, hyperRestApiDto,testdata, -10).getBody().toString();

            String resultdata[]=result_rest.split(",");

            logger.info("usagedata :" + resultdata[resultdata.length - 1 ].toString());

            String result_res[] = resultdata[resultdata.length - 1 ].split(" ");

            logger.info("Rest Get usage result :" + result_res[result_res.length - 1 ].toString() );

            String network_check = result_res[result_res.length - 4 ].toString();
            String result="True";

            //pock_loss 100%
            if(100.0 <= Double.parseDouble(network_check.substring(0,network_check.indexOf(".")))){

                result = "<알림>"+ componetName + "가 Packet loss 100% 입니다.";

            }


            String requestJson = "{\n" +
                    "  \"componetName\": \""+map.get("uid")+"\",\n" +
                    "  \"result\":\""+result+"\"\n"+
                    "}";


            logger.info("network_check_data : " + network_check.substring(0,network_check.indexOf(".")) );


            json = gson.toJson(requestJson);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return json;
    }


    @PostMapping(value="/host_check")
    @ResponseBody
    public String hostcheck(@RequestBody String info) {

        String json = null;
        String input_json = null;

        HyperRestApiDto hyperRestApiDto =  hyperRestApiService.getPost("getTestData");

        try {
            Gson gson = new Gson();
            Map<Object, Object> map = new HashMap<Object, Object>();
            map = (Map<Object, Object>) gson.fromJson(info, map.getClass());

            input_json = gson.toJson(map);

            logger.info("info : " + input_json );

            String componetName = map.get("componetName").toString();

            EgmMetaDto egmMetaDto = egmMetaService.getComponetName(componetName);

            String hostcpu = egmMetaDto.getMetaCore().toString();
            String hostram = egmMetaDto.getMetaMem().toString();

            String uptime = this.UptimeGet(componetName, "Uptime", hyperRestApiDto);

            String usedmn = this.UsageGet(componetName,"Memory Usage",16 ,hyperRestApiDto);

            String cpumn = this.UsageGet(componetName,"System Details",16 ,hyperRestApiDto);

            String diskmn = this.UsageGet(componetName,"Disk Space",6 ,hyperRestApiDto);


            String result = "True"; //알람 테스트

            //메모리체크
            if(Double.parseDouble(usedmn) >= Double.parseDouble(egmMetaDto.getMetaMemcheck().toString())){

                result = "<알림>"+ componetName + "이 사용하는 메모리 사용량이  "+ egmMetaDto.getMetaMemcheck().toString() +"을 넘었습니다.";

            }

            if(Double.parseDouble(cpumn) >= Double.parseDouble(egmMetaDto.getMetaCpucheck().toString())){

                result = "<알림>"+ componetName + "이 사용하는 CPU 사용량이 "+ egmMetaDto.getMetaCpucheck().toString() +"을 넘었습니다.";

            }


            if(Double.parseDouble(diskmn) >= Double.parseDouble(egmMetaDto.getMetaDiskcheck().toString())){

                result = "<알림>"+ componetName + "이 사용하는 DISK 사용량이 "+ egmMetaDto.getMetaDiskcheck().toString() +"을 넘었습니다.";

            }



            String requestJson = "{\n" +
                    "  \"componetName\": \""+map.get("uid")+"\",\n" +
                    "  \"hostcpu\": \""+hostcpu+"\",\n" +
                    "  \"hostram\": \""+hostram+"\",\n" +
                    "  \"usedmn\": \""+usedmn+"\",\n" +
                    "  \"cpumn\": \""+cpumn+"\",\n" +
                    "  \"diskmn\": \""+diskmn+"\",\n" +
                    "  \"uptime\": \""+uptime+"\",\n" +
                    "  \"result\":\""+result+"\"\n"+
                    "}";


            logger.info("usedmn_data : " + usedmn );
            logger.info("cpumn_data : " + cpumn );
            logger.info("diskmn_data : " + diskmn );
            logger.info("uptime_data : " + uptime );


            json = gson.toJson(requestJson);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return json;
    }

    @PostMapping(value="/db_check")
    @ResponseBody
    public String dbcheck(@RequestBody String info) {
        String json = null;
        String input_json = null;

        HyperRestApiDto hyperRestApiDto =  hyperRestApiService.getPost("getTestData");

        try {
            Gson gson = new Gson();
            Map<Object, Object> map = new HashMap<Object, Object>();
            map = (Map<Object, Object>) gson.fromJson(info, map.getClass());

            input_json = gson.toJson(map);

            logger.info("info : " + input_json );

            String componetName = map.get("componetName").toString();

            EgmMetaDto egmMetaDto = egmMetaService.getComponetName(componetName);

            String hostcpu = egmMetaDto.getMetaCore().toString();
            String hostram = egmMetaDto.getMetaMem().toString();

            String uptime = this.UptimeGet(componetName, "Uptime", hyperRestApiDto);

            String usedmn = this.UsageGet(componetName,"Memory Usage",16 ,hyperRestApiDto);

            String cpumn = this.UsageGet(componetName,"System Details",16 ,hyperRestApiDto);

            String diskmn = this.UsageGet(componetName,"Disk Space",6 ,hyperRestApiDto);

            String result = "True"; //알람 테스트

            //메모리체크
            if(Double.parseDouble(usedmn) >= Double.parseDouble(egmMetaDto.getMetaMemcheck().toString())){

                result = "<알림>"+ componetName + "이 사용하는 메모리 사용량이  "+ egmMetaDto.getMetaMemcheck().toString() +"을 넘었습니다.";

            }

            if(Double.parseDouble(cpumn) >= Double.parseDouble(egmMetaDto.getMetaCpucheck().toString())){

                result = "<알림>"+ componetName + "이 사용하는 CPU 사용량이 "+ egmMetaDto.getMetaCpucheck().toString() +"을 넘었습니다.";

                this.setMmsIntsert(componetName, result , egmMetaDto,1l); //CPU 알람 조건

            }


            if(Double.parseDouble(diskmn) >= Double.parseDouble(egmMetaDto.getMetaDiskcheck().toString())){

                result = "<알림>"+ componetName + "이 사용하는 DISK 사용량이 "+ egmMetaDto.getMetaDiskcheck().toString() +"을 넘었습니다.";

            }


            String requestJson = "{\n" +
                    "  \"componetName\": \""+map.get("uid")+"\",\n" +
                    "  \"hostcpu\": \""+hostcpu+"\",\n" +
                    "  \"hostram\": \""+hostram+"\",\n" +
                    "  \"usedmn\": \""+usedmn+"\",\n" +
                    "  \"cpumn\": \""+cpumn+"\",\n" +
                    "  \"diskmn\": \""+diskmn+"\",\n" +
                    "  \"uptime\": \""+uptime+"\",\n" +
                    "  \"result\":\""+result+"\"\n"+
                    "}";


            logger.info("usedmn_data : " + usedmn );
            logger.info("cpumn_data : " + cpumn );
            logger.info("diskmn_data : " + diskmn );
            logger.info("uptime_data : " + uptime );


            json = gson.toJson(requestJson);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return json;
    }

    private String UsageGet(String componetName,String usage,int index, HyperRestApiDto hyperRestApiDto){

        String usageerest = restApiService.getDataUptime(componetName, hyperRestApiDto,usage, -10).getBody().toString();

        String usagedata[]=usageerest.split(",");

        logger.info("usagedata :" + usagedata[usagedata.length - 1 ].toString());

        String usageresult[] = usagedata[usagedata.length - 1 ].split(" ");

        logger.info("Rest Get usage result :" + usageresult[usageresult.length - index ].toString() );

        String usagere = usageresult[usageresult.length - index ].toString();

        return usagere;
    }


    private String UptimeGet(String componetName,String usage,HyperRestApiDto hyperRestApiDto){

        String uptimerest = restApiService.getDataUptime(componetName, hyperRestApiDto,usage, -10).getBody().toString();

        String uptimedata[]=uptimerest.split(",");

        logger.info("uptimedata :" + uptimedata[uptimedata.length - 1 ].toString());

        String uptimeresult[] = uptimedata[uptimedata.length - 1 ].split(" ");

        logger.info("Rest Get uptimeresult :" + uptimeresult[uptimeresult.length - 2 ].toString() );


        double day =  (Double.parseDouble(uptimeresult[uptimeresult.length - 2 ].toString()) / 60)/24;

        String uptime = String.format("%.1f", day) + " day";


        return uptime;
    }

    private void setMmsIntsert(String componetName, String result , EgmMetaDto egmMetaDto,long mmsid){

        LocalDateTime now = LocalDateTime.now();

        //result = "<알림>"+ componetName + "이 사용하는 DISK 사용량이 "+ egmMetaDto.getMetaDiskcheck().toString() +"을 넘었습니다.";

        MmsDto mmsDto = mmsService.getPost(mmsid);

        LguMmsDto lguMmsDto = new LguMmsDto();

        lguMmsDto.setSubject(mmsDto.getSubject());
        lguMmsDto.setPhone(mmsDto.getPhone());
        lguMmsDto.setCallback(mmsDto.getCallback());
        lguMmsDto.setStatus(mmsDto.getStatus());
        lguMmsDto.setReqdate(now);
        lguMmsDto.setMsg(result);
        lguMmsDto.setType(mmsDto.getType());

        logger.info("mmsDto_ MMS Data : " + lguMmsDto.toString());

        lguMmsService.savePost(lguMmsDto);
    }
}
