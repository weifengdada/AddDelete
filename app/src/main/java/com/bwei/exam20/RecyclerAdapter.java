package com.bwei.exam20;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by acer on 2017/12/20.
 */

public class RecyclerAdapter extends RecyclerView.Adapter <RecyclerAdapter.MyViewHolder>{
    List<CartBean.DataBean.ListBean> list;
    private Map<String, String> map = new HashMap<>();
    Context context;

    public RecyclerAdapter(Context context) {
        this.context = context;

    }

    public void addData(CartBean bean) {
        if (list == null) {
            list = new ArrayList<>();

        }
        //第一层遍历商家和商品
        for (CartBean.DataBean shop : bean.getData()) {
            //把商品的id和商品的名称添加到map集合里 ,,为了之后方便调用
            map.put(shop.getSellerid(), shop.getSellerName());
            //第二层遍历里面的商品
            for (int i = 0; i < shop.getList().size(); i++) {
                //添加到list集合里
                list.add(shop.getList().get(i));
            }
        }
        notifyDataSetChanged();

    }

    @Override
    public RecyclerAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = View.inflate(context, R.layout.good_layout, null);
        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerAdapter.MyViewHolder holder, final int position) {
        final String[] split = list.get(position).getImages().split("\\|");
        holder.goodImage.setImageURI(split[0]);
        holder.goodImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(context,DetailsActivity.class);
                intent.putExtra("image",split[0]);
                intent.putExtra("pid",list.get(position).getPid()+"");
                intent.putExtra("goodPrice",list.get(position).getPrice()+"");
                intent.putExtra("shopName",map.get(String.valueOf(list.get(position).getSellerid())));
                intent.putExtra("name",list.get(position).getTitle());
                context.startActivity(intent);

            }
        });
        holder.goodName.setText(list.get(position).getTitle());
    }

    @Override
    public int getItemCount() {
        return list==null?0:list.size();
    }


    static class MyViewHolder extends RecyclerView.ViewHolder{
        @BindView(R.id.good_image)
        SimpleDraweeView goodImage;
        @BindView(R.id.good_name)
        TextView goodName;

        MyViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }
}
