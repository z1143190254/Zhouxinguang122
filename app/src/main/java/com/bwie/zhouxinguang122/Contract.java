package com.bwie.zhouxinguang122;
/*
 *@auther:周鑫光
 *@Date: 2019/12/2
 *@Time:8:45
 *@Description:${DESCRIPTION}
 * */

public interface Contract {
    interface MycallBack {
        void onsuccess(String json);

        void onError(String error);
    }

    interface Imodel {
        void onget(String url, MycallBack mycallBack);

        void onpost(String url, MycallBack mycallBack);
    }

    interface Iview {
        void onsuccess(String json);

        void onError(String error);
    }

    interface Presenter {
        void onstart(String url);
    }

}
