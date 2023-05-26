package com.louise.osteo.exception;

public class PresentationNotFoundException extends Exception{
    private int id;

    public PresentationNotFoundException(int id) {
        super(String.format("Presentation non trouvé en numéro : '%s'", id));
    }
}
