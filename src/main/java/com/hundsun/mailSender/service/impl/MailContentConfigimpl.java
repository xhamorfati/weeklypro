package com.hundsun.mailSender.service.impl;

import com.hundsun.mailSender.dataobject.MailConfigInfoDO;
import com.hundsun.mailSender.mapper.MailSenderMapper;
import com.hundsun.showinfomation.mapper.WeeklyproDOMapper;
import com.hundsun.mailSender.service.MailContentConfig;
import org.springframework.beans.factory.annotation.Autowired;

public class MailContentConfigimpl implements MailContentConfig {
    @Autowired
    private MailSenderMapper mailmapper;

    @Override
    public MailConfigInfoDO getMailContentConfigbyUserID(String domainId) {
        MailConfigInfoDO  findmailconfig= mailmapper.findMailConfig(domainId);
        return findmailconfig;
    }
}
