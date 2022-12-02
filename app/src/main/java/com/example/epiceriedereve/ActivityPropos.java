package com.example.epiceriedereve;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.epiceriedereve.databinding.ActivityProposBinding;

public class ActivityPropos extends AppCompatActivity {

    ActivityProposBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityProposBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
    }
}