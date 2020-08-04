package com.hundsun.mailSender.service;

import com.hundsun.mailSender.dataobject.MailSenderInfoDO;
import com.hundsun.mailSender.dataobject.MailSenderModelDO;
import org.apache.ibatis.annotations.Param;

public interface SendMailConfig {
       public MailSenderModelDO getMailConfigByDomainId(@Param("domainId") String domainId);
}



