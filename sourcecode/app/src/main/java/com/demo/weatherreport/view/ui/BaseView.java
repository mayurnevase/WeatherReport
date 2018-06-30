package com.demo.weatherreport.view.ui;



public interface BaseView<T> {
    void setPresenter(T presenter);

    boolean isFragmentVisible();
}
