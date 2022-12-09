package com.example.epiceriedereve;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface AlimentDao {

    @Query("SELECT * from aliment")
    LiveData<List<Aliment>> getAll();

    @Query("SELECT * from aliment where categorie =:categorie")
    LiveData<List<Aliment>> getCategorie(String categorie);

    @Insert
    void insert(Aliment... aliments);
}
