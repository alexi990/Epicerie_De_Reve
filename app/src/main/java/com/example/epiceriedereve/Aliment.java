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
    public String prix;

    public  Aliment()
    {

    }

    @ColumnInfo(name = "image")
    public int image;

    public Aliment(String name, String catego, int qte, String price, int img) {
        this.id = 0;
        this.nom = name;
        this.categorie = catego;
        this.quantite = qte;
        this.prix = price;
        this.image = img;
    }

    public Aliment(Aliment aliment)
    {
        this.id = 0;
        this.nom = aliment.nom;
        this.categorie = aliment.categorie;
        this.quantite = aliment.quantite;
        this.prix = aliment.prix;
        this.image = aliment.image;
    }

    public String getPrix() {
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

    public int getImage() {return image;}

    public void setPrix(String prix) {
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

    public void setImage(int image) {this.image = image;}
}

