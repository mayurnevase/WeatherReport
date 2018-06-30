package com.demo.weatherreport.presenter.geometry;

import com.demo.weatherreport.model.pojo.Coordinates;
import com.demo.weatherreport.presenter.BasePresenter;
import com.demo.weatherreport.view.ui.BaseView;
import com.google.android.gms.maps.model.LatLng;

import java.util.ArrayList;
import java.util.List;

public interface GeometryContract {

    interface View extends BaseView<Presenter> {

        void showFarmLocation(LatLng latLng,String name);

        void showFieldPolygon(List<Coordinates> latLngArrayList, LatLng latLng,String name);

    }

    interface Presenter extends BasePresenter {

       void showGeoData();
    }


}
