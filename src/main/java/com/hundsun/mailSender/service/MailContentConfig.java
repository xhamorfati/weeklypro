package com.hundsun.mailSender.service;

import com.hundsun.mailSender.dataobject.MailConfigInfoDO;
import org.apache.ibatis.annotations.Param;

public interface MailContentConfig {
    public MailConfigInfoDO getMailContentConfigbyUserID(@Param("domainId") String domainId);
}
