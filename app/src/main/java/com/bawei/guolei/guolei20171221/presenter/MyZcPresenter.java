package com.bawei.guolei.guolei20171221.presenter;

import android.content.Context;

import com.bawei.guolei.guolei20171221.bean.ZcBean;
import com.bawei.guolei.guolei20171221.model.MyZcModel;
import com.bawei.guolei.guolei20171221.okHttp.OnUiCallback;
import com.bawei.guolei.guolei20171221.view.ShowZcview;
import com.google.gson.Gson;

import java.io.IOException;

import okhttp3.Call;

/**
 * Created by Lenovo on 2017/12/21.
 */

public class MyZcPresenter {
    Context context;
    MyZcModel model;
    ShowZcview view;

    public MyZcPresenter(Context context,ShowZcview view) {
        this.context = context;
        this.view=view;
        model=new MyZcModel();
    }
    public void clickzc(String phone,String pwd ){
        model.getnetZCdata(phone, pwd, new OnUiCallback() {
            @Override
            public void onFailed(Call call, IOException e) {

            }

            @Override
            public void onSuccess(String result) {
                Gson gson=new Gson();
                ZcBean bean = gson.fromJson(result, ZcBean.class);
                view.ShowZcView(bean);
            }
        });
    }

}
