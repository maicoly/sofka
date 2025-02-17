package com.test.sofka.ClientPerson.model.enums;

import com.fasterxml.jackson.annotation.JsonCreator;

public enum Genero {
    MASCULINO,
    FEMENINO,
    OTRO;
    @JsonCreator
    public static Genero fromString(String value) {
        for (Genero g : Genero.values()) {
            if (g.name().equalsIgnoreCase(value)) {
                return g;
            }
        }
        throw new IllegalArgumentException("Valor inválido para el género. Debe ser MASCULINO, FEMENINO o OTRO.");
    }
}
