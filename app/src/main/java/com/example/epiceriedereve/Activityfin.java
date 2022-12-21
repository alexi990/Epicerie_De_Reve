package com.example.epiceriedereve;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import com.example.epiceriedereve.databinding.ActivityFinBinding;

public class Activityfin extends AppCompatActivity {

    ActivityFinBinding binding;
    private String prixfinal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
     super.onCreate(savedInstanceState);
     binding = ActivityFinBinding.inflate(getLayoutInflater());
     setContentView(binding.getRoot());

     //prixfinal = getIntent().getStringExtra("total");
     //binding.prixfinal.setText(prixfinal);
    }
}