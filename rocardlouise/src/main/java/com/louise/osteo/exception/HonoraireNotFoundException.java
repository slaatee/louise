package com.louise.osteo.exception;

import com.louise.osteo.model.Honoraire;

public class HonoraireNotFoundException extends Exception {
    private int id;

    public HonoraireNotFoundException(int id) {
        super(String.format("Honoraire non trouvé en numéro : '%s'", id));
    }
}
