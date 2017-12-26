package com.bawei.guolei.guolei20171221.okHttp;

import android.os.Handler;

import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;

/**
 * Created by lenovo on 2017/10/12.
 */
public class OkHttpUtils {
    private Handler handler=new Handler();
    public Handler getHandler(){
        return handler;
    }
    //单例
    private static OkHttpUtils okHttpUtils=new OkHttpUtils();
    private OkHttpUtils(){};
    public static OkHttpUtils getInstance(){
        return okHttpUtils;
    }

    private OkHttpClient client;
    private void initOkHttpClient(){
        if (client==null){
            client=new OkHttpClient.Builder().build();
        }
    }
    //公用的get请求方法  完成的功能不确定
    public void doGet(String url, Callback callback){
        initOkHttpClient();
        Request request=new Request.Builder().url(url).build();
        client.newCall(request).enqueue(callback);
    }
}
