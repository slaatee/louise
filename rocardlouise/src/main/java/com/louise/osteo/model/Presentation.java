package com.louise.osteo.model;

import javax.persistence.*;

@Entity
@Table(name="presentation")
public class Presentation {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="titre")
    private String titre;

    @Column(name="soustitre")
    private String soustitre;

    @Column(name="texte")
    private String texte;

    @Column(name="photo")
    private String photo;



    public Presentation(){}

    public Presentation(int id, String titre,String soustitre,String texte, String photo){
        this.id=id;
        this.titre=titre;
        this.soustitre=soustitre;
        this.texte=texte;
        this.photo=photo;
  }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getSoustitre() {
        return soustitre;
    }

    public void setSoustitre(String soustitre) {
        this.soustitre = soustitre;
    }

    public String getTexte() {
        return texte;
    }

    public void setTexte(String texte) {
        this.texte = texte;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }
}
