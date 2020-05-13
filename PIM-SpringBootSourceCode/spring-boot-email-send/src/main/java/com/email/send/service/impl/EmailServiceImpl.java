package com.email.send.service.impl;

import com.email.send.model.SendEmailModel;
import com.email.send.param.BodyType;
import com.email.send.param.EmailType;
import com.email.send.service.EmailService;
import com.email.send.util.EmailUtil;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
@Service
public class EmailServiceImpl implements EmailService {

    @Async("taskExecutor")
    @Override
    public void sendEmail(String emailKey, SendEmailModel model) {
        try{
            // 异步执行
            Thread.sleep(1000);
            String textBody = EmailUtil.convertTextModel(BodyType.getByCode(emailKey),"雨泽","一笑");
            // 发送文本邮件
            EmailUtil.sendEmail01(model.getReceiver(), EmailType.getByCode(emailKey),textBody);
            // 发送复杂邮件:文本+图片+附件
            String body = "自定义图片：<img src='cid:gzh.jpg'/>,网络图片：<img src='http://pic37.nipic.com/20140113/8800276_184927469000_2.png'/>";
            // EmailUtil.sendEmail02(model.getReceiver(),"文本+图片+附件",body);
        } catch (Exception e){
            e.printStackTrace();
        }

    }
}
