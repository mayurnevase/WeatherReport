package com.demo.weatherreport.model.repository;

import com.demo.weatherreport.model.WebServiceResponseCallBack;
import com.demo.weatherreport.model.pojo.ResWeatherReport;
import com.demo.weatherreport.model.pojo.WeatherStat;

import java.util.List;

public class WeatherReportRepository implements WeatherReportRepositoryDataInteractor.LocalUserTask, WeatherReportRepositoryDataInteractor.RemoteUserTask {


    private static WeatherReportRepository weatherReportRepository;
    private WeatherReportRepositoryDataInteractor.LocalUserTask localUserTask;
    private WeatherReportRepositoryDataInteractor.RemoteUserTask remoteUserTask;


    private WeatherReportRepository(WeatherReportRepositoryDataInteractor.LocalUserTask localUserTask, WeatherReportRepositoryDataInteractor.RemoteUserTask remoteUserTask) {
        this.localUserTask = localUserTask;
        this.remoteUserTask = remoteUserTask;
    }

    public static WeatherReportRepository getInstance(WeatherReportRepositoryDataInteractor.LocalUserTask localUserTask, WeatherReportRepositoryDataInteractor.RemoteUserTask remoteUserTask) {
        if (weatherReportRepository == null) {
            weatherReportRepository = new WeatherReportRepository(localUserTask, remoteUserTask);
        }
        return weatherReportRepository;
    }


    @Override
    public String getRegionalData() {
        return localUserTask.getRegionalData();
    }

    @Override
    public void insertWeatherStat(ResWeatherReport resWeatherReportList) {
        localUserTask.insertWeatherStat(resWeatherReportList);
    }

    @Override
    public List<ResWeatherReport> getWeatherReportData(String region, String statType) {
        return localUserTask.getWeatherReportData(region,statType);
    }

    @Override
    public String getGeometryData() {
        return localUserTask.getGeometryData();
    }

    @Override
    public void downloadFile(String url, final WebServiceResponseCallBack webServiceResponseCallBack) {
        remoteUserTask.downloadFile(url, new WebServiceResponseCallBack() {
            @Override
            public void onJobDone(Object response) {
                webServiceResponseCallBack.onJobDone(response);
            }

            @Override
            public void onJobFailed() {

                webServiceResponseCallBack.onJobFailed();
            }
        });
    }
}
