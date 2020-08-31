package com.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.apache.ibatis.type.Alias;

import java.io.Serializable;

@Alias("ep")
public class Employees implements Serializable {

    private int empid;
    private String username;
    private String password;
    private String tel;
    private String name;
    private String email;
    private int roleid;
    private String rolelnfo;

    @JsonIgnore
    private Role role;

    public String getRolelnfo() {
        return rolelnfo;
    }

    public void setRolelnfo(String rolelnfo) {
        this.rolelnfo = rolelnfo;
    }

    public Employees() {
    }

    public Employees(int empid, String username, String password, String tel, String name, String email, int roleid) {
        this.empid = empid;
        this.username = username;
        this.password = password;
        this.tel = tel;
        this.name = name;
        this.email = email;
        this.roleid = roleid;
    }

    public int getEmpid() {
        return empid;
    }

    public void setEmpid(int empid) {
        this.empid = empid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getRoleid() {
        return roleid;
    }

    public void setRoleid(int roleid) {
        this.roleid = roleid;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "Employees{" +
                "empid=" + empid +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", tel='" + tel + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", roleid=" + roleid +
                ", rolelnfo='" + rolelnfo + '\'' +
                '}';
    }
}
