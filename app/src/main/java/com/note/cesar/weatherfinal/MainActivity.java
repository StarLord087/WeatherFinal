package com.note.cesar.weatherfinal;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.note.cesar.weatherfinal.api.ApiClient;
import com.note.cesar.weatherfinal.model.CurrentConditionModel;
import com.note.cesar.weatherfinal.model.GeoPositionModel;


import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.Manifest.permission.ACCESS_COARSE_LOCATION;
import static android.Manifest.permission.ACCESS_FINE_LOCATION;

public class MainActivity extends AppCompatActivity implements LocationListener {

    public static final String TAG = "LOCATION";
    public static final String API_KEY = "oz0KFHSiSi0GtZnx6nR67AADDBRAqot6";
    String locKey = "";
    Double weth = 0.0;
    LocationManager locationManager;
    TextView tvCity,tvTemp, tvKey;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        progressBar = findViewById(R.id.pb_mainActivty);
        tvCity = findViewById(R.id.tv_cityName);
        tvTemp = findViewById(R.id.tv_Temp);
        tvKey = findViewById(R.id.tv_Key);

        progressBar.setIndeterminate(true);

        if (ContextCompat.checkSelfPermission(this, ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED ||
                ContextCompat.checkSelfPermission(this, ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {

            ActivityCompat.requestPermissions(this,
                    new String[]{
                    Manifest.permission.ACCESS_FINE_LOCATION,
                    Manifest.permission.ACCESS_COARSE_LOCATION},
                    111);
        }

        else {
            startLocUpates();
        }


    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {

        if (requestCode == 111) {
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED && grantResults[1] == PackageManager.PERMISSION_GRANTED) {
                startLocUpates();
            }
        }
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }

    @SuppressLint("MissingPermission")
    public void startLocUpates() {
        locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 1000, 100f, this);
    }

    @Override
    public void onLocationChanged(Location location) {
        Log.d(TAG, "latitude = " + location.getLatitude());
        Log.d(TAG, "longitude = " + location.getLongitude());
        Log.d(TAG, " = = = = = = = = = = = = = = =  ");


        String latLong = location.getLatitude() + "," + location.getLongitude();
        Toast.makeText(this, "" + latLong, Toast.LENGTH_SHORT).show();
        getCurrentConditions(latLong);

    }

    @Override
    public void onStatusChanged(String s, int i, Bundle bundle) {

    }

    @Override
    public void onProviderEnabled(String s) {

    }

    @Override
    public void onProviderDisabled(String s) {

    }

    public void getCurrentConditions(String latLong) {

        Call<GeoPositionModel> call = ApiClient.getClient().getKey(API_KEY, latLong);
        call.enqueue(new Callback<GeoPositionModel>() {
            @Override
            public void onResponse(Call<GeoPositionModel> call, Response<GeoPositionModel> response) {
                tvCity.setText(response.body().getLocalizedName());
                tvKey.setText(response.body().getKey());
            }

            @Override
            public void onFailure(Call<GeoPositionModel> call, Throwable t) {

            }
        });

        Call<List<CurrentConditionModel.Temperature>> temperatureCall = ApiClient.getClient().getWeather(locKey,API_KEY);
        temperatureCall.enqueue(new Callback<List<CurrentConditionModel.Temperature>>() {
            @Override
            public void onResponse(Call<List<CurrentConditionModel.Temperature>> call, Response<List<CurrentConditionModel.Temperature>> response) {
                CurrentConditionModel.Temperature temperature = (CurrentConditionModel.Temperature) response.body();
                Log.d(TAG, "onResponse: "+ temperature);
            }

            @Override
            public void onFailure(Call<List<CurrentConditionModel.Temperature>> call, Throwable t) {

            }
        });

    }
}
