package com.bwie.zhouxinguang122.model;
/*
 *@auther:周鑫光
 *@Date: 2019/12/2
 *@Time:8:47
 *@Description:${DESCRIPTION}
 * */

import com.bwie.zhouxinguang122.Contract;
import com.bwie.zhouxinguang122.until.Until;

public class IMoldel implements Contract.Imodel {
    @Override
    public void onget(String url, final Contract.MycallBack mycallBack) {
        Until.getInstance().onget(url, new Until.MycallBack() {
            @Override
            public void onsuccess(String json) {
                mycallBack.onsuccess(json);
            }

            @Override
            public void onError(String error) {
                mycallBack.onError(error);
            }
        });
    }

    @Override
    public void onpost(String url, Contract.MycallBack mycallBack) {

    }
}
