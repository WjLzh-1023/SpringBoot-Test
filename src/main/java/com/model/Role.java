package com.model;

import java.util.HashSet;
import java.util.Set;

public class Role {
    private Integer roleid;

    private String rolename;

    private String rolelnfo;

    private int permid;

    private String pname;

    private String pinfo;

    public int getPermid() {
        return permid;
    }

    public void setPermid(int permid) {
        this.permid = permid;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public String getPinfo() {
        return pinfo;
    }

    public void setPinfo(String pinfo) {
        this.pinfo = pinfo;
    }

    private Set<Employees> employees = new HashSet<Employees>();

    public Role() {
    }

    public Role(Integer roleid, String rolename, String rolelnfo) {
        this.roleid = roleid;
        this.rolename = rolename;
        this.rolelnfo = rolelnfo;
    }


    public Integer getRoleid() {
        return roleid;
    }

    public void setRoleid(Integer roleid) {
        this.roleid = roleid;
    }

    public String getRolename() {
        return rolename;
    }

    public void setRolename(String rolename) {
        this.rolename = rolename;
    }

    public String getRolelnfo() {
        return rolelnfo;
    }

    public void setRolelnfo(String rolelnfo) {
        this.rolelnfo = rolelnfo;
    }

    public Set<Employees> getEmployees() {
        return employees;
    }

    public void setEmployees(Set<Employees> employees) {
        this.employees = employees;
    }

    @Override
    public String toString() {
        return "Role{" +
                "roleid=" + roleid +
                ", rolename='" + rolename + '\'' +
                ", rolelnfo='" + rolelnfo + '\'' +
                '}';
    }
}
