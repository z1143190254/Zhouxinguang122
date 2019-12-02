package com.bwie.zhouxinguang122;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.bwie.zhouxinguang122.adapter.MyBase;
import com.bwie.zhouxinguang122.base.BaseActivity;
import com.bwie.zhouxinguang122.base.BasePresenter;
import com.bwie.zhouxinguang122.presenter.Presenter;
import com.google.gson.Gson;

import java.util.List;

public class MainActivity extends BaseActivity {

    private RecyclerView recy;
    String url = "http://172.17.8.100/small/commodity/v1/bannerShow";

    @Override
    protected void startCoding() {
        menter.onstart(url);
    }

    @Override
    protected void inisView() {
        recy = (RecyclerView) findViewById(R.id.recy);
        recy.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    protected BasePresenter inisPresenter() {
        return new Presenter();
    }

    @Override
    protected int inisid() {
        return R.layout.activity_main;
    }


    @Override
    public void onsuccess(String json) {
        StudentBean studentBean = new Gson().fromJson(json, StudentBean.class);
        List<StudentBean.ResultBean> result = studentBean.getResult();
        MyBase myBase = new MyBase(this, result);
        recy.setAdapter(myBase);
    }

    @Override
    public void onError(String error) {

    }
}
