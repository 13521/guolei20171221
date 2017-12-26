package com.bawei.guolei.guolei20171221.model;

import com.bawei.guolei.guolei20171221.okHttp.OkHttp3Utils;

import java.util.HashMap;
import java.util.Map;

import okhttp3.Callback;

/**
 * Created by Lenovo on 2017/12/21.
 */

public class MyZcModel implements IZcModel{

    @Override
    public void getnetZCdata(String phone, String pwd, Callback callback) {
        Map<String,String> map=new HashMap<>();
        map.put("mobile",phone);
        map.put("password",pwd);
        OkHttp3Utils.doPost("http://120.27.23.105/user/reg",map,callback);
    }
}
