package com.demo.weatherreport.view.ui.geometrylist;

import android.app.FragmentManager;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.LinearLayout;

import com.demo.weatherreport.R;
import com.demo.weatherreport.presenter.geometrylist.GeometryListPresenter;

import butterknife.BindView;
import butterknife.ButterKnife;

public class GeometryListActivity extends AppCompatActivity {


    @BindView(R.id.ll_main)
    LinearLayout llMain;
    FragmentManager fragmentManager;
    GeometryListFragment geometryListFragment;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.geo_metry_list_activity);
        ButterKnife.bind(this);
        fragmentManager = getFragmentManager();
        geometryListFragment = GeometryListFragment.getInstance();
        new GeometryListPresenter(geometryListFragment);
        fragmentManager.beginTransaction().replace(llMain.getId(), geometryListFragment, "geometryListFragment").commit();

    }

}
