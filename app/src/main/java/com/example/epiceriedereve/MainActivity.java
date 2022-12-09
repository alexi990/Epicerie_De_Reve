package com.example.epiceriedereve;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.example.epiceriedereve.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.btncommencer.setOnClickListener(view-> {
            Intent intent = new Intent(this, EpicerieActivity.class);
            startActivity(intent);
        });

        binding.btnapropos.setOnClickListener(view-> {
            Intent intent = new Intent(this, ActivityPropos.class);
            startActivity(intent);
        });

        binding.btnplainte.setOnClickListener(view -> {
            Intent intent = new Intent(this, PlainteActivity.class);
            startActivity(intent);
        });

        binding.btnquitter.setOnClickListener(view-> {
            this.finish();
        });
    }
}