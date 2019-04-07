package com.muhammetgumus.camshop;


import java.io.Serializable;

public class ImageResponse implements Serializable {

    private String url;
    private String token;
    private String status;
    private String name;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }
}
