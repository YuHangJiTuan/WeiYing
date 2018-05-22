package com.bwie.wangkui.weiying;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;

import com.bwie.wangkui.weiying.base.BaseActivity;
import com.bwie.wangkui.weiying.base.BasePresenter;
import com.bwie.wangkui.weiying.find.ThreeFragment;
import com.bwie.wangkui.weiying.jingxuan.OneFragment;
import com.bwie.wangkui.weiying.myindo.FourFragment;
import com.bwie.wangkui.weiying.zhuanti.TwoFragment;
import com.hjm.bottomtabbar.BottomTabBar;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity {

    @BindView(R.id.bottombar)
    BottomTabBar bottombar;
    private BottomTabBar mBottombar;

    @Override
    protected int getLayout() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {
        mBottombar = (BottomTabBar) findViewById(R.id.bottombar);
        mBottombar
                .init(getSupportFragmentManager())//初始化方法，必须第一个调用；传入参数为V4包下的FragmentManager
                .setImgSize(60, 60)//设置ICON图片的尺寸
                .setFontSize(12)//设置文字的尺寸
                .setTabPadding(4, 6, 0)//设置ICON图片与上部分割线的间隔、图片与文字的间隔、文字与底部的间隔
                .setChangeColor( Color.RED,Color.DKGRAY)//设置选中的颜色、未选中的颜色
                .addTabItem("精选", R.mipmap.found_select, R.mipmap.found, OneFragment.class)//设置文字、一张图片、fragment
                .addTabItem("专题", R.mipmap.special_select, R.mipmap.special, TwoFragment.class)//设置文字、两张图片、fragment
               .addTabItem("发现", R.mipmap.fancy_select, R.mipmap.fancy, ThreeFragment.class)//设置文字、两张图片、fragment
                .addTabItem("我的", R.mipmap.my_select, R.mipmap.my, FourFragment.class)//设置文字、两张图片、fragment
                .isShowDivider(false)//设置是否显示分割线
          //      .setTabBarBackgroundColor(Color.WHITE)//设置底部导航栏颜色
                .setTabBarBackgroundResource(R.mipmap.bottom_bg)//设置底部导航栏的背景图片【与设置底部导航栏颜色方法不能同时使用，否则会覆盖掉前边设置的颜色】
                .setOnTabChangeListener(new BottomTabBar.OnTabChangeListener() {
                    @Override
                    public void onTabChange(int position, String name, View view) {
                        Log.i("TGA", "位置：" + position + "      选项卡的文字内容：" + name);
                    }//添加选项卡切换监听

                })
                .setCurrentTab(0);//设置当前选中的Tab，从0开始


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

    @Override
    public void showSuccess(Object o) {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
        setContentView(R.layout.activity_main);
        initView();
    }
}

