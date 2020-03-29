/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Conjuntos;

import java.util.Iterator;

/**
 *
 * @author hca
 * @param <T>
 */
public interface ConjuntoADT <T> extends Iterable <T>{
    
    public boolean agrega(T dato);
    public boolean contiene(T dato);
    public T quita(T dato);
    public ConjuntoADT <T> union(ConjuntoADT<T> otro);
    public ConjuntoADT <T> intersec(ConjuntoADT<T> otro);
    public ConjuntoADT <T> dif(ConjuntoADT<T> otro);
    public boolean estáVacío();
    public Iterator<T> iterator();
    
    
    
}
