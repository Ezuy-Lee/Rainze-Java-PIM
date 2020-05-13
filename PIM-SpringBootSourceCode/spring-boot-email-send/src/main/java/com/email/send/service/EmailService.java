package com.email.send.service;

import com.email.send.model.SendEmailModel;

public interface EmailService {
    void sendEmail (String emailKey, SendEmailModel model) ;
}
