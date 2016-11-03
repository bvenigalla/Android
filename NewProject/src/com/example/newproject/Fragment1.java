package com.example.newproject;

import java.util.ArrayList;
import java.util.List;

import android.app.Fragment;
import android.content.Context;
import android.location.Address;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class Fragment1 extends Fragment implements LocationListener {
	GoogleMap googleMap;
	MapView mMapView;
	Context context;
	LocationManager locationManager;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		View view = inflater.inflate(R.layout.fragment1, container, false);
		mMapView = (MapView) view.findViewById(R.id.googlemap);
		mMapView.onCreate(savedInstanceState);

		mMapView.onResume(); // needed to get the map to display immediately

		try {
			MapsInitializer.initialize(getActivity().getApplicationContext());
		} catch (Exception e) {
			e.printStackTrace();
		}

		mMapView.getMapAsync(new OnMapReadyCallback() {
			@Override
			public void onMapReady(GoogleMap mMap) {
				googleMap = mMap;

				// For showing a move to my location button
				googleMap.setMyLocationEnabled(true);
				googleMap.addMarker(new MarkerOptions().position(new LatLng(
						16.5062, 80.6480)));
				googleMap.addMarker(new MarkerOptions().position(new LatLng(
						16.3067, 80.4365)));
				googleMap.addMarker(new MarkerOptions().position(new LatLng(
						16.7725, 80.2859)));
				googleMap.addMarker(new MarkerOptions().position(new LatLng(
						16.6209, 80.5413)));
				googleMap.addMarker(new MarkerOptions().position(new LatLng(
						16.5730, 80.3575)));
				currentlocation();

			}
		});

		return view;

	}

	private void currentlocation() {

		LocationManager locationmanager = (LocationManager) getActivity()
				.getSystemService(Context.LOCATION_SERVICE);
		Criteria criteria = new Criteria();

		// Getting the name of the best provider
		String provider = locationmanager.getBestProvider(criteria, true);

		// Getting Current Location
		Location location = locationmanager.getLastKnownLocation(provider);

		if (location != null) {
			onLocationChanged(location);
		}
		locationmanager.requestLocationUpdates(provider, 20000, 0, this);

	}

	@Override
	public void onLocationChanged(Location location) {

		double latitude = location.getLatitude();
		double longitude = location.getLongitude();
		System.out.println("lattttttlonggggggggggg" + latitude + longitude);
		LatLng latLng = new LatLng(latitude, longitude);
		googleMap.addMarker(new MarkerOptions().position(latLng));
		googleMap.moveCamera(CameraUpdateFactory.newLatLng(latLng));
		googleMap.animateCamera(CameraUpdateFactory.zoomTo(9));

	}

	@Override
	public void onStatusChanged(String provider, int status, Bundle extras) {

	}

	@Override
	public void onProviderEnabled(String provider) {

	}

	@Override
	public void onProviderDisabled(String provider) {

	}

	private boolean isGooglePlayServicesAvailable() {
		int status = GooglePlayServicesUtil
				.isGooglePlayServicesAvailable(getContext());
		if (ConnectionResult.SUCCESS == status) {
			return true;
		} else {
			GooglePlayServicesUtil.getErrorDialog(status, getActivity(), 0)
					.show();
			return false;
		}
	}

}
