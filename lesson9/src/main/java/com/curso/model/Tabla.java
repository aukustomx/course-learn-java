package com.curso.model;

public class Tabla {

    private String nombre;
    private int tracks;
    private Indice indice;
    private boolean isCompressed;
    private int compressedRatio;
    private double kb;
    private double mb;
    private double gb;

    public Tabla(String nombre, int tracks, Indice indice, boolean isCompressed, int compressedRatio) {
        this.nombre = nombre;
        this.tracks = tracks;
        this.indice = indice;
        this.isCompressed = isCompressed;
        this.compressedRatio = compressedRatio;
    }

    public String getNombre() {
        return nombre;
    }

    public int getTracks() {
        return tracks;
    }

    public Indice getIndice() {
        return indice;
    }

    public boolean isCompressed() {
        return isCompressed;
    }

    public int getCompressedRatio() {
        return compressedRatio;
    }

    public double getKb() {
        return kb;
    }

    public double getMb() {
        return mb;
    }

    public double getGb() {
        return gb;
    }

    public void calcularEspacio() {
        this.tracks = this.tracks + indice.getTracks();
        this.kb = this.tracks * 48;
        this.mb = this.kb / 1024;
        this.gb = this.mb / 1024;
    }

    @Override
    public String toString() {
        return "Tabla{" +
                "nombre='" + nombre + '\'' +
                ", tracks=" + tracks +
                ", indice=" + indice +
                ", isCompressed=" + isCompressed +
                ", compressedRatio=" + compressedRatio +
                ", kb=" + kb +
                ", mb=" + mb +
                ", gb=" + gb +
                '}';
    }
}
