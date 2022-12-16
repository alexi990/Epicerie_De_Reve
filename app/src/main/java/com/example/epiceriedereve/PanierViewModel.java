package com.example.epiceriedereve;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

import java.util.ArrayList;

public class PanierViewModel extends AndroidViewModel {

    ArrayList<Aliment> aliment = new ArrayList<>();

    public PanierViewModel(@NonNull Application application) {
        super(application);
    }


}
