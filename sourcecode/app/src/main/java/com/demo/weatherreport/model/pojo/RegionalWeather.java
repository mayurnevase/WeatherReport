package com.demo.weatherreport.model.pojo;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class RegionalWeather {

    @SerializedName("weather_stat")
    List<WeatherStat> weatherStatList;

    public List<WeatherStat> getWeatherStatList() {
        return weatherStatList;
    }

    public void setWeatherStatList(List<WeatherStat> weatherStatList) {
        this.weatherStatList = weatherStatList;
    }
}
