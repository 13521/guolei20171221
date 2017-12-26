package com.bawei.guolei.guolei20171221.presenter;

import android.content.Context;

import com.bawei.guolei.guolei20171221.bean.LoginBean;
import com.bawei.guolei.guolei20171221.model.MyloginModel;
import com.bawei.guolei.guolei20171221.okHttp.OnUiCallback;
import com.bawei.guolei.guolei20171221.view.ShowLoginView;
import com.google.gson.Gson;

import java.io.IOException;

import okhttp3.Call;

/**
 * Created by Lenovo on 2017/12/21.
 */

public class MyLoginPresenter {
    ShowLoginView view;
    Context context;
    MyloginModel model;

    public MyLoginPresenter(ShowLoginView view, Context context) {
        this.view = view;
        this.context = context;
        model=new MyloginModel();
    }

    public void login(String phone,String pwd){
        model.getNetData(phone, pwd, new OnUiCallback() {
            @Override
            public void onFailed(Call call, IOException e) {

            }

            @Override
            public void onSuccess(String result) {
                Gson gson=new Gson();
                LoginBean bean = gson.fromJson(result, LoginBean.class);
                view.showLogin(bean);
            }
        });
    }
}
