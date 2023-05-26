package com.louise.osteo.model;

import javax.persistence.*;

@Entity
@Table(name="seance")
public class Seance {


        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name="id")
        private int id;

        @Column(name="numero")
        private int numero;

        @Column(name="titre")
        private String titre;

        @Column(name="texte")
        private String texte;

        @Column(name="icon")
        private String icon;

        @Column(name="color")
        private String color;

        public Seance(){}

        public Seance(int id, int numero, String titre, String texte, String icon, String color) {
                this.id = id;
                this.numero = numero;
                this.titre = titre;
                this.texte = texte;
                this.icon = icon;
                this.color = color;
        }

        public int getId() {
                return id;
        }

        public void setId(int id) {
                this.id = id;
        }

        public int getNumero() {
                return numero;
        }

        public void setNumero(int numero) {
                this.numero = numero;
        }

        public String getTitre() {
                return titre;
        }

        public void setTitre(String titre) {
                this.titre = titre;
        }

        public String getTexte() {
                return texte;
        }

        public void setTexte(String texte) {
                this.texte = texte;
        }

        public String getIcon() {
                return icon;
        }

        public void setIcon(String icon) {
                this.icon = icon;
        }

        public String getColor() {
                return color;
        }

        public void setColor(String color) {
                this.color = color;
        }
}
