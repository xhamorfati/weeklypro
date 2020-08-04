package com.hundsun.mailSender.service.impl;

import com.hundsun.mailSender.dataobject.MailSenderInfoDO;
import com.hundsun.mailSender.dataobject.MailSenderModelDO;
import com.hundsun.mailSender.mapper.MailSenderMapper;
import com.hundsun.showinfomation.mapper.WeeklyproDOMapper;
import com.hundsun.mailSender.service.SendMailConfig;
import org.springframework.beans.factory.annotation.Autowired;

public class MailConfigImpl implements SendMailConfig {
    @Autowired
    private MailSenderMapper mailmapper;
    @Override
    public MailSenderModelDO getMailConfigByDomainId(String domainId) {
        MailSenderModelDO mailmodel = mailmapper.findMailSetting(domainId);
        return mailmodel;
    }
}
