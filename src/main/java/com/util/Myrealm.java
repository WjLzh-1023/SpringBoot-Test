package com.util;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import com.model.Employees;
import com.model.Permission;
import com.service.EmpService;
import com.service.PermService;

import java.util.List;

@Controller
public class Myrealm extends AuthorizingRealm {

    @Autowired(required = false)
    EmpService empService;


    @Autowired(required = false)
    PermService permService;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();

        /*此处为写死的授权信息
        //授权角色
        simpleAuthorizationInfo.addRole("wujun");
        //授权权限
        simpleAuthorizationInfo.addStringPermission("emp:list");
        return simpleAuthorizationInfo;*/

        /*此处为数据库查询权限*/
        Subject subject = SecurityUtils.getSubject();
        Employees principal = (Employees) subject.getPrincipal();
        //查询后台信息
        simpleAuthorizationInfo.addRole(principal.getRolelnfo());
        //授权角色
        List<Permission> permsByRoleid = permService.getPermsByRoleid(principal.getRoleid());
        for (Permission permission : permsByRoleid) {
            if(permission.getPinfo()!=null&&!"".equals(permission.getPinfo().trim())){
                simpleAuthorizationInfo.addStringPermission(permission.getPinfo());
            }

        }
        //授权权限
        return simpleAuthorizationInfo;
    }

    //认证登录
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {

        UsernamePasswordToken up = (UsernamePasswordToken) authenticationToken;

        String loginName = up.getUsername();

        Employees emp = empService.getByUserName(loginName);
        if (emp == null) {
            return null;
        } else {
            return new SimpleAuthenticationInfo(emp, emp.getPassword(), this.getName());
        }
    }
}
