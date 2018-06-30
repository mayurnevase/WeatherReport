package com.demo.weatherreport.model.repository;

import com.demo.weatherreport.model.WeatherReportDB;
import com.demo.weatherreport.model.pojo.ResWeatherReport;
import com.demo.weatherreport.model.pojo.WeatherStat;
import com.demo.weatherreport.utils.GeometryData;
import com.demo.weatherreport.utils.RegionalWeatherData;

import java.util.List;

public class LocalRepositoryDataSource implements WeatherReportRepositoryDataInteractor.LocalUserTask {

    private static LocalRepositoryDataSource localRepositoryDataSource;
    private WeatherReportDB weatherReportDB;

    private LocalRepositoryDataSource(WeatherReportDB weatherReportDB) {
        this.weatherReportDB = weatherReportDB;

    }

    public static WeatherReportRepositoryDataInteractor.LocalUserTask getInstance(WeatherReportDB weatherReportDB) {
        if (localRepositoryDataSource == null) {
            localRepositoryDataSource = new LocalRepositoryDataSource(weatherReportDB);
        }
        return localRepositoryDataSource;
    }


    @Override
    public String getRegionalData() {
        return RegionalWeatherData.Regional_Data;
    }

    @Override
    public void insertWeatherStat(ResWeatherReport resWeatherReportList) {
        weatherReportDB.insertWeatherData(resWeatherReportList);

    }

    @Override
    public List<ResWeatherReport> getWeatherReportData(String region, String statType) {
        return weatherReportDB.getWeatherReportData(region, statType);
    }

    @Override
    public String getGeometryData() {
        return GeometryData.GEO_JSON_DATA;
    }
}
