package com.example.epiceriedereve;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.epiceriedereve.databinding.ActivityFin2Binding;
import com.example.epiceriedereve.databinding.ActivityFinBinding;

public class FinActivity extends AppCompatActivity {

    ActivityFin2Binding binding;
    float prixtotal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityFin2Binding.inflate(getLayoutInflater());
        prixtotal = Math.round(Float.parseFloat(getIntent().getStringExtra("total"))*114.975);
        prixtotal /= 100;
        binding.prixtotal.setText(String.valueOf(prixtotal));
        setContentView(binding.getRoot());
    }
}