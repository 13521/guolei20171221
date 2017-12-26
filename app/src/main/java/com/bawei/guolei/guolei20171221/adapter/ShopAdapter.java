package com.bawei.guolei.guolei20171221.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bawei.guolei.guolei20171221.PlusView;
import com.bawei.guolei.guolei20171221.R;
import com.bawei.guolei.guolei20171221.bean.ShopBean;
import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Lenovo on 2017/12/21.
 */

public class ShopAdapter extends RecyclerView.Adapter<ShopAdapter.IViewHolder> {

    Context context;
    private List<ShopBean.DataBean.ListBean> list;
    private Map<String, String> map = new HashMap<>();

    public ShopAdapter(Context context) {
        this.context = context;
    }

    public void add(ShopBean shopBean) {
        if (this.list == null) {
            this.list = new ArrayList<>();
        }
        for (ShopBean.DataBean shop : shopBean.getData()) {
            map.put(shop.getSellerid(), shop.getSellerName());
            for (int i = 0; i < shop.getList().size(); i++) {
                this.list.add(shop.getList().get(i));
            }
        }
        setFirst(this.list);
        notifyDataSetChanged();
    }

    private void setFirst(List<ShopBean.DataBean.ListBean> list) {
        if (list.size() > 0) {
            list.get(0).setIsFirst(1);
            for (int i = 1; i < list.size(); i++) {
                if (list.get(i).getSellerid() == list.get(i - 1).getSellerid()) {
                    list.get(i).setIsFirst(2);
                } else {
                    list.get(i).setIsFirst(1);
                }


            }
        }

    }

    @Override
    public ShopAdapter.IViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = View.inflate(context, R.layout.adapter_layout, null);
        return new IViewHolder(view);

    }

    @Override
    public void onBindViewHolder(final ShopAdapter.IViewHolder holder, final int position) {

        if (list.get(position).getIsFirst() == 1) {
            holder.shopCheckbox.setVisibility(View.VISIBLE);
            holder.tvItemShopcartShopname.setVisibility(View.VISIBLE);
            holder.shopCheckbox.setChecked(list.get(position).isShopSelected());

            holder.tvItemShopcartShopname.setText(map.get(String.valueOf(list.get(position).getSellerid())));
        } else {
            holder.shopCheckbox.setVisibility(View.GONE);
            holder.tvItemShopcartShopname.setVisibility(View.GONE);
        }
        holder.itemCheckbox.setChecked(list.get(position).isItemSelected());

        String[] url = list.get(position).getImages().split("\\|");
        ImageLoader.getInstance().displayImage(url[0], holder.itemPic);


        holder.itemName.setText(list.get(position).getTitle());
        holder.itemPrice.setText(list.get(position).getPrice() + "");

        holder.plusViewId.setEditText(list.get(position).getNum());
        holder.shopCheckbox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                list.get(position).setShopSelected(holder.shopCheckbox.isChecked());
                for (int i = 0; i < list.size(); i++) {
                    if (list.get(position).getSellerid() == list.get(i).getSellerid()) {
                        list.get(i).setItemSelected(holder.shopCheckbox.isChecked());
                    }
                }
                notifyDataSetChanged();
                sum(list);


            }
        });
        //条目点击
        holder.itemCheckbox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                list.get(position).setItemSelected(holder.itemCheckbox.isChecked());
                for (int i = 0; i < list.size(); i++) {
                    for (int j = 0; j < list.size(); j++) {
                        if (list.get(i).getSellerid() == list.get(j).getSellerid() && !list.get(j).isItemSelected()) {
                            list.get(i).setShopSelected(false);
                            break;
                        } else {
                            list.get(i).setShopSelected(true);
                        }
                    }

                }
                notifyDataSetChanged();
                sum(list);
            }
        });
        //删除
        holder.itemDel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                list.remove(position);
                setFirst(list);
                notifyDataSetChanged();
                sum(list);

            }
        });

        holder.plusViewId.setListener(new PlusView.ClickListener() {
            @Override
            public void click(int count) {
                list.get(position).setNum(count);
                notifyDataSetChanged();
                sum(list);
            }
        });

    }

    @Override
    public int getItemCount() {
        return list == null ? 0 : list.size();
    }


    //计算总价
    private void sum(List<ShopBean.DataBean.ListBean> list) {
        int totalNum=0;
        float totalMoney=0.0f;

        boolean allCheck=true;
        for (int i=0;i<list.size();i++){
            if (list.get(i).isItemSelected()){
                totalNum+=list.get(i).getNum();
                totalMoney+=list.get(i).getNum() * list.get(i).getPrice();

            }else{
                allCheck=false;
            }
        }
        listener.setTotal(totalMoney+"",totalNum+"",allCheck);

    }
    //查询
    public void selectAll(boolean check){
        for (int i=0;i<list.size();i++){
            list.get(i).setShopSelected(check);
            list.get(i).setItemSelected(check);
        }
        notifyDataSetChanged();
        sum(list);

    }

    static class IViewHolder extends RecyclerView.ViewHolder{
        @BindView(R.id.view)
        View view;
        @BindView(R.id.shop_checkbox)
        CheckBox shopCheckbox;
        @BindView(R.id.tv_item_shopcart_shopname)
        TextView tvItemShopcartShopname;
        @BindView(R.id.ll_shopcart_header)
        LinearLayout llShopcartHeader;
        @BindView(R.id.item_checkbox)
        CheckBox itemCheckbox;
        @BindView(R.id.item_pic)
        ImageView itemPic;
        @BindView(R.id.item_price)
        TextView itemPrice;
        @BindView(R.id.item_name)
        TextView itemName;
        @BindView(R.id.tv_item_shopcart_cloth_size)
        TextView tvItemShopcartClothSize;
        @BindView(R.id.plus_view_id)
        PlusView plusViewId;
        @BindView(R.id.item_del)
        ImageView itemDel;
        public IViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
    public UpdateUiListener listener;
    public void setListener(UpdateUiListener listener){
        this.listener=listener;

    }
    public interface UpdateUiListener{
        public void setTotal(String total,String num,boolean allCheck);


    }
}
