package com.marvelwall.ahmedpc.icu.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;

import com.marvelwall.ahmedpc.icu.R;

public class Main extends AppCompatActivity {

    RelativeLayout patient,doctor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        patient= findViewById(R.id.patient);
        doctor = findViewById(R.id.doctor);

        patient.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Main.this,Login.class));
            }
        });

        doctor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Main.this,LoginDoctor.class));

            }
        });
    }
}
