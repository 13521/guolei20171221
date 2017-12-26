package com.bawei.guolei.guolei20171221;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.bawei.guolei.guolei20171221.bean.LoginBean;
import com.bawei.guolei.guolei20171221.presenter.MyLoginPresenter;
import com.bawei.guolei.guolei20171221.view.ShowLoginView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements ShowLoginView{

    @BindView(R.id.et_phone)
    EditText etPhone;
    @BindView(R.id.et_pwd)
    EditText etPwd;
    @BindView(R.id.bt_log)
    Button btLog;
    @BindView(R.id.bt_zc)
    Button btZc;
    MyLoginPresenter presenter=new MyLoginPresenter(this,this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        //登录跳转

        if (etPhone.getText().toString()!=null&&etPwd.getText().toString()!=null){

            btLog.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent=new Intent(MainActivity.this,XqActivity.class);
                    startActivity(intent);

                    presenter.login(etPhone.getText().toString(),etPwd.getText().toString());

                }
            });


        }else{
            Toast.makeText(MainActivity.this,"请输入用户名或密码",Toast.LENGTH_SHORT).show();

        }

         //注册跳转
        btZc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,ZcActivity.class);
                startActivity(intent);
            }
        });

  }



    @Override
    public void showLogin(LoginBean bean) {

        Toast.makeText(MainActivity.this,bean.getMsg(),Toast.LENGTH_SHORT).show();

    }



}
