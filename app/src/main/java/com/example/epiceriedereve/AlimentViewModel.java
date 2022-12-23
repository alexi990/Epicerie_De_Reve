package com.example.epiceriedereve;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

/**
 * AlimentViewModel pour accéder à la base de données.
 */
public class AlimentViewModel extends AndroidViewModel {

    AlimentRepository repository;

    /**
     * Constructeur du ViewModel
     * @param application
     */
    public AlimentViewModel(@NonNull Application application) {
        super(application);
        repository = new AlimentRepository(application);
    }

    /**
     * LiveData pour tous les aliments.
     * @return
     */
    public LiveData<List<Aliment>> getData() { return repository.getAll();}
}
