package com.example.epiceriedereve;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

import java.util.List;

/**
 * PanierViewModel pour gérer les aliments qui sont dans le panier
 */
public class PanierViewModel extends AndroidViewModel {

    /**
     * Constructeur du ViewModel
     * @param application
     */
    public PanierViewModel(@NonNull Application application) {
        super(application);
    }

    /**
     * Pour obtenir la liste de tous les aliments dans le panier
     * @return
     */
    public List<Aliment> getListPanier(){
        return Panier.panier;
    }

    /**
     * Pour ajouter un aliment dans le panier de l'utilisateur
     * @param aliment
     */
    public void ajouterItemPanier(Aliment aliment){Panier.panier.add(aliment);}
}
