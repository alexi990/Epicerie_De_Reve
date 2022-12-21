package com.example.epiceriedereve;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.epiceriedereve.databinding.ActivityFin2Binding;
import com.example.epiceriedereve.databinding.ActivityFinBinding;

public class FinActivity extends AppCompatActivity {

    ActivityFin2Binding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityFin2Binding.inflate(getLayoutInflater());
        binding.prixtotal.setText(getIntent().getStringExtra("total"));
        setContentView(binding.getRoot());
    }
}