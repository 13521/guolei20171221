package com.bawei.guolei.guolei20171221;

import com.bawei.guolei.guolei20171221.bean.ShBean;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Lenovo on 2017/12/21.
 */

public interface IGetDataBase {

    @GET("product/searchProducts")
    Call<ShBean> get();
}
