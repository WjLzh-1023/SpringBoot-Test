package com.util;

import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authz.AuthorizationFilter;
import org.springframework.stereotype.Controller;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

//@Controller("roleOrFilter")
public class RoleFilter extends AuthorizationFilter {
    @Override
    protected boolean isAccessAllowed(ServletRequest servletRequest, ServletResponse servletResponse, Object object) throws Exception {
        String roles[] = (String[]) object;
        Subject subject = getSubject(servletRequest, servletResponse);
        if (roles == null || roles.length == 0) {

            return true;
        }

        for (String role : roles) {
            if (subject.hasRole(role)) {
                return true;
            }
        }
        return false;
    }
}
