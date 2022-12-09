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

        if(data.equals(null)){
            Aliment a1= new Aliment("Aero","Cochonnerie",0,"2.00$", R.drawable.aero);
            Aliment a2= new Aliment("12 Ailes de Poulet","Viande",0,"17.00$",R.drawable.aile);
            Aliment a3= new Aliment("Sachet damandes","Autre",0,"5.00$",R.drawable.amende);
            Aliment a4= new Aliment("Tranche De Bacon","Viande",0,"3.00$",R.drawable.bacon);
            Aliment a5= new Aliment("Tranche De Baloney","Viande",0,"1.00$",R.drawable.baloney);
            Aliment a6= new Aliment("Banane","Fruits et Legumes",0,"1.00$",R.drawable.banane);
            Aliment a7= new Aliment("Tranche De Boeuf","Viande",0,"5.00$",R.drawable.boeuf);
            Aliment a8= new Aliment("1 Craquelin","Autre",0,"1.00$",R.drawable.craquelin);
            Aliment a9= new Aliment("Sac de Doritos","Cochonnerie",0,"2.00$",R.drawable.doritos);
            Aliment a10= new Aliment("Fruit de la passion","Fruits et Legumes",0,"3.00$",R.drawable.fruitpassion);
            Aliment a11= new Aliment("Cuisse de grenouille","Viande",0,"10.00$",R.drawable.grenouille);
            Aliment a12= new Aliment("KitKat","Cochonnerie",0,"3.00$",R.drawable.kitkat);
            Aliment a13= new Aliment("Pinte de lait","Autre",0,"7.00$",R.drawable.lait);
            Aliment a14= new Aliment("Melon deau","Fruits et Legumes",0,"6.00$",R.drawable.melondeau);
            Aliment a15= new Aliment("Oeuf","Autre",0,"4.00$",R.drawable.oeuf);
            Aliment a16= new Aliment("Pain","Autre",0,"8.00$",R.drawable.pain);
            Aliment a17= new Aliment("Pomme","Fruits et Legumes",0,"3.00$",R.drawable.pomme);
            Aliment a18= new Aliment("Sac de Skittle","Cochonnerie",0,"2.00$",R.drawable.skittle);
            Aliment a19= new Aliment("Boite de Smarties","Cochonnerie",0,"3.00$",R.drawable.smarties);
            Aliment a20= new Aliment("Tomate","Fruits et Legumes",0,"4.00$",R.drawable.tomato);

            insert();
        }



        return data;}

    public void insert(Aliment aliment) {
        Executors.newSingleThreadExecutor().execute(() -> {
            alimentDao.insert(aliment);
        });
    }







}
