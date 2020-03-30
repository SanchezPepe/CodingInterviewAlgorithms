/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Hash;

import common.Node;

/**
 *
 * @author hca
 */
public class HashTable<T> {
    
    public int cont;
    public Node<T> tabla[];
    public double factorDeCarga;
    
    public HashTable(){
        factorDeCarga = 0.65;
        this.tabla = (Node<T>[]) new Object[10];
        cont = 0;
    }
    
    public HashTable(double fc){
        this();
        this.factorDeCarga = fc;
    }
    
    public void expand(){
        Node<T> nuevo[] = (Node<T>[]) new Object[tabla.length*2];
        Node<T> actual, ant;
        for(int i = 0; i < tabla.length; i++){
            actual = tabla[i];
            while(actual != null){
                add(actual.getData());
                actual = actual.getSig();
            }
        }
        tabla = nuevo;
    }
    
    public void add(T elem){
        if(cont >= this.factorDeCarga * tabla.length)
            expand();
        int index = Hash(elem) % tabla.length;
        Node<T> Node = new Node<T>(elem);
        Node.setSig(Node);
        cont++;
    }
    
    public boolean find(T elem){
        int aux = Hash(elem) % tabla.length;
        Node<T> actual = tabla[aux];
        while(actual != null || actual.getData().equals(elem))
            actual = actual.getSig();
        if(actual != null)
            return true;
        else
            return false;
    }

    private int Hash(T elem) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
