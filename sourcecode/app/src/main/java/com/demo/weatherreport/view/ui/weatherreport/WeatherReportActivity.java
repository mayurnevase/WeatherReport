package com.demo.weatherreport.view.ui.weatherreport;

import android.app.FragmentManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.LinearLayout;

import com.demo.weatherreport.R;
import com.demo.weatherreport.presenter.weatherreport.WeatherReportPresenter;

import butterknife.BindView;
import butterknife.ButterKnife;

public class WeatherReportActivity extends AppCompatActivity {

    @BindView(R.id.llMain)
    LinearLayout llMain;
    private WeatherReportFragment weatherReportFragment;
    private FragmentManager fragmentManager;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.weather_report_activity);
        ButterKnife.bind(this);
        fragmentManager = getFragmentManager();
        weatherReportFragment = WeatherReportFragment.getInstance();
        new WeatherReportPresenter(getIntent().getStringExtra("reportUrl"),getIntent().getStringExtra("region"),getIntent().getStringExtra("statType"),weatherReportFragment);
        fragmentManager.beginTransaction().replace(llMain.getId(), weatherReportFragment, "weatherReportFragment").commit();

    }


}
