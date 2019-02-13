package com.yanwuyu.model;

public class Category {
    private Integer catid;

    private String catno;

    private String name;

    private String descn;

    public Integer getCatid() {
        return catid;
    }

    public void setCatid(Integer catid) {
        this.catid = catid;
    }

    public String getCatno() {
        return catno;
    }

    public void setCatno(String catno) {
        this.catno = catno == null ? null : catno.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getDescn() {
        return descn;
    }

    public void setDescn(String descn) {
        this.descn = descn == null ? null : descn.trim();
    }
}