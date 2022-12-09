package com.example.epiceriedereve;

import android.app.Application;

import androidx.lifecycle.LiveData;

import java.util.List;
import java.util.concurrent.Executors;

public class AlimentRepository {

    private AlimentDao alimentDao;
    private LiveData<List<Aliment>> data;

    public AlimentRepository(Application application) {
        AlimentDataBase database = AlimentDataBase.getDatabase(application);
        alimentDao = database.alimentDao();
        data = alimentDao.getAll();
    }

    public LiveData<List<Aliment>> getAll() {return data;}

    public void insert(Aliment aliment) {
        Executors.newSingleThreadExecutor().execute(() -> {
            alimentDao.insert(aliment);
        });
    }
}
