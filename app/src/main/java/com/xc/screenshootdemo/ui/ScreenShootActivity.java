package com.xc.screenshootdemo.ui;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.animation.GlideAnimation;
import com.bumptech.glide.request.target.SimpleTarget;
import com.xc.screenshootdemo.R;
import com.xc.screenshootdemo.util.PopuUtil;
import com.xc.screenshootdemo.util.ScreenShoot;

/**
 * 作者：Created by xuchao on 2018/8/20.
 * 描述：activity截图
 */

public class ScreenShootActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.screen_shoot_activity);

        Glide.with(this)
                .load(R.drawable.img1)
                .asBitmap()
                .into(new SimpleTarget<Bitmap>() {
                    @Override
                    public void onResourceReady(Bitmap resource, GlideAnimation<? super Bitmap> glideAnimation) {
                        ((ImageView) findViewById(R.id.iv_img)).setImageBitmap(resource);
                    }
                });

        findViewById(R.id.btn_activity_screen_shoot)
                .setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Bitmap bitmap = ScreenShoot.activityScreenShoot(ScreenShootActivity.this);
                        PopuUtil.showPopu(ScreenShootActivity.this, bitmap, v);
                    }
                });

    }
}
