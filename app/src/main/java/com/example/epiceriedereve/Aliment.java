package com.example.epiceriedereve;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;

/**
 * Aliment ayant un nom, une quantité, une catégorie, un prix et une image.
 */
@Entity
public class Aliment implements Serializable {

    /**
     * Id de l'aliment pour la base de données
     */
    @PrimaryKey(autoGenerate = true)
    public int id;

    /**
     * Nom de l'aliment dans la base de données
     */
    @ColumnInfo(name = "nom")
    public String nom;

    /**
     * Quantité de l'aliment dans la base de données
     */
    @ColumnInfo(name = "quantite")
    public int quantite;

    /**
     * Catégorie de l'aliment dans la base de données (pas utilisée finalement)
     */
    @ColumnInfo(name = "categorie")
    public String categorie;

    /**
     * Prix de l'aliment dans la base de données
     */
    @ColumnInfo(name = "prix")
    public String prix;

    /**
     * Image de l'aliment dans la base de données
     */
    @ColumnInfo(name = "image")
    public int image;

    /**
     * Constructeur vide de l'objet ALiment
     */
    public  Aliment()
    {

    }

    /**
     * Constructuer de l'objet Aliment lui attribuant un nom, une quantité, une catégorie, un prix et une image.
     * @param name
     * @param catego
     * @param qte
     * @param price
     * @param img
     */
    public Aliment(String name, String catego, int qte, String price, int img) {
        this.id = 0;
        this.nom = name;
        this.categorie = catego;
        this.quantite = qte;
        this.prix = price;
        this.image = img;
    }

    /**
     * Constructeur de l'objet Aliment à partir des attributs d'un autre aliment.
     * @param aliment
     */
    public Aliment(Aliment aliment)
    {
        this.id = 0;
        this.nom = aliment.nom;
        this.categorie = aliment.categorie;
        this.quantite = aliment.quantite;
        this.prix = aliment.prix;
        this.image = aliment.image;
    }

    /**
     *
     * @return prix de l'aliment
     */
    public String getPrix() {
        return prix;
    }

    /**
     *
     * @return la quantité de l'aliment
     */
    public int getQuantite() {
        return quantite;
    }

    /**
     *
     * @return le nom de l'aliment
     */
    public String getNom() {
        return nom;
    }

    /**
     *
     * @return la catégrie de l'aliment
     */
    public String getCategorie() {
        return categorie;
    }

    /**
     *
     * @return l'image de l'aliment
     */
    public int getImage() {return image;}

    public void setPrix(String prix) {
        this.prix = prix;
    }

    /**
     * Permet d'ajuster la quantité d'un aliment
     * @param quantite
     */
    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    /**
     * Permet de modifier le nom d'un aliment
     * @param nom
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * Permet de modifier la catégorie d'un aliment
     * @param categorie
     */
    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

    /**
     * Permet de modifier l'image attribuée à un aliment
     * @param image
     */
    public void setImage(int image) {this.image = image;}
}

