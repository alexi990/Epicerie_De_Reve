package com.example.epiceriedereve;

import android.app.Application;

import androidx.lifecycle.LiveData;

import java.util.List;
import java.util.concurrent.Executors;

/**
 * Lien entre la base de données et l'épicerie.
 */
public class AlimentRepository {

    private AlimentDao alimentDao;
    private LiveData<List<Aliment>> data;

    /**
     * Permet l'accès et l'interaction avec la base de données.
     * @param application
     */
    public AlimentRepository(Application application) {
        AlimentDataBase database = AlimentDataBase.getDatabase(application);
        alimentDao = database.alimentDao();
        data = alimentDao.getAll();
    }

    /**
     * Pour obtenir tous les aliments présents dans la base de données.
     * @return
     */
    public LiveData<List<Aliment>> getAll() {
        return data;
    }

    /**
     * Permet d'ajouter un aliment dans le base de données.
     * @param aliment
     */
    public void insert(Aliment aliment) {
        Executors.newSingleThreadExecutor().execute(() -> {
            alimentDao.insert(aliment);
        });

    }

    /**
     * Ajout de tous les aliments dans le base de données.
     */
    public void ajoutAliment() {
        Aliment aliments[] = new Aliment[]{
                new Aliment("Aéro", "Cochonnerie", 1, "2.00", R.drawable.aero),
                new Aliment("12 Ailes de Poulet", "Viande", 1, "17.00", R.drawable.aile),
                new Aliment("Sachet d'amandes", "Autre", 1, "5.00", R.drawable.amende),
                new Aliment("Tranche De Bacon", "Viande", 1, "3.00", R.drawable.bacon),
                new Aliment("Tranche De Baloney", "Viande", 1, "1.00", R.drawable.baloney),
                new Aliment("Banane", "Fruits et Legumes", 1, "1.00", R.drawable.banane),
                new Aliment("Tranche De Boeuf", "Viande", 1, "5.00", R.drawable.boeuf),
                new Aliment("1 Craquelin", "Autre", 1, "1.00", R.drawable.craquelin),
                new Aliment("Sac de Doritos", "Cochonnerie", 1, "2.00", R.drawable.doritos),
                new Aliment("Fruit de la passion", "Fruits et Legumes", 1, "3.00", R.drawable.fruitpassion),
                new Aliment("Cuisse de grenouille", "Viande", 1, "10.00", R.drawable.grenouille),
                new Aliment("KitKat", "Cochonnerie", 1, "3.00", R.drawable.kitkat),
                new Aliment("Pinte de lait", "Autre", 1, "7.00", R.drawable.lait),
                new Aliment("Melon d'eau", "Fruits et Legumes", 1, "6.00", R.drawable.melondeau),
                new Aliment("Oeuf", "Autre", 1, "4.00", R.drawable.oeuf),
                new Aliment("Pain", "Autre", 1, "8.00", R.drawable.pain),
                new Aliment("Pomme", "Fruits et Legumes", 1, "3.00", R.drawable.pomme),
                new Aliment("Sac de Skittle", "Cochonnerie", 1, "2.00", R.drawable.skittle),
                new Aliment("Boite de Smarties", "Cochonnerie", 1, "3.00", R.drawable.smarties),
                new Aliment("Tomate", "Fruits et Legumes", 1, "4.00", R.drawable.tomato)
        };

        for (int i=0;i<aliments.length;i++)
        {
            insert(aliments[i]);
        }
    }







}
