package com.example.practica_listas;

public class NodoLista {
    double dato;
    NodoLista enlace;

    public NodoLista(double x){
        dato = x;
        enlace = null;
    }

        public NodoLista(double x, NodoLista n){
        dato = x;
        enlace = n;
        }

        public double getDato() { return dato; }
    public NodoLista getEnlace(){
        return enlace;
    }

    public void setEnlace(NodoLista enlace) {
        this.enlace = enlace;
    }
    public String toString(){
        return String.valueOf(dato);
    }
}
