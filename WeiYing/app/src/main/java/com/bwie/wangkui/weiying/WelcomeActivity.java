package com.bwie.wangkui.weiying;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.WindowManager;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bwie.wangkui.weiying.base.BaseActivity;
import com.bwie.wangkui.weiying.base.BasePresenter;
import com.bwie.wangkui.weiying.utils.ImageLoader;
import com.bwie.wangkui.weiying.utils.StringUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class WelcomeActivity extends BaseActivity {


    @BindView(R.id.welcome)
    ImageView welcome;

    private List<String> getImgData() {
        List<String> imgs = new ArrayList<>();
        imgs.add("file:///android_asset/a.jpg");
        imgs.add("file:///android_asset/b.jpg");
        imgs.add("file:///android_asset/c.jpg");
        imgs.add("file:///android_asset/d.jpg");
        imgs.add("file:///android_asset/e.jpg");
        imgs.add("file:///android_asset/f.jpg");
        imgs.add("file:///android_asset/g.jpg");
        return imgs;
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_welcome;

    }

    @Override
    protected void initView() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            WindowManager.LayoutParams localLayoutParams = getWindow().getAttributes();
            localLayoutParams.flags = (WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS | localLayoutParams.flags);
        }

        List<String> list = getImgData();
        if (list != null) {
            int page = StringUtils.getRandomNumber(0, list.size() - 1);
            ImageLoader.load(WelcomeActivity.this, list.get(page), welcome);
          welcome.animate().scaleX(1.12f).scaleY(1.12f).setDuration(2000).setStartDelay(100).start();

          }
           startActivity(new Intent(WelcomeActivity.this,MainActivity.class));
    }

    @Override
    protected BasePresenter getPresenter() {
        return null;
    }

    @Override
    protected void initData() {

    }

    @Override
    public void showError(String msg) {

    }

    @SuppressLint({"StaticFieldLeak", "HandlerLeak"})
    @Override
    public void showSuccess(Object o) {
        AsyncTask<String, Integer, String> asyncTask = new AsyncTask<String, Integer, String>() {
            @Override
            protected String doInBackground(String... strings) {
                return null;
            }
        };
        asyncTask.execute("");

        Handler handler = new Handler() {
            @Override
            public void handleMessage(Message msg) {
                super.handleMessage(msg);
            }
        };
        handler.sendEmptyMessage(0);
    }



}
