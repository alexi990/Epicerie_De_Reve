package com.example.epiceriedereve;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.epiceriedereve.databinding.ActivityPlainteBinding;

/**
 * La PlainteActivity ne fait rien de particulier. Elle peut être ouverte à partir de la MainActivity.
 * Son layout contient seulement qu'une image.
 */
public class PlainteActivity extends AppCompatActivity {

    ActivityPlainteBinding binding;

    /**
     * onCreate de la PlainteAcivity.  Binding qui relie au layout acitivty_plainte.
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityPlainteBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
    }
}