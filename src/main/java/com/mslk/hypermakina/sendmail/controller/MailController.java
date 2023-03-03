package com.mslk.hypermakina.sendmail.controller;

import com.mslk.hypermakina.sendmail.service.MailTO;
import com.mslk.hypermakina.sendmail.service.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RequestMapping("/mail")
public class MailController {

    private MailService mailService;

    @GetMapping("/send")
    public MailTO sendTestMail(String email) {
        MailTO mailTO = new MailTO();

        mailTO.setAddress(email);
        mailTO.setTitle("밤둘레 님이 발송한 이메일입니다.");
        mailTO.setMessage("안녕하세요. 반가워요!");

        mailService.sendMail(mailTO);

        return mailTO;
    }

}
