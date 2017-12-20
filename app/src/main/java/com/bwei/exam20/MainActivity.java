package com.bwei.exam20;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.bwei.exam20.callBack.MainView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements MainView{

    @BindView(R.id.goods_recyclerview)
    RecyclerView goodsRecyclerview;
    private RecyclerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        LinearLayoutManager manager=new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        adapter = new RecyclerAdapter(this);
        MainPresenter presenter=new MainPresenter(this);
        presenter.get();
        goodsRecyclerview.setLayoutManager(manager);
        goodsRecyclerview.setAdapter(adapter);
    }

    @Override
    public void success(CartBean bean) {
        adapter.addData(bean);


    }
}
