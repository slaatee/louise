package com.louise.osteo.model;

import javax.persistence.*;

@Entity
@Table(name="categorie")
public class Categorie {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;


    @Column(name="nom")
    private String nom;

    @Column(name="texte")
    private String texte;

    public Categorie(){}
    public Categorie(int id,String nom,String texte){
        this.id=id;
        this.nom=nom;
        this.texte=texte;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getTexte() {
        return texte;
    }

    public void setTexte(String texte) {
        this.texte = texte;
    }
}
