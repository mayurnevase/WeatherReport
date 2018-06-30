package com.demo.weatherreport.view.ui.regionalweather;

import android.app.FragmentManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.LinearLayout;

import com.demo.weatherreport.R;
import com.demo.weatherreport.presenter.regionalweather.RegionPresenter;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RegionActivity extends AppCompatActivity {

    @BindView(R.id.ll_main)
    LinearLayout llMain;
    FragmentManager fragmentManager;
    RegionFragment regionFragment;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.region_activtiy);
        ButterKnife.bind(this);
        fragmentManager = getFragmentManager();
        regionFragment = RegionFragment.getInstance();
        new RegionPresenter(regionFragment);
        fragmentManager.beginTransaction().replace(llMain.getId(), regionFragment, "regionFragment").commit();
    }
}
