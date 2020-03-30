/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lists;

import java.util.Iterator;
import java.util.NoSuchElementException;
import common.Node;

/**
 *
 * @author hca
 */
public class IteradorEE <T> implements Iterator <T>{
    
    private Node <T> actual;
    
    public IteradorEE(Node<T> dir){
        actual = dir;
    }
    
    public boolean hasNext(){
        return actual != null;
    }
    
    public T next(){
        if(hasNext()){
            T dato = actual.getData();
            actual = actual.getSig();
            return dato;
        }
        else
            throw new NoSuchElementException();
    }
    
    public void remove(){
        throw new UnsupportedOperationException();
    }
    
}
