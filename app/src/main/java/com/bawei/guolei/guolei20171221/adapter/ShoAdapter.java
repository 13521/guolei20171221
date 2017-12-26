package com.bawei.guolei.guolei20171221.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bawei.guolei.guolei20171221.R;
import com.bawei.guolei.guolei20171221.XqActivity;
import com.bawei.guolei.guolei20171221.bean.EventBean;
import com.bawei.guolei.guolei20171221.bean.ShBean;
import com.facebook.drawee.view.SimpleDraweeView;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Lenovo on 2017/12/21.
 */

public class ShoAdapter extends RecyclerView.Adapter<ShoAdapter.ViewHolder> {




    Context context;
    private List<ShBean.DataBean> list;


    public ShoAdapter(Context context) {
        this.context = context;

    }
    public void addData(ShBean shBean) {
        if (list==null){
            list = new ArrayList<>();
        }
        list.addAll(shBean.getData());
        notifyDataSetChanged();
    }

    @Override
    public ShoAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = View.inflate(context, R.layout.item_layout, null);


        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ShoAdapter.ViewHolder holder, final int position) {

         holder.simple.setImageURI(list.get(position).getImages());
        holder.textView.setText(list.get(position).getTitle());

        holder.textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                EventBus.getDefault().postSticky(new EventBean(list.get(position).getImages(),list.get(position).getTitle()));
                context.startActivity(new Intent(context, XqActivity.class));


            }
        });

    }

    @Override
    public int getItemCount() {
        return list==null?0:list.size();
    }



    static class ViewHolder extends RecyclerView.ViewHolder{
        @BindView(R.id.simple)
        SimpleDraweeView simple;
        @BindView(R.id.text_view)
        TextView textView;
        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
}
