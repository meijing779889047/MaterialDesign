package com.bestom.mj.materialdesign.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.bestom.mj.materialdesign.R;

/**
 * Created by mj on 2016/6/23.
 */
public class RecyclerHolder extends RecyclerView.ViewHolder{

    private TextView  mTextView;
    public RecyclerHolder(View itemView) {
        super(itemView);
        mTextView= (TextView) itemView.findViewById(R.id.text);
    }

    public void bindItem(String data){
        mTextView.setText(data);
    }
}
