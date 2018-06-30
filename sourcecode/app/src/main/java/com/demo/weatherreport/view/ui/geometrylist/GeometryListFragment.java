package com.demo.weatherreport.view.ui.geometrylist;

import android.app.Fragment;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.demo.weatherreport.R;
import com.demo.weatherreport.model.pojo.ResGeometryData;
import com.demo.weatherreport.presenter.geometrylist.GeometryListContract;
import com.demo.weatherreport.view.adapters.GeometryListAdapter;
import com.demo.weatherreport.view.ui.geometry.GeometryActivity;

import java.io.Serializable;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class GeometryListFragment extends Fragment implements GeometryListContract.View {

    GeometryListContract.Presenter presenter;
    View view;
    @BindView(R.id.rvGeometry)
    RecyclerView rvGeometry;
    Unbinder unbinder;
    boolean isVisible;
    @BindView(R.id.tbWeather)
    Toolbar tbWeather;

    public static GeometryListFragment getInstance() {
        return new GeometryListFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.geometry_list_fragment, container, false);
        unbinder = ButterKnife.bind(this, view);
        return view;

    }

    @Override
    public void setPresenter(GeometryListContract.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        tbWeather.setNavigationIcon(R.drawable.navigation_back_icn);
        tbWeather.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().onBackPressed();
            }
        });
    }

    @Override
    public void onStart() {
        super.onStart();
        isVisible = true;
        presenter.start();
    }

    @Override
    public void onStop() {
        super.onStop();
        isVisible = false;
    }

    @Override
    public boolean isFragmentVisible() {
        return isVisible;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    /**
     * Show Geometry list
     * @param resGeometryDataList
     */
    @Override
    public void showGeometryList(List<ResGeometryData> resGeometryDataList) {
        rvGeometry.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
        GeometryListAdapter geometryListAdapter = new GeometryListAdapter(resGeometryDataList, this);
        rvGeometry.setAdapter(geometryListAdapter);
    }

    @Override
    public void onItemClick(ResGeometryData resGeometryData) {

        presenter.onItemClick(resGeometryData);
    }

    /**
     * Method to move geometry activity
     * @param resGeometryData
     */
    @Override
    public void showGeoLocation(ResGeometryData resGeometryData) {

        Intent intent = new Intent(getActivity(), GeometryActivity.class);
        Bundle bundle = new Bundle();
        bundle.putSerializable("geometryData", (Serializable) resGeometryData);
        intent.putExtra("data", bundle);
        startActivity(intent);
    }

    /**
     * Show Error message for no internet connection
     * @param msg
     */
    @Override
    public void showErrorMsg(String msg) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setMessage(msg)
                .setCancelable(false)
                .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {

                        dialog.cancel();
                    }
                });
        AlertDialog alert = builder.create();
        alert.show();
    }
}
