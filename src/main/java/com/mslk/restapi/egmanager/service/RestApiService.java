package com.mslk.restapi.egmanager.service;

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

import java.util.Arrays;
import java.util.HashMap;

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




    public ResponseEntity<Object> getData(String url , String managerurl) {
        //Spring restTemplate
        HashMap<String, Object> result = new HashMap<String, Object>();
        ResponseEntity<Object> resultMap = new ResponseEntity<>(null,null,200);

        logger.info("Rest getData Url : " + url);

        try {
            RestTemplate restTemplate = new RestTemplate();

            HttpHeaders header = new HttpHeaders();

            header.set("Content-Type", "application/json;");
            header.set("Accept", "application/json;");
            header.add("managerurl", managerurl);
            header.add("user", "admin");
            header.add("pwd", "bHlpanVuIUAwOQ==");

            HttpEntity<?> entity = new HttpEntity<>(header);

            logger.info("Rest header header: " + header.toString());
            logger.info("Rest headers entity : " + entity.toString());

            UriComponents uri = UriComponentsBuilder.fromHttpUrl(url).build();

            resultMap = restTemplate.exchange(uri.toString(), HttpMethod.GET, entity, Object.class);

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
