package com.demo.weatherreport.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import com.demo.weatherreport.WeatherReportApplication;

public class AppUtility {

    /**
     * Check if Internet connection is working
     * @return
     */
    public static boolean isNetworkConnected() {
        ConnectivityManager
                cm = (ConnectivityManager) WeatherReportApplication.getInstance().getApplicationContext()
                .getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
        return activeNetwork != null
                && activeNetwork.isConnectedOrConnecting();
    }
}
