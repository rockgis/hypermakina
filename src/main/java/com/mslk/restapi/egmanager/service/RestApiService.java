package com.mslk.restapi.egmanager.service;

import com.mslk.restapi.dto.HyperRestApiDto;
import com.mslk.sns.department.dto.DepartmentDto;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.*;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

@Slf4j
@AllArgsConstructor
@Service
public class RestApiService {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());



    public ResponseEntity<Object> postData(String url , String managerurl, String user, String pwd) {
        //Spring restTemplate
        HashMap<String, Object> result = new HashMap<String, Object>();
        ResponseEntity<Object> resultMap = new ResponseEntity<>(null,null,200);

        try {

            logger.info("Rest getPostData Url : " + url);

            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON_UTF8);
            headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
            headers.add("managerurl", managerurl);
            headers.add("user", user);
            headers.add("pwd", pwd);

            HttpEntity<String> req = new HttpEntity<>("", headers);

            logger.info("Rest req Header : " + req);

            CloseableHttpClient httpClient = HttpClients.custom()
                    .setMaxConnTotal(100)
                    .setMaxConnPerRoute(10)
                    .disableCookieManagement()
                    .build();
            HttpComponentsClientHttpRequestFactory requestFactory = new HttpComponentsClientHttpRequestFactory();
            requestFactory.setHttpClient(httpClient);

            RestTemplate egRestTemplate = new RestTemplate(requestFactory);

            UriComponents uri = UriComponentsBuilder.fromHttpUrl(url).build();

            //ResponseEntity<String> responseEntity = egRestTemplate.exchange(url, HttpMethod.POST, new HttpEntity<>(headers), String.class);

            //String responseEntityresult = Objects.requireNonNull(responseEntity.getBody()).toString();



            resultMap = egRestTemplate.exchange(url, HttpMethod.POST, req, Object.class);

            result.put("statusCode", resultMap.getStatusCodeValue()); //http status code를 확인
            result.put("header", resultMap.getHeaders()); //헤더 정보 확인
            result.put("body", resultMap.getBody()); //실제 데이터 정보 확인

            //에러처리해야댐
        } catch (HttpClientErrorException | HttpServerErrorException e) {
            result.put("statusCode", e.getRawStatusCode());
            result.put("body"  , e.getStatusText());
            logger.info("error : "+ e.toString());

            return resultMap;
        }
        catch (Exception e) {
            result.put("statusCode", "999");
            result.put("body"  , "excpetion오류");
            logger.info("excpetion오류" + e.toString());

            return resultMap;

        }

        return resultMap;


    }


    public ResponseEntity<String> getAlarmCountData(HyperRestApiDto hyperRestApiDto){


        String apiUrl = hyperRestApiDto.getRestServer()+hyperRestApiDto.getRestFunction();//"http://192.168.10.62:7077/api/eg/analytics/getAlarmCount";    // 각자 상황에 맞는 IP & url 사용
        // String managerurl = "http://172.30.1.109:7077";
        String managerurl =  hyperRestApiDto.getManagerurl();//"http://192.168.10.62:7077";
        String user =  hyperRestApiDto.getUsrEn();//"admin";
        String pwd =hyperRestApiDto.getUsrPw();//"c25zMTIzNCE=";

        logger.info("Rest getAlarmCountData URL :" + apiUrl);

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

        return res;
    }


    public ResponseEntity<String> getTestData(String componentName,String test,HyperRestApiDto hyperRestApiDto){


        String apiUrl = hyperRestApiDto.getRestServer()+hyperRestApiDto.getRestFunction();//"http://192.168.10.62:7077/api/eg/analytics/getAlarmCount";    // 각자 상황에 맞는 IP & url 사용
        // String managerurl = "http://172.30.1.109:7077";
        String managerurl =  hyperRestApiDto.getManagerurl();//"http://192.168.10.62:7077";
        String user =  hyperRestApiDto.getUsrEn();//"admin";
        String pwd =hyperRestApiDto.getUsrPw();//"c25zMTIzNCE=";){

        logger.info("Rest getTestData URL :" + apiUrl);

        Date date = new Date();

        SimpleDateFormat sdformat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        String endDate = sdformat.format(date);

        logger.info("현재 시간  : "+ endDate);

        // 포맷변경 ( 년월일 시분초)
        // Java 시간 더하기

        Calendar cal = Calendar.getInstance();

        cal.setTime(date);

        // 10분 더하기
        cal.add(Calendar.MINUTE, -120);

        String startDate = sdformat.format(cal.getTime());
        logger.info("120분 전 : " + startDate);

       /* cal.setTime(date);

        // 1시간 전
        cal.add(Calendar.HOUR, -1);

        startDate = sdformat.format(cal.getTime());
        logger.info("1시간 전 : " + startDate);
        */


        String requestJson = "{\n" +
                "  \"componentName\": \""+componentName+"\",\n" +
                "  \"lastmeasure\":\"true\",\n"+
                "  \"startDate\":\""+ startDate + "\",\n"+
                "  \"endDate\":\""+ endDate + "\",\n"+
                "  \"test\":\""+test+"\""+
                "}";

        logger.info("requestJson : " + requestJson);


        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON_UTF8);
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        headers.add("managerurl", managerurl);
        headers.add("user", user);
        headers.add("pwd", pwd);

        HttpEntity<String> req = new HttpEntity<>(requestJson, headers);

        CloseableHttpClient httpClient = HttpClients.custom()
                .setMaxConnTotal(100)
                .setMaxConnPerRoute(10)
                .disableCookieManagement()
                .build();
        HttpComponentsClientHttpRequestFactory requestFactory = new HttpComponentsClientHttpRequestFactory();
        requestFactory.setHttpClient(httpClient);
        RestTemplate loginRestTemplate = new RestTemplate(requestFactory);

        ResponseEntity<String> res = loginRestTemplate.exchange(apiUrl, HttpMethod.POST, req, String.class);

        return res;
    }




    public ResponseEntity<String> getData(String componentName,HyperRestApiDto hyperRestApiDto) {
        //Spring restTemplate
        HashMap<String, Object> result = new HashMap<String, Object>();
        ResponseEntity<String> resultMap = new ResponseEntity<>(null,null,200);

        String apiUrl = hyperRestApiDto.getRestServer()+hyperRestApiDto.getRestFunction();//"http://192.168.10.62:7077/api/eg/analytics/getAlarmCount";    // 각자 상황에 맞는 IP & url 사용
        // String managerurl = "http://172.30.1.109:7077";
        String managerurl =  hyperRestApiDto.getManagerurl();//"http://192.168.10.62:7077";
        String user =  hyperRestApiDto.getUsrEn();//"admin";
        String pwd =hyperRestApiDto.getUsrPw();//"c25zMTIzNCE=";){

        logger.info("Rest getTestData URL :" + apiUrl);

        Date date = new Date();

        SimpleDateFormat sdformat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        String endDate = sdformat.format(date);

        logger.info("현재 시간  : "+ endDate);

        // 포맷변경 ( 년월일 시분초)
        // Java 시간 더하기

        Calendar cal = Calendar.getInstance();

        cal.setTime(date);

        // 10분 더하기
        cal.add(Calendar.MINUTE, -60);

        String startDate = sdformat.format(cal.getTime());
        logger.info("60분후 : " + startDate);

       /* cal.setTime(date);

        // 1시간 전
        cal.add(Calendar.HOUR, -1);

        startDate = sdformat.format(cal.getTime());
        logger.info("1시간 전 : " + startDate);
        */


        String requestJson = "{\n" +
                "  \"componentName\": \""+componentName+"\",\n" +
                "  \"lastmeasure\":\"true\",\n"+
                "  \"startDate\":\""+ startDate + "\",\n"+
                "  \"endDate\":\""+ endDate + "\",\n"+
                "  \"test\":\"System Details\",\n"+
                "  \"info\":\"Summary\"\n"+
                "}";

        logger.info("requestJson : " + requestJson);



        try {


            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON_UTF8);
            headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
            headers.add("managerurl", managerurl);
            headers.add("user", user);
            headers.add("pwd", pwd);

            HttpEntity<String> req = new HttpEntity<>(requestJson, headers);

            CloseableHttpClient httpClient = HttpClients.custom()
                    .setMaxConnTotal(100)
                    .setMaxConnPerRoute(10)
                    .disableCookieManagement()
                    .build();
            HttpComponentsClientHttpRequestFactory requestFactory = new HttpComponentsClientHttpRequestFactory();
            requestFactory.setHttpClient(httpClient);
            RestTemplate loginRestTemplate = new RestTemplate(requestFactory);

            resultMap = loginRestTemplate.exchange(apiUrl, HttpMethod.POST, req, String.class);

            //resultMap = restTemplate.exchange(uri.toString(), HttpMethod.GET, entity, Object.class);

            result.put("statusCode", resultMap.getStatusCodeValue()); //http status code를 확인
            result.put("header", resultMap.getHeaders()); //헤더 정보 확인
            result.put("body", resultMap.getBody()); //실제 데이터 정보 확인

            //에러처리해야댐
        } catch (HttpClientErrorException | HttpServerErrorException e) {
            result.put("statusCode", e.getRawStatusCode());
            result.put("body"  , e.getStatusText());
            System.out.println("error");
            System.out.println(e.toString());

            return resultMap;
        }
        catch (Exception e) {
            result.put("statusCode", "999");
            result.put("body"  , "excpetion오류");
            System.out.println(e.toString());

            return resultMap;

        }

        return resultMap;

    }


    public ResponseEntity<String> getDataUptime(String componentName,HyperRestApiDto hyperRestApiDto, String testdata, int min) {
        //Spring restTemplate
        HashMap<String, Object> result = new HashMap<String, Object>();
        ResponseEntity<String> resultMap = new ResponseEntity<>(null,null,200);

        String apiUrl = hyperRestApiDto.getRestServer()+hyperRestApiDto.getRestFunction();//"http://192.168.10.62:7077/api/eg/analytics/getAlarmCount";    // 각자 상황에 맞는 IP & url 사용
        // String managerurl = "http://172.30.1.109:7077";
        String managerurl =  hyperRestApiDto.getManagerurl();//"http://192.168.10.62:7077";
        String user =  hyperRestApiDto.getUsrEn();//"admin";
        String pwd =hyperRestApiDto.getUsrPw();//"c25zMTIzNCE=";){

        logger.info("Rest getTestData URL :" + apiUrl);

        Date date = new Date();

        SimpleDateFormat sdformat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        String endDate = sdformat.format(date);

        logger.info("현재 시간  : "+ endDate);

        // 포맷변경 ( 년월일 시분초)
        // Java 시간 더하기

        Calendar cal = Calendar.getInstance();

        cal.setTime(date);

        // 10분 더하기
        cal.add(Calendar.MINUTE, min);

        String startDate = sdformat.format(cal.getTime());
        logger.info("60분후 : " + startDate);

       /* cal.setTime(date);

        // 1시간 전
        cal.add(Calendar.HOUR, -1);

        startDate = sdformat.format(cal.getTime());
        logger.info("1시간 전 : " + startDate);
        */


        String requestJson = "{\n" +
                "  \"componentName\": \""+componentName+"\",\n" +
                "  \"lastmeasure\":\"true\",\n"+
                "  \"startDate\":\""+ startDate + "\",\n"+
                "  \"endDate\":\""+ endDate + "\",\n"+
                "  \"test\":\""+ testdata + "\""+
                "}";



        logger.info("requestJson : " + requestJson);



        try {


            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON_UTF8);
            headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
            headers.add("managerurl", managerurl);
            headers.add("user", user);
            headers.add("pwd", pwd);

            HttpEntity<String> req = new HttpEntity<>(requestJson, headers);

            CloseableHttpClient httpClient = HttpClients.custom()
                    .setMaxConnTotal(100)
                    .setMaxConnPerRoute(10)
                    .disableCookieManagement()
                    .build();
            HttpComponentsClientHttpRequestFactory requestFactory = new HttpComponentsClientHttpRequestFactory();
            requestFactory.setHttpClient(httpClient);
            RestTemplate loginRestTemplate = new RestTemplate(requestFactory);

            resultMap = loginRestTemplate.exchange(apiUrl, HttpMethod.POST, req, String.class);

            //resultMap = restTemplate.exchange(uri.toString(), HttpMethod.GET, entity, Object.class);

            result.put("statusCode", resultMap.getStatusCodeValue()); //http status code를 확인
            result.put("header", resultMap.getHeaders()); //헤더 정보 확인
            result.put("body", resultMap.getBody()); //실제 데이터 정보 확인

            //에러처리해야댐
        } catch (HttpClientErrorException | HttpServerErrorException e) {
            result.put("statusCode", e.getRawStatusCode());
            result.put("body"  , e.getStatusText());
            System.out.println("error");
            System.out.println(e.toString());

            return resultMap;
        }
        catch (Exception e) {
            result.put("statusCode", "999");
            result.put("body"  , "excpetion오류");
            System.out.println(e.toString());

            return resultMap;

        }

        return resultMap;

    }
}
