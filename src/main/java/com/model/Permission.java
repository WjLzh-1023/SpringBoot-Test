package com.model;

public class Permission {
    private Integer id;

    private String url;

    private String pname;

    private Integer ismenu;

    private Integer parentid;

    private String pinfo;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname == null ? null : pname.trim();
    }

    public Integer getIsmenu() {
        return ismenu;
    }

    public void setIsmenu(Integer ismenu) {
        this.ismenu = ismenu;
    }

    public Integer getParentid() {
        return parentid;
    }

    public void setParentid(Integer parentid) {
        this.parentid = parentid;
    }

    public String getPinfo() {
        return pinfo;
    }

    public void setPinfo(String pinfo) {
        this.pinfo = pinfo == null ? null : pinfo.trim();
    }

    @Override
    public String toString() {
        return "Permission{" +
                "id=" + id +
                ", url='" + url + '\'' +
                ", pname='" + pname + '\'' +
                ", ismenu=" + ismenu +
                ", parentid=" + parentid +
                ", pinfo='" + pinfo + '\'' +
                '}';
    }
}