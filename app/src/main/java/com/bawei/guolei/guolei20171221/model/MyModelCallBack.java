package com.bawei.guolei.guolei20171221.model;

import com.bawei.guolei.guolei20171221.bean.ShopBean;

/**
 * Created by Lenovo on 2017/12/21.
 */

public interface MyModelCallBack {
    public void success(ShopBean shopBean);
    public void failure(Exception e);
}
