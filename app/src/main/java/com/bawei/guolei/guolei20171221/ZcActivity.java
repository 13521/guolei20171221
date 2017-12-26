package com.bawei.guolei.guolei20171221;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.bawei.guolei.guolei20171221.bean.ZcBean;
import com.bawei.guolei.guolei20171221.presenter.MyZcPresenter;
import com.bawei.guolei.guolei20171221.view.ShowZcview;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ZcActivity extends AppCompatActivity implements ShowZcview{

    @BindView(R.id.zc_phone)
    EditText zcPhone;
    @BindView(R.id.zc_pwd)
    EditText zcPwd;
    @BindView(R.id.bt_zhuce)
    Button btZhuce;
    MyZcPresenter presenter=new MyZcPresenter(this,this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zc);
        ButterKnife.bind(this);

        btZhuce.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                     presenter.clickzc(zcPhone.getText().toString(),zcPwd.getText().toString());
            }
        });
    }

    @Override
    public void ShowZcView(ZcBean bean) {
        Toast.makeText(ZcActivity.this, bean.getMsg(), Toast.LENGTH_SHORT).show();

    }
}
