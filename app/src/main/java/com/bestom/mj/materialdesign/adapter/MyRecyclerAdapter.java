package com.bestom.mj.materialdesign.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bestom.mj.materialdesign.R;
import com.bestom.mj.materialdesign.bean.DataModel;

import java.util.List;

/**
 * recyclerView  适配器
 * Created by mj on 2016/6/23.
 */
public class MyRecyclerAdapter extends RecyclerView.Adapter<RecyclerHolder> {

    private Context context;
    private List<DataModel> list;

    public MyRecyclerAdapter(Context context, List<DataModel> list) {
        this.context=context;
        this.list=list;
    }

    /**
     * 创建Viewholder 与视图进行绑定
     * @param parent
     * @param viewType
     * @return
     */
    @Override
    public RecyclerHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.item_recyclerview,parent,false);
        return new RecyclerHolder(view);
    }

    /**
     * 填充数据
     * @param holder
     * @param position
     */
    @Override
    public void onBindViewHolder(final RecyclerHolder holder, final int position) {
        holder.bindItem(list.get(position).getData());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mOnClickItemListener!=null){
                    mOnClickItemListener.onItemClickListener(holder.itemView,position);
                }
            }
        });
        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                if(mOnClickItemListener!=null){
                    mOnClickItemListener.onItemLongClickListener(holder.itemView,position);
                }
                return true;
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    /**
     * 添加是数据
     * @param pos
     */
    public void addData(int pos){
        DataModel data= new DataModel();
        data.setData("insert Data");
        list.add(pos,data);
        notifyItemInserted(pos);
    }

    /**
     * 删除数据
     * @param pos
     */
    public void deleteData(int pos){
        notifyItemRemoved(pos);
    }

    /**
     * 接口回调
     */
    private OnClickItemListener mOnClickItemListener;
    public  interface  OnClickItemListener{
        void onItemClickListener(View view,int position);
        void onItemLongClickListener(View view,int position);
    }

    public void  setOnClickItemListener(OnClickItemListener mOnClickItemListener){
        this.mOnClickItemListener=mOnClickItemListener;
    }
}
