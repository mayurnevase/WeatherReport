package com.demo.weatherreport.model.repository;

import com.demo.weatherreport.model.WebServiceResponseCallBack;
import com.demo.weatherreport.model.pojo.ResWeatherReport;


import java.util.List;

public interface WeatherReportRepositoryDataInteractor {

    public interface LocalUserTask {
        String getRegionalData();

        void insertWeatherStat(ResWeatherReport resWeatherReports);

        List<ResWeatherReport> getWeatherReportData(String region, String statType);

        String getGeometryData();

    }

    public interface RemoteUserTask {
        void downloadFile(String url, WebServiceResponseCallBack webServiceResponseCallBack);

    }
}
