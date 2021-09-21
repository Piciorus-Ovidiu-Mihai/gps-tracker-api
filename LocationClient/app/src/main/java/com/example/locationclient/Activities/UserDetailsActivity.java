package com.example.locationclient.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.locationclient.R;

public class UserDetailsActivity extends AppCompatActivity {

    EditText editTextIdDetail,editTextFirstNameDetail,editTextLastNameDetail,editTextEmailDetail;
    Button buttonBack;
    private String baseUrl = "http://192.168.100.3:8080/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account);

        editTextIdDetail = findViewById(R.id.editTextIdDetail);
        editTextFirstNameDetail = findViewById(R.id.editTextFirstNameDetail);
        editTextLastNameDetail = findViewById(R.id.editTextLastNameDetail);
        editTextEmailDetail = findViewById(R.id.editTextEmailDetail);
        buttonBack = findViewById(R.id.buttonBack);

        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(UserDetailsActivity.this,UserLocationActivity.class);
                startActivity(intent);
            }
        });
    }
}