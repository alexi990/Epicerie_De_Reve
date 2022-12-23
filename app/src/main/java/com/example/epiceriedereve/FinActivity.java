package com.example.epiceriedereve;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.epiceriedereve.databinding.ActivityFin2Binding;

public class FinActivity extends AppCompatActivity {

    ActivityFin2Binding binding;
    float prixtotal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityFin2Binding.inflate(getLayoutInflater());
        prixtotal = Math.round(Float.parseFloat(getIntent().getStringExtra("total"))*114.975);
        prixtotal /= 100;
        if (String.valueOf(prixtotal).length() < 4)
        {
            binding.prixtotal.setText(prixtotal + "0 $");
        }
        else
        {
            binding.prixtotal.setText(prixtotal + " $");
        }
        setContentView(binding.getRoot());
    }
}