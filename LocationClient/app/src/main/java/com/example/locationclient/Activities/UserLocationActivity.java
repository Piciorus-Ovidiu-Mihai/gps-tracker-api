package com.example.locationclient.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.content.Intent;

import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.locationclient.R;
import com.example.locationclient.RESTfulAPI.API;
import com.example.locationclient.RESTfulAPI.UserBasicAuth;
import com.example.locationclient.Services.UserLocationService;
import com.example.locationclient.ViewModels.UserLocationViewModel;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class UserLocationActivity extends AppCompatActivity {

    Button buttonAccount, buttonSendLocation, buttonSendAutoLocation, buttonStop;
    UserLocationService userLocationService;
    Runnable mToastRunnable;
    protected int delay = 6000;
    boolean ok = false;
    Handler mHandler = new Handler();
    protected String latitude;
    protected String longitude;
    private String baseUrl = "http://192.168.100.3:8080/";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_location);

        buttonAccount = findViewById(R.id.buttonAccountDetails);
        buttonSendLocation = findViewById(R.id.buttonSendLocation);
        buttonSendAutoLocation = findViewById(R.id.buttonAutoLocation);
        buttonStop = findViewById(R.id.buttonStop);

        try {
            if (ContextCompat.checkSelfPermission(getApplicationContext(), android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(this, new String[]{android.Manifest.permission.ACCESS_FINE_LOCATION}, 101);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        buttonAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(UserLocationActivity.this, UserDetailsActivity.class);
                startActivity(intent);
            }
        });

        buttonSendLocation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getLocation();
            }
        });

        buttonSendAutoLocation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ok = false;
                mHandler.postDelayed(mToastRunnable = new Runnable() {
                    @Override
                    public void run() {
                        if(ok == false) {
                            mHandler.postDelayed(mToastRunnable, delay);
                            getLocation();
                        }
                    }
                }, delay);
            }
        });

        buttonStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ok = true;
            }
        });

    }

    public void getLocation() {
        userLocationService = new UserLocationService(UserLocationActivity.this);

        Intent intent = getIntent();
        String email = intent.getStringExtra("email");
        String password = intent.getStringExtra("password");

        if (userLocationService.canGetLocation()) {
            latitude = String.valueOf(userLocationService.getLatitude());
            longitude = String.valueOf(userLocationService.getLongitude());
        }

        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .addInterceptor(new UserBasicAuth(email, password))
                .build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient)
                .build();

        API api = retrofit.create(API.class);
        UserLocationViewModel userLocationViewModel = new UserLocationViewModel(email, longitude, latitude);
        Call<UserLocationViewModel> call = api.CreateLocation(userLocationViewModel);

        call.enqueue(new Callback<UserLocationViewModel>() {
            @Override
            public void onResponse(Call<UserLocationViewModel> call, Response<UserLocationViewModel> response) {
                try {
                    String errorData = response.errorBody().string();
                    JSONObject jsonObjectError = new JSONObject(errorData);
                    Toast.makeText(UserLocationActivity.this, response.code() + " : " + jsonObjectError.getString("message"), Toast.LENGTH_SHORT).show();
                } catch (JSONException | IOException e) {
                    Toast.makeText(UserLocationActivity.this, e.getMessage(), Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<UserLocationViewModel> call, Throwable t) {
                Toast.makeText(UserLocationActivity.this, t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
    }
}