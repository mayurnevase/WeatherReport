package com.demo.weatherreport.presenter.regionalweather;

import com.demo.weatherreport.WeatherReportApplication;
import com.demo.weatherreport.model.pojo.RegionalWeather;
import com.demo.weatherreport.utils.AppConstant;
import com.demo.weatherreport.utils.AppUtility;
import com.google.gson.Gson;

import java.util.List;

public class RegionPresenter implements RegionContract.Presenter {

    private RegionContract.View view;
    private Gson gson;
    private RegionalWeather regionalWeather;

    public RegionPresenter(RegionContract.View view) {

        this.view = view;
        view.setPresenter(this);
        gson = new Gson();
    }

    @Override
    public void start() {
        regionalWeather = gson.fromJson(WeatherReportApplication.getInstance().getWeatherReportRepository().getRegionalData(), RegionalWeather.class);
        view.showRegionalWeatherList(regionalWeather.getWeatherStatList());
    }

    @Override
    public void stop() {

    }

    @Override
    public void getWeatherStatForRegion(String url, String region, String statType) {
        if (AppUtility.isNetworkConnected()) {
            view.showWeatherStat(url, region, statType);
        } else {
            view.showErrorMsg(AppConstant.NO_NETWORK_CONNECTION_MSG);
        }
    }
}
