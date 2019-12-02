package com.bwie.zhouxinguang122.adapter;
/*
 *@auther:周鑫光
 *@Date: 2019/12/2
 *@Time:9:00
 *@Description:${DESCRIPTION}
 * */

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bwie.zhouxinguang122.MainActivity;
import com.bwie.zhouxinguang122.R;
import com.bwie.zhouxinguang122.StudentBean;

import java.util.List;

public class MyBase extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private final Context context;
    private final List<StudentBean.ResultBean> list;
    private final int pager1 = 1;
    private final int pager2 = 2;

    public MyBase(Context context, List<StudentBean.ResultBean> list) {

        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        RecyclerView.ViewHolder holder = null;
        View view = null;

        switch (i) {
            case pager1:
                view = View.inflate(context, R.layout.item, null);
                holder = new OneHolder(view);
                break;
            case pager2:
                view = View.inflate(context, R.layout.item, null);
                holder = new TwoHolder(view);

                break;
        }
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        if (viewHolder instanceof OneHolder) {
            ((OneHolder) viewHolder).textView.setText(list.get(i).getTitle());
            ((OneHolder) viewHolder).textView.setText(list.get(i).getJumpUrl());
            Glide.with(context).load(list.get(i).getImageUrl()).into(((OneHolder) viewHolder).imageView);
        } else if (viewHolder instanceof TwoHolder) {
            ((TwoHolder) viewHolder).textView.setText(list.get(i).getTitle());
            ((TwoHolder) viewHolder).textView.setText(list.get(i).getJumpUrl());
            Glide.with(context).load(list.get(i).getImageUrl()).into(((TwoHolder) viewHolder).imageView);
        }

    }

    class OneHolder extends RecyclerView.ViewHolder {

        private final ImageView imageView;
        private final TextView textView;
        private final TextView textView1;

        public OneHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.image1);
            textView = itemView.findViewById(R.id.text1);
            textView1 = itemView.findViewById(R.id.text2);
        }
    }

    class TwoHolder extends RecyclerView.ViewHolder {

        private final ImageView imageView;
        private final TextView textView;
        private final TextView textView1;

        public TwoHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.image1);
            textView = itemView.findViewById(R.id.text1);
            textView1 = itemView.findViewById(R.id.text2);
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    @Override
    public int getItemViewType(int position) {
        if (position % 2 == 0) {
            return pager1;
        } else {
            return pager2;
        }
    }
}
