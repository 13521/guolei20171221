package com.bawei.guolei.guolei20171221.model;

import com.bawei.guolei.guolei20171221.IpApplication;
import com.bawei.guolei.guolei20171221.bean.ShBean;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Lenovo on 2017/12/21.
 */

public class ShoModel {
    public void getData(final ShoCallBack callBack){
        Call<ShBean> call= IpApplication.iGetDataBase.get();

        call.enqueue(new Callback<ShBean>() {
            @Override
            public void onResponse(Call<ShBean> call, Response<ShBean> response) {
                ShBean shBean=response.body();
                callBack.success(shBean);


            }

            @Override
            public void onFailure(Call<ShBean> call, Throwable t) {

            }
        });

    }

}
