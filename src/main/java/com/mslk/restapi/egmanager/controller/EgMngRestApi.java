package com.mslk.restapi.egmanager.controller;

import com.mslk.restapi.domain.response.CommonResponse;
import com.mslk.restapi.domain.response.ErrorResponse;
import com.mslk.restapi.wsouserapi.service.Wso2UserJson;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.apache.commons.codec.binary.Base64;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Objects;

@Tag(name = "Eg Mng Check ", description = "Eg Mng Check API")
@RestController
@RequestMapping("/api/EgMng")
@RequiredArgsConstructor
public class EgMngRestApi {

    private Wso2UserJson wso2UserJson = new Wso2UserJson();

    @Autowired
    private RestTemplate restTemplate;

    @Operation(summary = "EG Manager \n" +
            "Alarm 을 확인 하기 위해 사용 하는 API.", description = "EG Manager Alarm Count를 가져온다.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "OK", content = @Content(schema = @Schema(implementation = CommonResponse.class))),
            @ApiResponse(responseCode = "400", description = "BAD REQUEST" , content = @Content(schema = @Schema(implementation = ErrorResponse.class))),
            @ApiResponse(responseCode = "404", description = "NOT FOUND" , content = @Content(schema = @Schema(implementation = ErrorResponse.class))),
            @ApiResponse(responseCode = "500", description = "내부 서버 오류", content = @Content(schema = @Schema(implementation = ErrorResponse.class)))

    })
    @Parameters({
            @Parameter(name = "appUrl", description = "Eg Manager URL ", example = "http://172.30.1.109:7077/api/eg/analytics/getAlarmCount"),
            @Parameter(name = "managerurl", description = "Eg Manager Header ManagerURL ", example = "http://172.30.1.109:7077"),
            @Parameter(name = "user", description = "Eg Manager Header USER ", example = "admin"),
            @Parameter(name = "pwd", description = "Eg Manager Header pwd ", example = "bHlpanVuIUAwOQ==")
    })
    @ResponseBody
    @GetMapping( "/getAlarmCount")
    public ResponseEntity<String> getAlarmCount(
            @RequestParam(value = "appUrl") String appUrl,
            @RequestParam(value = "managerurl") String managerurl,
            @RequestParam(value = "user") String user,
            @RequestParam(value = "pwd") String pwd

    ) {

        // API 기본 인증 헤드 생성
       /* String apiUrl = "http://172.30.1.109:7077/api/eg/analytics/getAlarmCount";    // 각자 상황에 맞는 IP & url 사용
        String managerurl = "http://172.30.1.109:7077";
        String user = "admin";
        String pwd ="bHlpanVuIUAwOQ==";*/

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

        ResponseEntity<String> responseEntity = loginRestTemplate.exchange(appUrl, HttpMethod.POST, req, String.class);

        String result = Objects.requireNonNull(responseEntity.getBody()).toString();

        return  ResponseEntity.ok().body(result);
    }


    //getComponentsDetails

    @Operation(summary = "EG Manager \n" +
            "설치된 컴포넌트 정보를 확인 하기 위해 사용 하는 API.", description = "EG Manager A설치된 컴포넌트 정보를 가져온다.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "OK", content = @Content(schema = @Schema(implementation = CommonResponse.class))),
            @ApiResponse(responseCode = "400", description = "BAD REQUEST" , content = @Content(schema = @Schema(implementation = ErrorResponse.class))),
            @ApiResponse(responseCode = "404", description = "NOT FOUND" , content = @Content(schema = @Schema(implementation = ErrorResponse.class))),
            @ApiResponse(responseCode = "500", description = "내부 서버 오류", content = @Content(schema = @Schema(implementation = ErrorResponse.class)))

    })
    @Parameters({
            @Parameter(name = "appUrl", description = "Eg Manager URL ", example = "http://172.30.1.109:7077/api/eg/analytics/getComponentsDetails"),
            @Parameter(name = "managerurl", description = "Eg Manager Header ManagerURL ", example = "http://172.30.1.109:7077"),
            @Parameter(name = "user", description = "Eg Manager Header USER ", example = "admin"),
            @Parameter(name = "pwd", description = "Eg Manager Header pwd ", example = "bHlpanVuIUAwOQ==")
    })
    @ResponseBody
    @GetMapping( "/getComponentsDetails")
    public ResponseEntity<String> getComponentsDetails(
            @RequestParam(value = "appUrl") String appUrl,
            @RequestParam(value = "managerurl") String managerurl,
            @RequestParam(value = "user") String user,
            @RequestParam(value = "pwd") String pwd

    ) {

        // API 기본 인증 헤드 생성
       /* String apiUrl = "http://172.30.1.109:7077/api/eg/analytics/getAlarmCount";    // 각자 상황에 맞는 IP & url 사용
        String managerurl = "http://172.30.1.109:7077";
        String user = "admin";
        String pwd ="bHlpanVuIUAwOQ==";*/

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

        ResponseEntity<String> responseEntity = loginRestTemplate.exchange(appUrl, HttpMethod.POST, req, String.class);

        String result = Objects.requireNonNull(responseEntity.getBody()).toString();

        return  ResponseEntity.ok().body(result);
    }


    @Operation(summary = "EG Manager \n" +
            "componentName을 기반으로 데이터 추출 하는  API.", description = "EG Manager getTestData 를 이용하여 데이터를 가져온다.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "OK", content = @Content(schema = @Schema(implementation = CommonResponse.class))),
            @ApiResponse(responseCode = "400", description = "BAD REQUEST" , content = @Content(schema = @Schema(implementation = ErrorResponse.class))),
            @ApiResponse(responseCode = "404", description = "NOT FOUND" , content = @Content(schema = @Schema(implementation = ErrorResponse.class))),
            @ApiResponse(responseCode = "500", description = "내부 서버 오류", content = @Content(schema = @Schema(implementation = ErrorResponse.class)))

    })
    @Parameters({
            @Parameter(name = "appUrl", description = "Eg Manager URL ", example = "http://172.30.1.109:7077/api/eg/analytics/getTestData"),
            @Parameter(name = "managerurl", description = "Eg Manager Header ManagerURL ", example = "http://172.30.1.109:7077"),
            @Parameter(name = "user", description = "Eg Manager Header USER ", example = "admin"),
            @Parameter(name = "pwd", description = "Eg Manager Header pwd ", example = "bHlpanVuIUAwOQ==")
    })
    @ResponseBody
    @GetMapping( "/getTestData")
    public ResponseEntity<String> getTestData(
            @RequestParam(value = "appUrl") String appUrl,
            @RequestParam(value = "managerurl") String managerurl,
            @RequestParam(value = "user") String user,
            @RequestParam(value = "pwd") String pwd

    ) {

        // API 기본 인증 헤드 생성
       /* String apiUrl = "http://172.30.1.109:7077/api/eg/analytics/getAlarmCount";    // 각자 상황에 맞는 IP & url 사용
        String managerurl = "http://172.30.1.109:7077";
        String user = "admin";
        String pwd ="bHlpanVuIUAwOQ==";*/

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON_UTF8);
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        headers.add("managerurl", managerurl);
        headers.add("user", user);
        headers.add("pwd", pwd);

        String requestJson = "{\n" +
                "  \"componentName\": \"gpu.hypermakina.net\",\n" +
                "  \"lastmeasure\":\"true\",\n"+
        "  \"startDate\":\"2023-02-07 15:35:00\",\n"+
        "  \"endDate\":\"2023-02-07 15:40:00\",\n"+
        "  \"test\":\"Uptime\"\n"+
        "}";



        HttpEntity<String> req = new HttpEntity<>(requestJson, headers);

        CloseableHttpClient httpClient = HttpClients.custom()
                .setMaxConnTotal(100)
                .setMaxConnPerRoute(10)
                .disableCookieManagement()
                .build();
        HttpComponentsClientHttpRequestFactory requestFactory = new HttpComponentsClientHttpRequestFactory();
        requestFactory.setHttpClient(httpClient);
        RestTemplate loginRestTemplate = new RestTemplate(requestFactory);

        ResponseEntity<String> responseEntity = loginRestTemplate.exchange(appUrl, HttpMethod.POST, req, String.class);

        String result = Objects.requireNonNull(responseEntity.getBody()).toString();

        return  ResponseEntity.ok().body(result);
    }



    @Operation(summary = "EG Manager \n" +
            "특정 필터를 기반으로 데이터 추출 하는 API.", description = "EG Manager 특정 필터 조건에 만족하는 데이터를 가져온다.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "OK", content = @Content(schema = @Schema(implementation = CommonResponse.class))),
            @ApiResponse(responseCode = "400", description = "BAD REQUEST" , content = @Content(schema = @Schema(implementation = ErrorResponse.class))),
            @ApiResponse(responseCode = "404", description = "NOT FOUND" , content = @Content(schema = @Schema(implementation = ErrorResponse.class))),
            @ApiResponse(responseCode = "500", description = "내부 서버 오류", content = @Content(schema = @Schema(implementation = ErrorResponse.class)))

    })
    @Parameters({
            @Parameter(name = "appUrl", description = "Eg Manager URL ", example = "http://172.30.1.109:7077/api/eg/analytics/getInfraHealth"),
            @Parameter(name = "managerurl", description = "Eg Manager Header ManagerURL ", example = "http://172.30.1.109:7077"),
            @Parameter(name = "user", description = "Eg Manager Header USER ", example = "admin"),
            @Parameter(name = "pwd", description = "Eg Manager Header pwd ", example = "bHlpanVuIUAwOQ==")
    })
    @ResponseBody
    @GetMapping( "/getInfraHealth")
    public ResponseEntity<String> getInfraHealth(
            @RequestParam(value = "appUrl") String appUrl,
            @RequestParam(value = "managerurl") String managerurl,
            @RequestParam(value = "user") String user,
            @RequestParam(value = "pwd") String pwd

    ) {

        // API 기본 인증 헤드 생성
       /* String apiUrl = "http://172.30.1.109:7077/api/eg/analytics/getAlarmCount";    // 각자 상황에 맞는 IP & url 사용
        String managerurl = "http://172.30.1.109:7077";
        String user = "admin";
        String pwd ="bHlpanVuIUAwOQ==";*/

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON_UTF8);
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        headers.add("managerurl", managerurl);
        headers.add("user", user);
        headers.add("pwd", pwd);


        String requestJson = "{\n" +
            " \"filterBy\":\"ComponentType\",\n" +
             "   \"filterValues\":\"Tomcat\" \n" +
        " } ";


        HttpEntity<String> req = new HttpEntity<>(requestJson, headers);

        CloseableHttpClient httpClient = HttpClients.custom()
                .setMaxConnTotal(100)
                .setMaxConnPerRoute(10)
                .disableCookieManagement()
                .build();
        HttpComponentsClientHttpRequestFactory requestFactory = new HttpComponentsClientHttpRequestFactory();
        requestFactory.setHttpClient(httpClient);
        RestTemplate loginRestTemplate = new RestTemplate(requestFactory);

        ResponseEntity<String> responseEntity = loginRestTemplate.exchange(appUrl, HttpMethod.POST, req, String.class);

        String result = Objects.requireNonNull(responseEntity.getBody()).toString();

        return  ResponseEntity.ok().body(result);
    }


    //getHistoricalData
    @Operation(summary = "EG Manager \n" +
            "componentName을 기반으로 데이터 추출 화는  API.", description = "EG Manager getHistoricalData를 이용하여 데이터를 가져온다.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "OK", content = @Content(schema = @Schema(implementation = CommonResponse.class))),
            @ApiResponse(responseCode = "400", description = "BAD REQUEST" , content = @Content(schema = @Schema(implementation = ErrorResponse.class))),
            @ApiResponse(responseCode = "404", description = "NOT FOUND" , content = @Content(schema = @Schema(implementation = ErrorResponse.class))),
            @ApiResponse(responseCode = "500", description = "내부 서버 오류", content = @Content(schema = @Schema(implementation = ErrorResponse.class)))

    })
    @Parameters({
            @Parameter(name = "appUrl", description = "Eg Manager URL ", example = "http://172.30.1.109:7077/api/eg/analytics/getHistoricalData"),
            @Parameter(name = "managerurl", description = "Eg Manager Header ManagerURL ", example = "http://172.30.1.109:7077"),
            @Parameter(name = "user", description = "Eg Manager Header USER ", example = "admin"),
            @Parameter(name = "pwd", description = "Eg Manager Header pwd ", example = "bHlpanVuIUAwOQ==")
    })
    @ResponseBody
    @GetMapping( "/getHistoricalData")
    public ResponseEntity<String> getHistoricalData(
            @RequestParam(value = "appUrl") String appUrl,
            @RequestParam(value = "managerurl") String managerurl,
            @RequestParam(value = "user") String user,
            @RequestParam(value = "pwd") String pwd

    ) {

        // API 기본 인증 헤드 생성
       /* String apiUrl = "http://172.30.1.109:7077/api/eg/analytics/getAlarmCount";    // 각자 상황에 맞는 IP & url 사용
        String managerurl = "http://172.30.1.109:7077";
        String user = "admin";
        String pwd ="bHlpanVuIUAwOQ==";*/

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON_UTF8);
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        headers.add("managerurl", managerurl);
        headers.add("user", user);
        headers.add("pwd", pwd);


        String requestJson = "{\n" +
            " \"timeline\":\"1 hour\",\n" +
        " \"componentName\": \"gpu.hypermakina.net\",\n" +
        " \"componentType\":\"linux\",\n" +
        " \"test\":\"Memory Usage\",\n" +
        " \"measure\":\"Free memory\"\n" +
        "}";


        HttpEntity<String> req = new HttpEntity<>(requestJson, headers);

        CloseableHttpClient httpClient = HttpClients.custom()
                .setMaxConnTotal(100)
                .setMaxConnPerRoute(10)
                .disableCookieManagement()
                .build();
        HttpComponentsClientHttpRequestFactory requestFactory = new HttpComponentsClientHttpRequestFactory();
        requestFactory.setHttpClient(httpClient);
        RestTemplate loginRestTemplate = new RestTemplate(requestFactory);

        ResponseEntity<String> responseEntity = loginRestTemplate.exchange(appUrl, HttpMethod.POST, req, String.class);

        String result = Objects.requireNonNull(responseEntity.getBody()).toString();

        return  ResponseEntity.ok().body(result);
    }

}
