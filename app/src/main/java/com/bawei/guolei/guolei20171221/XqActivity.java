package com.bawei.guolei.guolei20171221;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import org.greenrobot.eventbus.EventBus;

import butterknife.BindView;
import butterknife.ButterKnife;

public class XqActivity extends AppCompatActivity {


    @BindView(R.id.text_title)
    TextView textTitle;
    @BindView(R.id.text_price)
    TextView textPrice;
    @BindView(R.id.radio_01)
    RadioButton radio01;
    @BindView(R.id.radio_02)
    RadioButton radio02;
    @BindView(R.id.radio_group)
    RadioGroup radioGroup;
    @BindView(R.id.simple)
    ImageView simple;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xq);
        ButterKnife.bind(this);
        EventBus.getDefault().register(this);


            radio01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(XqActivity.this, ShopCActivity.class);
                startActivity(intent);
                Toast.makeText(XqActivity.this, "加入成功", Toast.LENGTH_SHORT).show();
            }
        });


    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }
}
