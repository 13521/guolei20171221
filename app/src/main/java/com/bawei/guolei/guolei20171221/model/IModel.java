package com.bawei.guolei.guolei20171221.model;

import com.bawei.guolei.guolei20171221.bean.ShopBean;
import com.bawei.guolei.guolei20171221.okHttp2.AbstractUiCallBack;
import com.bawei.guolei.guolei20171221.okHttp2.OkhttpUtils;

/**
 * Created by Lenovo on 2017/12/21.
 */

public class IModel {
    public void getData(final MyModelCallBack callBack){
        OkhttpUtils.getInstance().asy(null, "http://120.27.23.105/product/getCarts?uid=98", new AbstractUiCallBack<ShopBean>() {
            @Override
            public void success(ShopBean shopBean) {
                callBack.success(shopBean);

            }

            @Override
            public void failure(Exception e) {
                callBack.failure(e);
            }
        });



    }


}
