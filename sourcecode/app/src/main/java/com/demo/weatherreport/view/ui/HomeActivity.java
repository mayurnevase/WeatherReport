package com.demo.weatherreport.view.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;

import com.demo.weatherreport.R;
import com.demo.weatherreport.view.ui.geometry.GeometryActivity;
import com.demo.weatherreport.view.ui.geometrylist.GeometryListActivity;
import com.demo.weatherreport.view.ui.regionalweather.RegionActivity;
import com.demo.weatherreport.view.ui.weatherreport.WeatherReportActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

public class HomeActivity extends AppCompatActivity implements View.OnClickListener{

    @BindView(R.id.btnAssignmentOne)
    Button btnAssignmentOne;
    @BindView(R.id.btnAssignmentTwo)
    Button btnAssignmentTwo;
    private Intent intent;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_activity);
        ButterKnife.bind(this);
        btnAssignmentTwo.setOnClickListener(this);
        btnAssignmentOne.setOnClickListener(this);
    }


    @Override
    public void onClick(View view) {
        switch(view.getId())
        {
            case R.id.btnAssignmentOne:
                 intent = new Intent(HomeActivity.this, RegionActivity.class);
                startActivity(intent);
                break;
            case R.id.btnAssignmentTwo:
                 intent = new Intent(HomeActivity.this, GeometryListActivity.class);
                startActivity(intent);
                break;
        }
    }
}
