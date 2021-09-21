package com.example.locationclient.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.locationclient.RESTfulAPI.API;
import com.example.locationclient.R;
import com.example.locationclient.ViewModels.UserRegisterViewModel;

import org.json.JSONObject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class UserRegisterActivity extends AppCompatActivity {

    private EditText editTextEmail, editTextFirstName, editTextLastName, editTextPassword, editTextConfirmPassword;
    private Button registerButton;
    private String baseUrl = "http://192.168.100.3:8080/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        editTextEmail = findViewById(R.id.editTextEmailRegister);
        editTextFirstName = findViewById(R.id.editTextFirstName);
        editTextLastName = findViewById(R.id.editTextLastName);
        editTextPassword = findViewById(R.id.editTextPasswordRegister);
        editTextConfirmPassword = findViewById(R.id.editTextConfirmPasswordRegister);
        registerButton = findViewById(R.id.buttonRegister);

        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = editTextEmail.getText().toString();
                String password = editTextPassword.getText().toString();
                String confirmPassword = editTextConfirmPassword.getText().toString();
                String firstName = editTextFirstName.getText().toString();
                String lastName = editTextLastName.getText().toString();

                Retrofit retrofit = new Retrofit.Builder()
                        .baseUrl(baseUrl)
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();
                API api = retrofit.create(API.class);
                UserRegisterViewModel userRegisterViewModel = new UserRegisterViewModel(email, password, confirmPassword, firstName, lastName);
                Call<UserRegisterViewModel> call = api.Register(userRegisterViewModel);

                call.enqueue(new Callback<UserRegisterViewModel>() {
                    @Override
                    public void onResponse(Call<UserRegisterViewModel> call, Response<UserRegisterViewModel> response) {
                        if (!response.isSuccessful()) {
                            try {
                                String errorData = response.errorBody().string();
                                JSONObject jsonObjectError = new JSONObject(errorData);
                                Toast.makeText(UserRegisterActivity.this, response.code() + " : " + jsonObjectError.getString("message"), Toast.LENGTH_SHORT).show();
                            } catch (Exception e) {
                                Toast.makeText(UserRegisterActivity.this, e.getMessage(), Toast.LENGTH_LONG).show();
                            }
                            return;
                        }
                    }

                    @Override
                    public void onFailure(Call<UserRegisterViewModel> call, Throwable t) {
                        Toast.makeText(UserRegisterActivity.this, "Code: " + t.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
    }
}