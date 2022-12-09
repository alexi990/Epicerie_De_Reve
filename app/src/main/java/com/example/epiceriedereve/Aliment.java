package com.example.epiceriedereve;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Aliment {

    @PrimaryKey(autoGenerate = true)
    public int id;

    @ColumnInfo(name = "nom")
    public String nom;

    @ColumnInfo(name = "quantite")
    public int quantite;

    @ColumnInfo(name = "categorie")
    public String categorie;

    @ColumnInfo(name = "prix")
    public float prix;

    public Aliment(String name, String catego, int qte, float price) {
        this.id = 0;
        this.nom = name;
        this.categorie = catego;
        this.quantite = qte;
        this.prix = price;
    }

    public float getPrix() {
        return prix;
    }

    public int getQuantité() {
        return quantite;
    }

    public String getNom() {
        return nom;
    }

    public String getCategorie() {
        return categorie;
    }

    public void setPrix(float prix) {
        this.prix = prix;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }
}

