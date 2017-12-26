package com.bawei.guolei.guolei20171221.model;


import okhttp3.Callback;

/**
 * Created by Lenovo on 2017/12/21.
 */

public interface Ilogin {
    public void getNetData(String phone, String pwd, Callback callback);

}
