package com.bawei.guolei.guolei20171221.presenter;

import com.bawei.guolei.guolei20171221.bean.ShBean;
import com.bawei.guolei.guolei20171221.model.ShoCallBack;
import com.bawei.guolei.guolei20171221.model.ShoModel;
import com.bawei.guolei.guolei20171221.view.ShoView;

/**
 * Created by Lenovo on 2017/12/21.
 */

public class ShoPresenter {
    private ShoView shoView;
    private ShoModel shoModel;
    public ShoPresenter(ShoView shoView){
        this.shoView=shoView;
        this.shoModel=new ShoModel();

    }
    public void get(){
        shoModel.getData(new ShoCallBack() {
            @Override
            public void success(ShBean shBean) {
                if (shoView!=null){
                    shoView.success(shBean);
                }
            }
        });
    }

}
