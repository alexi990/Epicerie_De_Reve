package com.example.epiceriedereve;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class AlimentViewModel extends AndroidViewModel {

    AlimentRepository repository;

    public AlimentViewModel(@NonNull Application application) {
        super(application);
        repository = new AlimentRepository(application);
    }

    public LiveData<List<Aliment>> getData() { return repository.getAll();}

    public void addData(Aliment aliment) {repository.insert(new Aliment(aliment));}
}
