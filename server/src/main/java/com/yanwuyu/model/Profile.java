package com.yanwuyu.model;

public class Profile extends ProfileKey {
    private String lang;

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang == null ? null : lang.trim();
    }
}