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

    public LiveData<List<Aliment>> getAll() {

        if (data.getValue() == null || data.getValue().size() == 0) {
            Aliment aliments[] = new Aliment[]{
                    new Aliment("Aéro", "Cochonnerie", 0, "2.00", R.drawable.aero),
                    new Aliment("12 Ailes de Poulet", "Viande", 0, "17.00", R.drawable.aile),
                    new Aliment("Sachet d'amandes", "Autre", 0, "5.00", R.drawable.amende),
                    new Aliment("Tranche De Bacon", "Viande", 0, "3.00", R.drawable.bacon),
                    new Aliment("Tranche De Baloney", "Viande", 0, "1.00", R.drawable.baloney),
                    new Aliment("Banane", "Fruits et Legumes", 0, "1.00", R.drawable.banane),
                    new Aliment("Tranche De Boeuf", "Viande", 0, "5.00", R.drawable.boeuf),
                    new Aliment("1 Craquelin", "Autre", 0, "1.00", R.drawable.craquelin),
                    new Aliment("Sac de Doritos", "Cochonnerie", 0, "2.00", R.drawable.doritos),
                    new Aliment("Fruit de la passion", "Fruits et Legumes", 0, "3.00", R.drawable.fruitpassion),
                    new Aliment("Cuisse de grenouille", "Viande", 0, "10.00", R.drawable.grenouille),
                    new Aliment("KitKat", "Cochonnerie", 0, "3.00", R.drawable.kitkat),
                    new Aliment("Pinte de lait", "Autre", 0, "7.00", R.drawable.lait),
                    new Aliment("Melon d'eau", "Fruits et Legumes", 0, "6.00", R.drawable.melondeau),
                    new Aliment("Oeuf", "Autre", 0, "4.00", R.drawable.oeuf),
                    new Aliment("Pain", "Autre", 0, "8.00", R.drawable.pain),
                    new Aliment("Pomme", "Fruits et Legumes", 0, "3.00", R.drawable.pomme),
                    new Aliment("Sac de Skittle", "Cochonnerie", 0, "2.00", R.drawable.skittle),
                    new Aliment("Boite de Smarties", "Cochonnerie", 0, "3.00", R.drawable.smarties),
                    new Aliment("Tomate", "Fruits et Legumes", 0, "4.00", R.drawable.tomato)
            };

            for (int i=0;i<aliments.length;i++)
            {
                insert(aliments[i]);
            }


        }
            return data;
    }

    public void insert(Aliment aliment) {
        Executors.newSingleThreadExecutor().execute(() -> {
            alimentDao.insert(aliment);
        });

    }







}
