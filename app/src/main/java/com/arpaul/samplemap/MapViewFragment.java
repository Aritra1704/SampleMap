package com.arpaul.samplemap;

import android.content.pm.PackageManager;
import android.content.res.AssetManager;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.MarkerOptions;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by Aritra Ranjan on 5/3/2017.
 */

public class MapViewFragment extends Fragment implements OnMapReadyCallback {
    MapView mapView;
    GoogleMap googleMap;
    public MapViewFragment() {
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frag_mapview, container, false);
        getActivity().setTitle("Contact Us");
        mapView = (MapView) view.findViewById(R.id.map);
        mapView.onCreate(savedInstanceState);
        if(mapView != null)
            mapView.getMapAsync(this);
//        if (mapView != null) {
//            googleMap = mapView.getMap();
//            googleMap.addMarker(new MarkerOptions()
//                    .icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_launcher_round))
//                    .anchor(0.0f, 1.0f)
//                    .position(new LatLng(55.854049, 13.661331)));
//            googleMap.getUiSettings().setMyLocationButtonEnabled(false);
//            if (ActivityCompat.checkSelfPermission(getActivity(), android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(getActivity(), android.Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
//                return view;
//            }
//            googleMap.setMyLocationEnabled(true);
//            googleMap.getUiSettings().setZoomControlsEnabled(true);
//            MapsInitializer.initialize(this.getActivity());
//            LatLngBounds.Builder builder = new LatLngBounds.Builder();
//            builder.include(new LatLng(55.854049, 13.661331));
//            LatLngBounds bounds = builder.build();
//            int padding = 0;
//            // Updates the location and zoom of the MapView
//            CameraUpdate cameraUpdate = CameraUpdateFactory.newLatLngBounds(bounds, padding);
//            googleMap.moveCamera(cameraUpdate);
//        }
        return view;
    }
    @Override
    public void onResume() {
        mapView.onResume();
        super.onResume();
    }

    @Override
    public void onMapReady(GoogleMap googleMap1) {
        if (googleMap1 != null) {
            googleMap = googleMap1;
            googleMap.addMarker(new MarkerOptions()
                    .icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_launcher_round))
                    .anchor(0.0f, 1.0f)
                    .position(new LatLng(17.452406, 78.390678)));
            googleMap.getUiSettings().setMyLocationButtonEnabled(false);
            if (ActivityCompat.checkSelfPermission(getActivity(), android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED
                    && ActivityCompat.checkSelfPermission(getActivity(), android.Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                return;
            } else {
                googleMap.setMyLocationEnabled(true);
                googleMap.getUiSettings().setZoomControlsEnabled(true);
                MapsInitializer.initialize(this.getActivity());
                LatLngBounds.Builder builder = new LatLngBounds.Builder();
                builder.include(new LatLng(17.452406, 78.390678));
                LatLngBounds bounds = builder.build();
                int padding = 0;
                // Updates the location and zoom of the MapView
                CameraUpdate cameraUpdate = CameraUpdateFactory.newLatLngBounds(bounds, padding);
                googleMap.moveCamera(cameraUpdate);
            }
        }
    }

    @Override
    public void onPause() {
        super.onPause();
        mapView.onPause();
    }
    @Override
    public void onDestroy() {
        super.onDestroy();
        mapView.onDestroy();
    }
    @Override
    public void onLowMemory() {
        super.onLowMemory();
        mapView.onLowMemory();
    }
}
