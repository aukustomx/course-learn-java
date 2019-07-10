package com.curso.model;

public class Indice {

    private String nombre;
    private int tracks;

    public Indice(String nombre, int tracks) {
        this.nombre = nombre;
        this.tracks = tracks;
    }

    public String getNombre() {
        return nombre;
    }

    public int getTracks() {
        return tracks;
    }

    @Override
    public String toString() {
        return "Indice{" +
                "nombre='" + nombre + '\'' +
                ", tracks=" + tracks +
                '}';
    }
}
