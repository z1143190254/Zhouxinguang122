package com.bwie.zhouxinguang122.until;
/*
 *@auther:周鑫光
 *@Date: 2019/12/2
 *@Time:8:43
 *@Description:${DESCRIPTION}
 * */

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.bwie.zhouxinguang122.app.Appcotion;

public class Until {
    private static final Until ourInstance = new Until();
    private final RequestQueue requestQueue;

    public static Until getInstance() {
        return ourInstance;
    }

    private Until() {
        requestQueue = Volley.newRequestQueue(Appcotion.context);
    }

    public void onget(String url, final MycallBack mycallBack) {
        StringRequest stringRequest = new StringRequest(url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                mycallBack.onsuccess(response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                mycallBack.onError(error.getMessage());
            }
        });
        requestQueue.add(stringRequest);
    }

    public void onpost(String url, final MycallBack mycallBack) {
        StringRequest stringRequest = new StringRequest(url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                mycallBack.onsuccess(response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                mycallBack.onError(error.getMessage());
            }
        });
        requestQueue.add(stringRequest);
    }

    public interface MycallBack {
        void onsuccess(String json);

        void onError(String error);
    }

}
