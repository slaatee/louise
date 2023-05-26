package com.louise.osteo.exception;

public class SeanceNotFoundException extends Exception {

    private int id;

    public SeanceNotFoundException(int id) {
        super(String.format("Seance non trouvé en numéro : '%s'", id));
    }
}
