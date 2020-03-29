/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listas;

import java.util.Iterator;

/**
 *
 * @author hca
 */
public interface ListaADT <T> extends Iterable{
    
    public Iterator <T> iterator();
    public boolean estaVacia();
    public T quitaPrimero();
    public T quitaUltimo();
    public T quita(T dato);
    public String toString();
    public boolean contiene(T dato);
    public int calculaTamaño();
    public T obtienePrimero();
    public T obtieneUltimo();
    
}
