package com.bawei.guolei.guolei20171221.bean;

/**
 * Created by Lenovo on 2017/12/21.
 */

public class EventBean {
    public String url;
    public String title;

    public EventBean(String url, String title) {
        this.url = url;
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public String getTitle() {
        return title;
    }
}
