package com.example.practica_listas;

public class ListaEnlazada {

    private NodoLista primero;

    public ListaEnlazada(){ primero = null; }

    public void crearListaEnlazada() {
        primero = new NodoLista(19);
        primero = new NodoLista(6,primero);
        primero = new NodoLista(10,primero);
        primero = new NodoLista(21,primero);
        primero = new NodoLista(1,primero);

    }

    public String toString(){
        String resultado = "";
        NodoLista aux = primero;
        while(aux != null){
            resultado += aux+" -> ";
            aux = aux.getEnlace();
        }
        return resultado;
    }

}
