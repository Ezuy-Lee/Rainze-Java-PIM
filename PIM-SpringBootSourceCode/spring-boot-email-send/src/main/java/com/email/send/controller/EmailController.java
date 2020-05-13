package com.email.send.controller;

import com.email.send.model.SendEmailModel;
import com.email.send.param.EmailType;
import com.email.send.service.EmailService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.annotation.Resource;

@RestController
public class EmailController {

    private static final Logger LOGGER = LoggerFactory.getLogger(EmailController.class) ;

    @Resource
    private EmailService emailService ;

    @RequestMapping("/sendEmail")
    public String sendEmail (){
        SendEmailModel model = new SendEmailModel() ;
        model.setReceiver("619147075@qq.com");
        emailService.sendEmail(EmailType.EMAIL_TEXT_KEY.getCode(),model);
        LOGGER.info("执行结束====>>");
        return "success" ;
    }
}
