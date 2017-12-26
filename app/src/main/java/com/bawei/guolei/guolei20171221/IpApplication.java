package com.bawei.guolei.guolei20171221;

import android.app.Application;

import com.facebook.drawee.backends.pipeline.Fresco;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Lenovo on 2017/12/21.
 */

public class IpApplication extends Application {

    public static IGetDataBase iGetDataBase;

    @Override
    public void onCreate() {
        super.onCreate();
        //磁盘缓存
        Fresco.initialize(this);
        //网络请求
        Retrofit retrofit=new Retrofit.Builder().baseUrl("https://www.zhaoapi.cn")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        iGetDataBase = retrofit.create(IGetDataBase.class);


    }
}
