package com.demo.weatherreport.presenter.geometrylist;

import com.demo.weatherreport.WeatherReportApplication;
import com.demo.weatherreport.model.pojo.Coordinates;
import com.demo.weatherreport.model.pojo.ResGeometryData;
import com.demo.weatherreport.utils.AppConstant;
import com.demo.weatherreport.utils.AppUtility;
import com.google.android.gms.maps.model.LatLng;
import com.google.gson.JsonArray;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class GeometryListPresenter implements GeometryListContract.Presenter {

    GeometryListContract.View view;
    List<ResGeometryData> resGeometryDataList;

    public GeometryListPresenter(GeometryListContract.View view) {
        this.view = view;
        view.setPresenter(this);
    }

    @Override
    public void start() {

        parseGeoData(WeatherReportApplication.getInstance().getWeatherReportRepository().getGeometryData());
        view.showGeometryList(resGeometryDataList);

    }

    @Override
    public void stop() {

    }


    /**
     * Method to parse data from geo json
     *
     * @param data
     */
    private void parseGeoData(String data) {

        try {
            JSONArray jsonArray = new JSONArray(data);
            JSONObject jsonObject = jsonArray.getJSONObject(0);
            JSONArray farmsArray = jsonObject.getJSONArray("farms");
            JSONArray fieldArray = jsonObject.getJSONArray("fields");
            resGeometryDataList = new ArrayList<>();

            //parse farm data from geo json
            for (int i = 0; i < farmsArray.length(); i++) {

                JSONObject jsonObject1 = farmsArray.getJSONObject(i);
                ResGeometryData resGeometryData = new ResGeometryData();

                resGeometryData.setGeometryType(jsonObject1.getJSONObject("geometry").getString("type"));

                ArrayList<Coordinates> latLngArrayList = new ArrayList<>();
                latLngArrayList.add(new Coordinates(Double.parseDouble(jsonObject1.getJSONObject("geometry").getJSONArray("coordinates").getString(1)), Double.parseDouble(jsonObject1.getJSONObject("geometry").getJSONArray("coordinates").getString(0))));
                resGeometryData.setLatLngList(latLngArrayList);

                resGeometryData.setType(jsonObject1.getString("type"));
                resGeometryData.setLat(Double.parseDouble(jsonObject1.getJSONObject("properties").getString("farm_latitude")));
                resGeometryData.setLng(Double.parseDouble(jsonObject1.getJSONObject("properties").getString("farm_longitude")));
                resGeometryData.setFarmName(jsonObject1.getJSONObject("properties").getString("farm_name"));
                resGeometryData.setPermission(jsonObject1.getJSONObject("properties").getBoolean("permission"));
                resGeometryData.setFarmSlug(jsonObject1.getJSONObject("properties").getString("farm_slug"));
                resGeometryData.setTeamId(jsonObject1.getJSONObject("properties").getString("team_id"));
                resGeometryData.setFarmLocation(jsonObject1.getJSONObject("properties").getString("farm_location"));
                resGeometryData.setOwnership(jsonObject1.getJSONObject("properties").getBoolean("ownership"));
                resGeometryData.setLocationSlug(jsonObject1.getJSONObject("properties").getString("location_slug"));

                resGeometryDataList.add(resGeometryData);


            }

            //parse field data from geo json
            for (int j = 0; j < fieldArray.length(); j++) {

                JSONObject jsonObject1 = fieldArray.getJSONObject(j);
                ResGeometryData resGeometryData = new ResGeometryData();

                resGeometryData.setGeometryType(jsonObject1.getJSONObject("geometry").getString("type"));
                ArrayList<Coordinates> latLngArrayList = new ArrayList<>();
                for (int k = 0; k < jsonObject1.getJSONObject("geometry").getJSONArray("coordinates").getJSONArray(0).length(); k++) {
                    Coordinates latLng = new Coordinates(Double.parseDouble(jsonObject1.getJSONObject("geometry").getJSONArray("coordinates").getJSONArray(0).getJSONArray(k).getString(1)), Double.parseDouble(jsonObject1.getJSONObject("geometry").getJSONArray("coordinates").getJSONArray(0).getJSONArray(k).getString(0)));
                    latLngArrayList.add(latLng);
                }

                resGeometryData.setLatLngList(latLngArrayList);

                resGeometryData.setType(jsonObject1.getString("type"));
                resGeometryData.setPermission(jsonObject1.getJSONObject("properties").getBoolean("permission"));
                resGeometryData.setSoilType(jsonObject1.getJSONObject("properties").getString("soil_type"));
                resGeometryData.setFieldId(jsonObject1.getJSONObject("properties").getString("field_id"));
                resGeometryData.setFarmSlug(jsonObject1.getJSONObject("properties").getString("farm_slug"));
                resGeometryData.setTeamId(jsonObject1.getJSONObject("properties").getString("team_id"));
                resGeometryData.setOwnership(jsonObject1.getJSONObject("properties").getBoolean("ownership"));
                resGeometryData.setTeamName(jsonObject1.getJSONObject("properties").getString("team_name"));
                resGeometryData.setLocationSlug(jsonObject1.getJSONObject("properties").getString("location_slug"));
                resGeometryData.setFieldArea(jsonObject1.getJSONObject("properties").getString("field_area"));
                resGeometryData.setFarmName(jsonObject1.getJSONObject("properties").getString("farm_name"));
                resGeometryData.setFieldName(jsonObject1.getJSONObject("properties").getString("field_name"));
                resGeometryData.setNote(jsonObject1.getJSONObject("properties").getString("notes"));
                resGeometryData.setLat(Double.parseDouble(jsonObject1.getJSONObject("properties").getString("field_latitude")));
                resGeometryData.setLng(Double.parseDouble(jsonObject1.getJSONObject("properties").getString("field_longitude")));
                resGeometryData.setWorkableArea(jsonObject1.getJSONObject("properties").getString("workable_area"));

                resGeometryData.setFarmLocation(jsonObject1.getJSONObject("properties").getString("field_name"));


                resGeometryDataList.add(resGeometryData);


            }


        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onItemClick(ResGeometryData resGeometryData) {
        if (AppUtility.isNetworkConnected()) {
            view.showGeoLocation(resGeometryData);
        } else {
            view.showErrorMsg(AppConstant.NO_NETWORK_CONNECTION_MSG);
        }

    }
}
