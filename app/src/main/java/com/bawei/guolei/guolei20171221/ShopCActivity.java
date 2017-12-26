package com.bawei.guolei.guolei20171221;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bawei.guolei.guolei20171221.adapter.ShopAdapter;
import com.bawei.guolei.guolei20171221.bean.ShopBean;
import com.bawei.guolei.guolei20171221.presenter.MyPresenter;
import com.bawei.guolei.guolei20171221.view.MyViewLister;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ShopCActivity extends AppCompatActivity implements MyViewLister{

    @BindView(R.id.third_recyclerView)
    RecyclerView thirdRecyclerView;
    @BindView(R.id.third_allselect)
    CheckBox thirdAllselect;
    @BindView(R.id.third_totalprice)
    TextView thirdTotalprice;
    @BindView(R.id.third_totalnum)
    TextView thirdTotalnum;
    @BindView(R.id.third_submit)
    TextView thirdSubmit;
    @BindView(R.id.third_pay_linear)
    LinearLayout thirdPayLinear;
    private MyPresenter presenter;
    private ShopAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop_c);
        ButterKnife.bind(this);
        presenter = new MyPresenter(this);
        presenter.getData();
        adapter = new ShopAdapter(this);

        LinearLayoutManager manager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);

        thirdRecyclerView.setLayoutManager(manager);
        thirdRecyclerView.setAdapter(adapter);

        adapter.setListener(new ShopAdapter.UpdateUiListener() {
            @Override
            public void setTotal(String total, String num, boolean allCheck) {
                thirdAllselect.setChecked(allCheck);
                thirdTotalnum.setText(num);
                thirdTotalprice.setText(total);
            }
        });

    }

    @Override
    public void success(ShopBean shopBean) {
        adapter.add(shopBean);
    }

    @Override
    public void failure(Exception e) {
        Toast.makeText(this, "error", Toast.LENGTH_SHORT).show();
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.detach();
    }

    @OnClick(R.id.third_allselect)
    public void onViewClicked() {
        adapter.selectAll(thirdAllselect.isChecked());
    }
}
