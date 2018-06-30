package com.demo.weatherreport.presenter.weatherreport;

import com.demo.weatherreport.WeatherReportApplication;
import com.demo.weatherreport.model.WebServiceResponseCallBack;
import com.demo.weatherreport.model.pojo.ResWeatherReport;
import com.demo.weatherreport.utils.AppConstant;

import java.util.ArrayList;
import java.util.List;

public class WeatherReportPresenter implements WeatherReportContract.Presenter {

    private String url;
    private WeatherReportContract.View view;
    private String region;
    private String statType;


    private boolean headerFound = false;
    private List<ResWeatherReport> resWeatherReportList;

    public WeatherReportPresenter(String url, String region, String statType, WeatherReportContract.View view) {
        this.url = url;
        this.region = region;
        this.statType = statType;
        this.view = view;
        view.setPresenter(this);
    }

    @Override
    public void start() {
        view.showHeading(region+" - "+statType);
        resWeatherReportList = new ArrayList<>();
        addHeaders();
        //Check Weather data is present in database or not
        resWeatherReportList.addAll(WeatherReportApplication.getInstance().getWeatherReportRepository().getWeatherReportData(region, statType));
        if (resWeatherReportList.size() > 1) {
            view.hideProgressBar();
            view.showData(resWeatherReportList);
        } else {
            getWeatherReport();
        }

    }


    /**
     * Method to report download file from server and store data
     */
    void getWeatherReport() {
        view.showProgressBar();
        view.showProgressBarMsg(AppConstant.DOWNLOAD_DATA);
        WeatherReportApplication.getInstance().getWeatherReportRepository().downloadFile(url, new WebServiceResponseCallBack() {
            @Override
            public void onJobDone(Object response) {

                if (view.isFragmentVisible()) {

                    String data = (String) response;
                    String line[] = data.split(System.getProperty("line.separator"));
                    headerFound = false;

                    for (int i = 0; i < line.length; i++) {
                        parseWeatherData(line[i]);
                    }

                    view.hideProgressBar();
                    view.showData(resWeatherReportList);
                }

            }

            @Override
            public void onJobFailed() {
                if (view.isFragmentVisible()) {
                    view.hideProgressBar();
                }


            }
        });

    }

    @Override
    public void stop() {

    }


    /**
     * Method to parse string data from weather stat
     */
    private void parseWeatherData(String data) {

        String lineToken[] = data.split(" ");
        if (lineToken[0].equals("Year")) {
            headerFound = true;
            return;
        }

        if (headerFound == true) {

            ResWeatherReport resWeatherReport = new ResWeatherReport();
            String[] stat = new String[20];
            stat[0] = region;
            stat[1] = statType;
            for (int i = 0; i < 18; i++) {
                if (i < lineToken.length) {
                    stat[i + 2] = lineToken[i];
                } else {
                    stat[i + 2] = "NA";
                }
            }

            resWeatherReport.setData(stat);
            resWeatherReportList.add(resWeatherReport);
            WeatherReportApplication.getInstance().getWeatherReportRepository().insertWeatherStat(resWeatherReport);

        }

    }

    /**
     * Add Header to weather report table
     *
     * @return
     */
    private void addHeaders() {
        ResWeatherReport resWeatherReport = new ResWeatherReport();
        String[] header = new String[20];
        header[0] = "Region";
        header[1] = "Stat_type";
        header[2] = "Year";
        header[3] = "Jan";
        header[4] = "Feb";
        header[5] = "Mar";
        header[6] = "Apr";
        header[7] = "May";
        header[8] = "Jun";
        header[9] = "Jul";
        header[10] = "Aug";
        header[11] = "Sept";
        header[12] = "Oct";
        header[13] = "Nov";
        header[14] = "Dec";
        header[15] = "Win";
        header[16] = "Spr";
        header[17] = "Sum";
        header[18] = "Aut";
        header[19] = "Ann";

        resWeatherReport.setData(header);
        resWeatherReportList.add(resWeatherReport);
    }

}
