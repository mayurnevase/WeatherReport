package com.demo.weatherreport.model.repository;

import android.os.AsyncTask;

import com.demo.weatherreport.model.WebServiceResponseCallBack;
import com.demo.weatherreport.model.pojo.ResWeatherReport;
import com.demo.weatherreport.model.pojo.WeatherStat;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class RemoteRepositoryDataSource implements WeatherReportRepositoryDataInteractor.RemoteUserTask {

    private static RemoteRepositoryDataSource remoteRepositoryDataSource;
    private String fileData = null;


    private RemoteRepositoryDataSource() {

    }

    public static WeatherReportRepositoryDataInteractor.RemoteUserTask getInstance() {
        if (remoteRepositoryDataSource == null) {

            remoteRepositoryDataSource = new RemoteRepositoryDataSource();
        }
        return remoteRepositoryDataSource;
    }


    /**
     * Http request to download file from server
     * @param url
     * @param webServiceResponseCallBack
     */
    @Override
    public void downloadFile(String url, final WebServiceResponseCallBack webServiceResponseCallBack) {

        fileData = "";

        new AsyncTask<String, Void, Boolean>() {

            @Override
            protected Boolean doInBackground(String... params) {


                URL url;
                try {
                    url = new URL(params[0]);
                    HttpURLConnection con = (HttpURLConnection) url.openConnection();
                    InputStream is = con.getInputStream();
                    BufferedReader br = new BufferedReader(new InputStreamReader(is));
                    String line;
                    while ((line = br.readLine()) != null) {

                        line = line.replaceAll("\\s+", " ");
                        fileData += line + "\n";

                    }

                    br.close();

                } catch (Exception e) {
                    e.printStackTrace();
                    return false;
                }

                return true;
            }

            @Override
            protected void onPostExecute(Boolean s) {
                super.onPostExecute(s);
                if (s) {
                    webServiceResponseCallBack.onJobDone(fileData);

                } else {
                    webServiceResponseCallBack.onJobFailed();

                }

            }
        }.execute(url);

    }


}
