package com.mslk.hypermakina.util;

import com.mslk.hypermakina.logmng.dto.Gitte0001Dto;
import com.mslk.hypermakina.logmng.service.Gitte0001Service;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Slf4j
public class LoggingUtil {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    private Gitte0001Service gitte0001Service;  // 계정 연결 관련 로그 관리

    public void logSave(String dcd, String usrNm, String usrEn, String reqNm, String mnuId ){

        Gitte0001Dto gitte0001Dto = new Gitte0001Dto();

        gitte0001Dto.setDcd(dcd); //'부서코드',
        gitte0001Dto.setReqNm(usrNm); //'사번',
        gitte0001Dto.setUsrEn(usrEn); // '성명',
        gitte0001Dto.setReqNm(reqNm); //'연동 정보',
        gitte0001Dto.setMnuId(mnuId); //'결과',

        gitte0001Service.savePost(gitte0001Dto);

    }
}
