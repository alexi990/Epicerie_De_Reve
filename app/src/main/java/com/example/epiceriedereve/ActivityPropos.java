package com.example.epiceriedereve;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.epiceriedereve.databinding.ActivityProposBinding;

/**
 * ActiivtyPropos seulement un layout présentant une photo des épiciers (les créateurs de l'application)
 */
public class ActivityPropos extends AppCompatActivity {

    ActivityProposBinding binding;

    /**
     * Binding reliant ActivityPropos au layout activity_propos
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityProposBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
    }
}