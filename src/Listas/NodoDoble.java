/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listas;

/**
 *
 * @author hca
 */
public class NodoDoble <T> {
    
    private T dato;
    private NodoDoble<T> ant, sig;
    
    public NodoDoble(){
        ant = null;
        sig = null;
    }
    
    public NodoDoble(T dato){
        this();
        this.dato = dato;
    }

    public T getDato() {
        return dato;
    }

    public void setDato(T dato) {
        this.dato = dato;
    }

    public NodoDoble<T> getAnt() {
        return ant;
    }

    public void setAnt(NodoDoble<T> ant) {
        this.ant = ant;
    }

    public NodoDoble<T> getSig() {
        return sig;
    }

    public void setSig(NodoDoble<T> sig) {
        this.sig = sig;
    }

    @Override
    public String toString() {
        return "NodoDoble: " + "\nDato: " + dato + "\nAnterior: " + ant + "\nSiguiente: " + sig;
    }
    
    
    
}
