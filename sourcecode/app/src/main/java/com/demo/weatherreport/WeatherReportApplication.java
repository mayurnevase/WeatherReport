package com.demo.weatherreport;

import android.app.Application;

import com.demo.weatherreport.model.WeatherReportDB;
import com.demo.weatherreport.model.repository.LocalRepositoryDataSource;
import com.demo.weatherreport.model.repository.RemoteRepositoryDataSource;
import com.demo.weatherreport.model.repository.WeatherReportRepository;
import com.demo.weatherreport.utils.AppConstant;

public class WeatherReportApplication extends Application {


    private WeatherReportRepository weatherReportRepository;
    private static WeatherReportApplication weatherReportApplication;

    @Override
    public void onCreate() {
        super.onCreate();
        weatherReportApplication = this;
        createComponentModule();
    }

    void createComponentModule() {

        weatherReportRepository = WeatherReportRepository.getInstance(LocalRepositoryDataSource.getInstance(new WeatherReportDB(this, AppConstant.DATABASE_NAME, null, AppConstant.DATABASE_VERSION)), RemoteRepositoryDataSource.getInstance());
    }

    public WeatherReportRepository getWeatherReportRepository() {
        return weatherReportRepository;
    }

    public static WeatherReportApplication getInstance() {
        return weatherReportApplication;
    }
}
