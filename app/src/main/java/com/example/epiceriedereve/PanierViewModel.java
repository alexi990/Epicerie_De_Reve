package com.example.epiceriedereve;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

import java.util.ArrayList;
import java.util.List;

public class PanierViewModel extends AndroidViewModel {

    public PanierViewModel(@NonNull Application application) {
        super(application);
    }

    public List<Aliment> getListPanier(){
        return Panier.panier;
    }

    public void ajouterItemPanier(Aliment aliment){Panier.panier.add(aliment);}
}
