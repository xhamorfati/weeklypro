package com.hundsun.mailSender.service.model;

import com.hundsun.mailSender.dataobject.MailSenderInfoDO;

public interface WeeklyProService {
        public MailSenderInfoDO getWeeklyinfoByDomainId(String domainId);

}
