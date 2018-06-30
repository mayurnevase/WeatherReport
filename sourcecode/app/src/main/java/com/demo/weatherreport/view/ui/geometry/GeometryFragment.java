package com.demo.weatherreport.view.ui.geometry;

import android.app.Fragment;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.demo.weatherreport.R;
import com.demo.weatherreport.model.pojo.Coordinates;
import com.demo.weatherreport.presenter.geometry.GeometryContract;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.Polygon;
import com.google.android.gms.maps.model.PolygonOptions;

import java.util.ArrayList;
import java.util.List;

public class GeometryFragment extends Fragment implements OnMapReadyCallback, GeometryContract.View {

    private View view;
    private boolean isVisible;
    private MapFragment mapFragment;
    private GeometryContract.Presenter presenter;
    private GoogleMap googleMap;

    public static GeometryFragment getInstance() {
        return new GeometryFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.geo_metry_fragment, container, false);
        return view;

    }

    @Override
    public void onStart() {
        super.onStart();
        presenter.start();
        isVisible = true;
        mapFragment = (MapFragment) getChildFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onStop() {
        super.onStop();
        isVisible = false;
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {

        this.googleMap = googleMap;
        presenter.showGeoData();
    }

    @Override
    public void setPresenter(GeometryContract.Presenter presenter) {

        this.presenter = presenter;
    }

    @Override
    public boolean isFragmentVisible() {
        return false;
    }

    /**
     * Show marker on google map
     * @param latLng
     * @param name
     */
    @Override
    public void showFarmLocation(LatLng latLng,String name) {
        MarkerOptions markerOptions = new MarkerOptions();
        markerOptions.icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_marker));
        markerOptions.position(latLng);
        markerOptions.title(name);
        googleMap.clear();
        CameraPosition position = CameraPosition.builder()
                .target(latLng)
                .zoom(16f)
                .bearing(0.0f)
                .tilt(0.0f)
                .build();

        googleMap.animateCamera(CameraUpdateFactory.newCameraPosition(position));

        googleMap.addMarker(markerOptions);
    }

    /**
     * Show polygon on google map
     * @param latLngArrayList
     * @param latLng
     * @param name
     */
    @Override
    public void showFieldPolygon(List<Coordinates> latLngArrayList, LatLng latLng,String name) {
        PolygonOptions options = new PolygonOptions();
        for(int i=0;i<latLngArrayList.size();i++)
        {
            options.add( new LatLng(latLngArrayList.get(i).getLat(),latLngArrayList.get(i).getLng()));
        }


        options.fillColor( getResources()
                .getColor( R.color.colorPrimary ) );

        options.strokeColor( getResources()
                .getColor( R.color.colorAccent ) );
        options.strokeWidth( 10 );

        googleMap.addPolygon( options );

        CameraPosition position = CameraPosition.builder()
                .target(latLng)
                .zoom(14f)
                .bearing(0.0f)
                .tilt(0.0f)
                .build();

        googleMap.animateCamera(CameraUpdateFactory.newCameraPosition(position));


    }
}
