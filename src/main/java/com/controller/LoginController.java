package com.controller;


import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.model.Employees;

@Controller
public class LoginController {

    @RequestMapping("/user/login")
    public String login(Employees employees) {

        AuthenticationToken token = new UsernamePasswordToken(employees.getUsername(), employees.getPassword());

        Subject subject = SecurityUtils.getSubject();
        try {
            subject.login(token);
            UsernamePasswordToken up = (UsernamePasswordToken) token;

            String loginName = up.getUsername();
            return "redirect:/admin/index.html?" + loginName;
        } catch (AuthenticationException e) {
            e.printStackTrace();
            return "redirect:/login.html";
        }
    }

    @RequestMapping("/user/loginout")
    public String loginout() {
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        return "redirect:/login.html";
    }


}
