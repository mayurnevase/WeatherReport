package com.demo.weatherreport.view.ui.geometry;

import android.app.FragmentManager;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.LinearLayout;

import com.demo.weatherreport.R;
import com.demo.weatherreport.model.pojo.ResGeometryData;
import com.demo.weatherreport.presenter.geometry.GeometryPresenter;

import butterknife.BindView;
import butterknife.ButterKnife;

public class GeometryActivity extends AppCompatActivity {

    @BindView(R.id.llMain)
    LinearLayout llMain;
    private FragmentManager fragmentManager;
    GeometryFragment geometryFragment;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.geo_metry_activity);
        ButterKnife.bind(this);

        fragmentManager = getFragmentManager();
        geometryFragment = GeometryFragment.getInstance();
        new GeometryPresenter(geometryFragment, (ResGeometryData) getIntent().getBundleExtra("data").getSerializable("geometryData"));
        fragmentManager.beginTransaction().replace(llMain.getId(), geometryFragment, "regionFragment").commit();
    }

}
