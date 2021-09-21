package com.example.locationclient.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.locationclient.RESTfulAPI.API;
import com.example.locationclient.ViewModels.UserLoginViewModel;
import com.example.locationclient.R;

import org.json.JSONObject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class UserLoginActivity extends AppCompatActivity {

    private EditText editTextEmail, editTextPassword;
    private Button loginButton, registerButton;
    private String baseUrl = "http://192.168.100.3:8080/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextEmail = findViewById(R.id.editTextEmail);
        editTextPassword = findViewById(R.id.editTextPassword);
        loginButton = findViewById(R.id.buttonLogin);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Retrofit retrofit = new Retrofit.Builder()
                        .baseUrl(baseUrl)
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();

                String email = editTextEmail.getText().toString();
                String password = editTextPassword.getText().toString();

                API api = retrofit.create(API.class);
                UserLoginViewModel userLoginViewModel = new UserLoginViewModel(email, password);
                Call<UserLoginViewModel> call = api.Login(userLoginViewModel);

                call.enqueue(new Callback<UserLoginViewModel>() {
                    @Override
                    public void onResponse(Call<UserLoginViewModel> call, Response<UserLoginViewModel> response) {
                        if (!response.isSuccessful()) {
                            try {
                                String errorData = response.errorBody().string();
                                JSONObject jsonObjectError = new JSONObject(errorData);
                                Toast.makeText(UserLoginActivity.this, response.code() + " : " + jsonObjectError.getString("message"), Toast.LENGTH_SHORT).show();

                            } catch (Exception e) {
                                Toast.makeText(UserLoginActivity.this, e.getMessage(), Toast.LENGTH_LONG).show();
                            }
                            return;
                        }


                        Intent intent = new Intent(UserLoginActivity.this,UserLocationActivity.class);
                        intent.putExtra("email",email);
                        intent.putExtra("password",password);
                        startActivity(intent);

                    }
                    @Override
                    public void onFailure(Call<UserLoginViewModel> call, Throwable t) {
                        Toast.makeText(UserLoginActivity.this, "Code: " + t.getMessage(), Toast.LENGTH_SHORT).show();

                    }
                });

            }
        });

        registerButton = findViewById(R.id.buttonRegister);

        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(UserLoginActivity.this, UserRegisterActivity.class);
                startActivity(intent);
            }
        });
    }
}