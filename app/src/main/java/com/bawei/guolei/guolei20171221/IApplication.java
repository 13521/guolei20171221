package com.bawei.guolei.guolei20171221;

import android.app.Application;

import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

/**
 * Created by Lenovo on 2017/12/21.
 */

public class IApplication extends Application{
    @Override
    public void onCreate() {
        super.onCreate();
      //图片加载
        ImageLoaderConfiguration configuration = new ImageLoaderConfiguration.Builder(this).build();
        ImageLoader.getInstance().init(configuration);


    }
}
