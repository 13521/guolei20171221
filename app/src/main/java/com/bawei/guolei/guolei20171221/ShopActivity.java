package com.bawei.guolei.guolei20171221;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.bawei.guolei.guolei20171221.adapter.ShoAdapter;
import com.bawei.guolei.guolei20171221.bean.ShBean;
import com.bawei.guolei.guolei20171221.presenter.ShoPresenter;
import com.bawei.guolei.guolei20171221.view.ShoView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ShopActivity extends AppCompatActivity implements ShoView{

    @BindView(R.id.recycle_view)
    RecyclerView recycleView;
    private ShoPresenter presenter;
    private ShoAdapter adapter;
    private LinearLayoutManager manager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop);
        ButterKnife.bind(this);

        presenter = new ShoPresenter(this);
        presenter.get();

        adapter = new ShoAdapter(this);
        manager = new LinearLayoutManager(this);

        recycleView.setLayoutManager(manager);
        recycleView.setAdapter(adapter);




    }

    @Override
    public void success(ShBean shBean) {
        adapter.addData(shBean);

    }
}
