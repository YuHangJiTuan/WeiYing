package com.bwie.wangkui.weiying.base;

import android.os.Binder;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import butterknife.ButterKnife;
import butterknife.Unbinder;

public abstract class BaseActivity<T extends BasePresenter> extends AppCompatActivity implements BaseView {
     private T presenter;
    private Unbinder mUnBinder;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //初始化布局
         setContentView(getLayout());
        mUnBinder = ButterKnife.bind(this);
        //初始化数据--找控件
         initView();
        //绑定Presenter
        if(presenter==null){
            presenter = getPresenter();
        }
        initData();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(presenter!=null){
          presenter=null;
        }
        if (mUnBinder != null)
            mUnBinder.unbind();
    }


    protected abstract int getLayout();

    protected abstract void initView();

    protected abstract T getPresenter();

    protected abstract void initData();


}
