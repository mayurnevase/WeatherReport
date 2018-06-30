package com.demo.weatherreport.presenter.weatherreport;

import com.demo.weatherreport.model.pojo.ResWeatherReport;
import com.demo.weatherreport.presenter.BasePresenter;
import com.demo.weatherreport.view.ui.BaseView;

import java.util.List;

public interface WeatherReportContract {

    interface View extends BaseView<Presenter> {

        void showProgressBar();

        void showProgressBarMsg(String msg);

        void hideProgressBar();

        void showData(List<ResWeatherReport> resWeatherReportList);

        void showHeading(String text);
    }

    interface Presenter extends BasePresenter {

    }
}
