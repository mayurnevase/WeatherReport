package com.demo.weatherreport.presenter.regionalweather;


import com.demo.weatherreport.model.pojo.WeatherStat;
import com.demo.weatherreport.presenter.BasePresenter;
import com.demo.weatherreport.view.ui.BaseView;

import java.util.List;

public interface RegionContract {

    interface View extends BaseView<Presenter> {

        void showErrorMsg(String msg);

        void showRegionalWeatherList(List<WeatherStat> weatherStatList);

        void showWeatherStat(String url,String region,String statType);
    }

    interface Presenter extends BasePresenter {

        void getWeatherStatForRegion(String url,String region,String statType);

    }

}
