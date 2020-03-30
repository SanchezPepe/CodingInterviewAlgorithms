/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package common;

/**
 *
 * @author Jose Sanchez
 */
public class Node <T> {
    
    private T elem;
    private Node<T> sig;
    
    public Node(){
        sig = null;
    }
    
    public Node(T elem){
        this.elem = elem;
        sig = null;
    }
    
    public T getData(){
        return elem;
    }
    
    public Node<T> getSig(){
        return sig;
    }
    
    public void setSig(Node<T> nuevo){
        sig = nuevo;
    }    
    
    public void setElem(T elem){
        this.elem = elem;
    }
    
}
