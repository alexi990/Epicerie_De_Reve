package com.example.epiceriedereve;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.epiceriedereve.databinding.ActivityPlainteBinding;

public class PlainteActivity extends AppCompatActivity {

    ActivityPlainteBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityPlainteBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
    }
}