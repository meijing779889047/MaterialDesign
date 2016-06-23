package com.bestom.mj.materialdesign.ui;

import android.annotation.TargetApi;
import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.widget.SeekBar;

import com.bestom.mj.materialdesign.R;

public class CardViewActivty extends AppCompatActivity {

    private CardView  cardView;
    private SeekBar   radius;
    private SeekBar   elevator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.card_view);
        //初始化组件
        initView();
        //设置监听
        setListener();
    }

    private void initView() {
        cardView= (CardView) findViewById(R.id.cardview);
        radius= (SeekBar) findViewById(R.id.cardview_radius_seekbar);
        elevator= (SeekBar) findViewById(R.id.cardview_elevation_seekbar);
    }

    private void setListener() {
        radius.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                cardView.setRadius(progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        elevator.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            @TargetApi(Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                cardView.setElevation(progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }
}
