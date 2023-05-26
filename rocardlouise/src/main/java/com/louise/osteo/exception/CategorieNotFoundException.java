package com.louise.osteo.exception;

public class CategorieNotFoundException extends Exception {
    private int id;

    public CategorieNotFoundException(int id) {
        super(String.format("Categorie non trouvé en numéro : '%s'", id));
    }
}
