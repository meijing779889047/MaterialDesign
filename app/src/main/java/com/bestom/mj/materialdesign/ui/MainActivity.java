package com.bestom.mj.materialdesign.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.bestom.mj.materialdesign.R;
import com.bestom.mj.materialdesign.adapter.MyRecyclerAdapter;
import com.bestom.mj.materialdesign.bean.DataModel;
import com.bestom.mj.materialdesign.widget.RecyclerViewDivide;

import java.util.ArrayList;
import java.util.List;

/**
 * material Desigcn  材料设计  针对ui
 * 特性：  向下兼容
 *        生成阴影
 *        定制动画
 *        主题             1.在res新建values-v21文件夹(乡下兼容)
 *                         2.在文件夹下的style。xml设置主题
 *                             <!-- Base application theme. -->
                       <style name="AppTheme" parent="@android:style/Theme.Material">
                       <!-- Customize your theme here. -->
                       <item name="colorPrimary">@color/colorPrimary</item>
                       <item name="colorPrimaryDark">@color/colorPrimaryDark</item>
                       <item name="colorAccent">@color/colorAccent</item>
                        </style>

 *        List和card    1.RecuyclerView   可实现Listviiew  gridview  stagger 相互转换
 *                      2.cardView        实现一个立体的卡片 含有圆角阴影等特效
 *                                        android:elevation  设置立体高度
 *                                        card_view:cardBackgroundColor 设置背景色
 *                                        card_view:cardCornerRadius="8dp" 设置圆角
 *
 */
public class MainActivity extends AppCompatActivity implements  MyRecyclerAdapter.OnClickItemListener{

    private RecyclerView recyclerView;
    private MyRecyclerAdapter mAdapter;
    private List<DataModel> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //初始化组件
        initView();
        //初始化数据
        initData();
    }
    //初始化组件
    private void initView() {
        recyclerView= (RecyclerView) findViewById(R.id.rv);
    }
    //初始化数据
    private void initData() {
        list=new ArrayList<>();
        for (int i=0;i<30;i++){
            DataModel data=new DataModel();
            data.setData("第"+i+"个数据");
            list.add(data);
        }
        mAdapter=new MyRecyclerAdapter(this,list);
        //设置显示类型  lIstview
        recyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        //设置动画
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        //设置适配器
        recyclerView.setAdapter(mAdapter);
        //添加分割线
        RecyclerView.ItemDecoration itemDecoration=new RecyclerViewDivide(this);
        recyclerView.addItemDecoration(itemDecoration);
        //设置监听
        mAdapter.setOnClickItemListener(this);
    }

    @Override
    public void onItemClickListener(View view, int position) {
        Toast.makeText(this,"短按了："+position,Toast.LENGTH_SHORT).show();
        if(position==0){
            Intent  intent =new Intent(MainActivity.this, CardViewActivty.class);
            startActivity(intent);
        }
    }

    @Override
    public void onItemLongClickListener(View view, int position) {
        Toast.makeText(this,"长按了："+position,Toast.LENGTH_SHORT).show();
    }
}
