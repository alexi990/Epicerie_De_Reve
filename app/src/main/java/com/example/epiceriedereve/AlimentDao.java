package com.example.epiceriedereve;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

/**
 * Permet l'accès à la base de données.
 */
@Dao
public interface AlimentDao {

    /**
     * Pour accéder à tous les données en retournant la liste contenant tous les objets.
     * @return
     */
    @Query("SELECT * from aliment")
    LiveData<List<Aliment>> getAll();

    /**
     * Pour insérer un objet (aliment) dans la base de données.
     * @param aliments
     */
    @Insert
    void insert(Aliment... aliments);
}
