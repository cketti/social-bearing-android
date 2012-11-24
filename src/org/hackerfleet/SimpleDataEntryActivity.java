package org.hackerfleet;

import com.actionbarsherlock.app.SherlockActivity;

import android.app.Activity;
import android.content.Context;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;

/**
 * @author flashmop
 * @date 24.11.12 09:49
 */
public class SimpleDataEntryActivity extends SherlockActivity {
  private final static String TAG = SimpleDataEntryActivity.class.getSimpleName();

  LocationManager locationManager;
  EditText        lat;
  EditText        lon;
  EditText        acc;

  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.simple_data_entry);
    getSupportActionBar().setTitle("Corellian Engineering Corporation");

    locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);

    lat = (EditText) findViewById(R.id.gps_lat);
    lon = (EditText) findViewById(R.id.gps_lon);
    acc = (EditText) findViewById(R.id.gps_acc);

  }

  @Override
  public void onResume() {
    super.onResume();

    Location lastLocation = locationManager.getLastKnownLocation("GPS");
    Log.d(TAG, "lastLocation: " + lastLocation);

    if (lastLocation != null) {
      lat.setText("" + lastLocation.getLatitude());
      lon.setText("" + lastLocation.getLongitude());
      acc.setText("" + lastLocation.getAccuracy());
    }

  }
}