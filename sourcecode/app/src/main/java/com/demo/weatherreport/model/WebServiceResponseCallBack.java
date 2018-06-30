package com.demo.weatherreport.model;


public interface WebServiceResponseCallBack<T> {

    void onJobDone(T response);

    void onJobFailed();
}
