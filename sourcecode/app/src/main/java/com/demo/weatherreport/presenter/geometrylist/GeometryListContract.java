package com.demo.weatherreport.presenter.geometrylist;

import com.demo.weatherreport.model.pojo.ResGeometryData;
import com.demo.weatherreport.presenter.BasePresenter;
import com.demo.weatherreport.view.adapters.GeometryListAdapter;
import com.demo.weatherreport.view.ui.BaseView;

import java.util.List;

public interface GeometryListContract {

    interface View extends BaseView<Presenter>,GeometryListAdapter.GeometryListView {
        void showGeometryList(List<ResGeometryData> resGeometryDataList);

        void showErrorMsg(String msg);
        void showGeoLocation(ResGeometryData resGeometryData);

    }

    interface Presenter extends BasePresenter {
        void onItemClick(ResGeometryData resGeometryData);

    }
}
