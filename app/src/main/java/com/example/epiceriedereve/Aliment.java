package com.example.epiceriedereve;

public class Aliment {

    private int prix;
    private int quantité=0;
    private String nom;
    private String categorie;

    Aliment(String nnom,String ccategorie,int pprix, int qquantité)
    {
        nom=nnom;
        categorie=ccategorie;
        prix=pprix;
        quantité=qquantité;
    }

    public int getPrix() {
        return prix;
    }

    public int getQuantité() {
        return quantité;
    }

    public String getNom() {
        return nom;
    }

    public String getCategorie() {
        return categorie;
    }

    public void setPrix(int prix) {
        this.prix = prix;
    }

    public void setQuantité(int quantité) {
        this.quantité = quantité;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }
}
