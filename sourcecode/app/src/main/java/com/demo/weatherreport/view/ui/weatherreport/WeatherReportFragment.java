package com.demo.weatherreport.view.ui.weatherreport;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.demo.weatherreport.R;
import com.demo.weatherreport.model.pojo.ResWeatherReport;
import com.demo.weatherreport.presenter.weatherreport.WeatherReportContract;
import com.demo.weatherreport.view.adapters.WeatherReportAdapter;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class WeatherReportFragment extends Fragment implements WeatherReportContract.View {


    @BindView(R.id.tbWeatherReport)
    Toolbar tbWeatherReport;
    @BindView(R.id.pbWeatherReport)
    ProgressBar pbWeatherReport;
    @BindView(R.id.tvProgressbar)
    TextView tvProgressbar;
    @BindView(R.id.rlProgressbar)
    RelativeLayout rlProgressbar;
    Unbinder unbinder;
    @BindView(R.id.rvWeatherReport)
    RecyclerView rvWeatherReport;
    private WeatherReportContract.Presenter presenter;
    private View view;
    private boolean isVisible;

    public static WeatherReportFragment getInstance() {
        return new WeatherReportFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.weather_report_fragment, container, false);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        tbWeatherReport.setNavigationIcon(R.drawable.navigation_back_icn);
        tbWeatherReport.setNavigationOnClickListener(new View.OnClickListener() {
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
        presenter.stop();

    }

    @Override
    public void setPresenter(WeatherReportContract.Presenter presenter) {

        this.presenter = presenter;
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

    @Override
    public void showProgressBar() {
        rlProgressbar.setVisibility(View.VISIBLE);
    }

    @Override
    public void showProgressBarMsg(String msg) {

        tvProgressbar.setText(msg);
    }

    @Override
    public void hideProgressBar() {
        rlProgressbar.setVisibility(View.GONE);
    }

    /**
     * Show weather data for the selected region
     * @param resWeatherReportList
     */
    @Override
    public void showData(List<ResWeatherReport> resWeatherReportList) {

        rvWeatherReport.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
        WeatherReportAdapter weatherReportAdapter = new WeatherReportAdapter(resWeatherReportList);
        rvWeatherReport.setAdapter(weatherReportAdapter);
    }

    /**
     * Show title
     * @param text
     */
    @Override
    public void showHeading(String text) {
        tbWeatherReport.setTitle(text);
        tbWeatherReport.setTitleTextColor(getActivity().getResources().getColor(R.color.toll_bar_heading));
    }

}
