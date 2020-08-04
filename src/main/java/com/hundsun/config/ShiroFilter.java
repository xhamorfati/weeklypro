package com.hundsun.config;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
import org.apache.shiro.web.util.WebUtils;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class ShiroFilter  extends FormAuthenticationFilter {
//    @Override
//    protected void issueSuccessRedirect(ServletRequest request, ServletResponse response) throws Exception {
//        WebUtils.issueRedirect(request, response,getSuccessUrl(), null, true);
//    }

    @Override
    public boolean onPreHandle(ServletRequest request, ServletResponse response,
                               Object mappedValue) throws Exception {
        boolean res = this.isAccessAllowed(request, response, mappedValue) || this.onAccessDenied(request, response, mappedValue);

        System.out.println("12121******************"+res);
        return true;
    }

}
