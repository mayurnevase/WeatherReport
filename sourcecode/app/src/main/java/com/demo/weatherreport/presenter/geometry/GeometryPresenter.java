package com.demo.weatherreport.presenter.geometry;

import com.demo.weatherreport.model.pojo.ResGeometryData;
import com.demo.weatherreport.utils.AppConstant;
import com.google.android.gms.maps.model.LatLng;

public class GeometryPresenter implements GeometryContract.Presenter {

    private GeometryContract.View view;
    private ResGeometryData resGeometryData;

    public GeometryPresenter(GeometryContract.View view, ResGeometryData resGeometryData) {
        this.view = view;
        view.setPresenter(this);
        this.resGeometryData = resGeometryData;
    }

    @Override
    public void start() {

    }

    @Override
    public void stop() {

    }

    @Override
    public void showGeoData() {
        if (resGeometryData.getGeometryType().equals(AppConstant.GEO_TYPE_POINT)) {

            view.showFarmLocation(new LatLng(resGeometryData.getLatLngList().get(0).getLat(), resGeometryData.getLatLngList().get(0).getLng()),resGeometryData.getFarmName());
        } else {

            view.showFieldPolygon(resGeometryData.getLatLngList(), new LatLng(resGeometryData.getLat(), resGeometryData.getLng()),resGeometryData.getFarmName());
        }
    }
}
