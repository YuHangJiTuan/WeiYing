package com.bwie.wangkui.weiying.base;

public interface BasePresenter<T extends BaseView,E extends BaseModel> {

      void attachView(T view,E model);

}
