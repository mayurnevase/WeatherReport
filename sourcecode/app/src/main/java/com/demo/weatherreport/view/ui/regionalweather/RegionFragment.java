package com.demo.weatherreport.view.ui.regionalweather;

import android.app.Fragment;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.CoordinatorLayout;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.demo.weatherreport.R;
import com.demo.weatherreport.model.pojo.WeatherStat;
import com.demo.weatherreport.presenter.regionalweather.RegionContract;
import com.demo.weatherreport.view.adapters.RegionalWeatherAdapter;
import com.demo.weatherreport.view.ui.weatherreport.WeatherReportActivity;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class RegionFragment extends Fragment implements RegionContract.View, RegionalWeatherAdapter.RegionalWeatherView {

    @BindView(R.id.rvRegion)
    RecyclerView rvRegion;
    @BindView(R.id.clMain)
    CoordinatorLayout clMain;
    Unbinder unbinder;
    @BindView(R.id.tvHeading)
    TextView tvHeading;
    @BindView(R.id.tbWeather)
    Toolbar tbWeather;
    private View regionFragmentView;
    private RegionContract.Presenter presenter;
    private boolean isVisible;

    public static RegionFragment getInstance() {
        return new RegionFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        regionFragmentView = inflater.inflate(R.layout.region_fragment, container, false);
        unbinder = ButterKnife.bind(this, regionFragmentView);
        return regionFragmentView;

    }

    @Override
    public void setPresenter(RegionContract.Presenter presenter) {

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
    public boolean isFragmentVisible() {
        return isVisible;
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
        presenter.stop();
    }

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

    /**
     * Show Region weather list
     * @param weatherStatList
     */
    @Override
    public void showRegionalWeatherList(List<WeatherStat> weatherStatList) {

        rvRegion.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
        RegionalWeatherAdapter regionalWeatherAdapter = new RegionalWeatherAdapter(weatherStatList, this);
        rvRegion.setAdapter(regionalWeatherAdapter);
        rvRegion.setNestedScrollingEnabled(false);
    }

    /**
     * Move to Weather stat screen
     * @param url
     * @param region
     * @param statType
     */
    @Override
    public void showWeatherStat(String url, String region, String statType) {

        Intent intent = new Intent(getActivity(), WeatherReportActivity.class);
        intent.putExtra("reportUrl", url);
        intent.putExtra("region", region);
        intent.putExtra("statType", statType);
        startActivity(intent);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @Override
    public void onItemClick(String url, String region, String statType) {

        presenter.getWeatherStatForRegion(url, region, statType);
    }
}
