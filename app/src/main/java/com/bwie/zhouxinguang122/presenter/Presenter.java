package com.bwie.zhouxinguang122.presenter;
/*
 *@auther:周鑫光
 *@Date: 2019/12/2
 *@Time:8:48
 *@Description:${DESCRIPTION}
 * */

import com.bwie.zhouxinguang122.Contract;
import com.bwie.zhouxinguang122.base.BasePresenter;
import com.bwie.zhouxinguang122.model.IMoldel;

public class Presenter extends BasePresenter {

    private Contract.Imodel iMoldel;

    @Override
    protected void inisModel() {
        iMoldel = new IMoldel();
    }

    @Override
    public void onstart(String url) {
        iMoldel.onget(url, new Contract.MycallBack() {
            @Override
            public void onsuccess(String json) {
                get().onsuccess(json);
            }

            @Override
            public void onError(String error) {
                get().onError(error);
            }
        });
    }
}
