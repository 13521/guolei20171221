package com.bawei.guolei.guolei20171221.presenter;

import com.bawei.guolei.guolei20171221.bean.ShopBean;
import com.bawei.guolei.guolei20171221.model.IModel;
import com.bawei.guolei.guolei20171221.model.MyModelCallBack;
import com.bawei.guolei.guolei20171221.view.MyViewLister;

/**
 * Created by Lenovo on 2017/12/21.
 */

public class MyPresenter {

    MyViewLister myViewLister;
    IModel iModel;
    public MyPresenter(MyViewLister myViewLister) {
        this.myViewLister=myViewLister;
        this.iModel=new IModel();



    }

    public void getData() {
        iModel.getData(new MyModelCallBack() {
            @Override
            public void success(ShopBean shopBean) {
                if (myViewLister!=null){
                    myViewLister.success(shopBean);
                }
            }

            @Override
            public void failure(Exception e) {
                if (myViewLister!=null){
                    myViewLister.failure(e);
                }

            }
        });


    }
    /**
     * 防止内存泄漏
     */
    public void detach(){
        myViewLister=null;
    }
}
