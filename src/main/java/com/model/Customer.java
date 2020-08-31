package com.model;

public class Customer {
    private Integer cusid;

    private String cusname;

    private String address;

    private String contact;

    private String tel;

    private String email;

    private Integer empid;

    private String username;

    private String shareusername;

    private int shareempid;

    public String getUsername() {
        return username;
    }

    public String getShareusername() {
        return shareusername;
    }

    public void setShareusername(String shareusername) {
        this.shareusername = shareusername;
    }

    public int getShareempid() {
        return shareempid;
    }

    public void setShareempid(int shareempid) {
        this.shareempid = shareempid;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getCusid() {
        return cusid;
    }

    public void setCusid(Integer cusid) {
        this.cusid = cusid;
    }

    public String getCusname() {
        return cusname;
    }

    public void setCusname(String cusname) {
        this.cusname = cusname == null ? null : cusname.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact == null ? null : contact.trim();
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel == null ? null : tel.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public Integer getEmpid() {
        return empid;
    }

    public void setEmpid(Integer empid) {
        this.empid = empid;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "cusid=" + cusid +
                ", cusname='" + cusname + '\'' +
                ", address='" + address + '\'' +
                ", contact='" + contact + '\'' +
                ", tel='" + tel + '\'' +
                ", email='" + email + '\'' +
                ", empid=" + empid +
                '}';
    }
}