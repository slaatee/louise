package com.louise.osteo.model;

import javax.persistence.*;

@Entity
@Table(name="honoraire")
public class Honoraire {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="texte")
    private String texte;

    @Column(name="prix")
    private String prix;



    public Honoraire(){}
   public Honoraire( int id,String texte,String prix){
        this.id=id;
        this.texte=texte;
        this.prix=prix;
   }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPrix() {
        return prix;
    }

    public void setPrix(String prix) {
        this.prix = prix;
    }

    public String getTexte() {
        return texte;
    }

    public void setTexte(String texte) {
        this.texte = texte;
    }
}
