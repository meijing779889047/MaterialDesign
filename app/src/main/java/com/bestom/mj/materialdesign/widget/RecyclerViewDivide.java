package com.bestom.mj.materialdesign.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * 为每个item绘制分割线
 * Created by mj on 2016/6/23.
 */
public class RecyclerViewDivide  extends RecyclerView.ItemDecoration {

    //默认分隔条drawbale资源id
    private static final int[]  ATTRS=new int[]{android.R.attr.listDivider};
    private Drawable  drawable;


    public RecyclerViewDivide(Context context) {
        TypedArray a=context.obtainStyledAttributes(ATTRS);
        drawable=a.getDrawable(0);
        a.recycle();
    }

    /**
     * 绘制每一个item的分隔条
     * @param c
     * @param parent
     * @param state
     */
    @Override
    public void onDrawOver(Canvas c, RecyclerView parent, RecyclerView.State state) {

        //获取列表项距离左边的距离
        int left=parent.getPaddingLeft();
        //获取列表项距离有边缘的距离
        int right=parent.getWidth()-parent.getPaddingRight();
        //获取列表项的数量
        int totalCount=parent.getChildCount();
        //获取每个列表项
        for (int i = 0; i <totalCount ; i++) {

            View view=  parent.getChildAt(i);
            //获取列表项的属性
            RecyclerView.LayoutParams lp= (RecyclerView.LayoutParams) view.getLayoutParams();

            //获取分隔条的顶部坐标
            int top=view.getBottom()+lp.bottomMargin;

            //获取分隔条的底部坐标
            int bottom=top+drawable.getIntrinsicHeight();//top+分隔条的高度

            //设置分割条的绘制范围
            drawable.setBounds(left,top,right,bottom);
            //绘制
            drawable.draw(c);

        }


    }
}
