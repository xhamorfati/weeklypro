package com.hundsun.config;

import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.cas.CasFilter;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.util.WebUtils;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class MyCasFilter extends CasFilter {
    @Override
    protected boolean onLoginSuccess(AuthenticationToken token, Subject subject, ServletRequest request,
                                     ServletResponse response) throws Exception {
        boolean flag = true;
        String successUrl = this.getSuccessUrl();
        if("".equals(successUrl)){
            successUrl = DEFAULT_SUCCESS_URL;
        }
        WebUtils.issueRedirect(request, response, successUrl, null, flag);
        //we handled the success redirect directly, prevent the chain from continuing:
        return false;
    }


}
