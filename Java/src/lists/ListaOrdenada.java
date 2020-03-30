/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lists;

import java.util.Iterator;
import common.Node;

/**
 *
 * @author hca
 */
public class ListaOrdenada <T extends Comparable <T>> extends Lista <T> implements ListaOrdenadaADT <T> {
    
    public ListaOrdenada(){
        super();
    }
    
    public void agrega(T dato){
        Node<T> nuevo = new Node(dato);
        if(estaVacia() || prim.getData().compareTo(dato) >= 0){
            nuevo.setSig(prim);
            prim = nuevo;
        }
        else{
            Node <T> act = prim.getSig();
            Node <T> ant = prim;
            while(act != null && act.getData().compareTo(dato) < 0){
                ant.setSig(nuevo);
                nuevo.setSig(act);
            }
        }
    }
    
    public T quita(T dato){
        T res = null;
        if(!estaVacia()){
            if(dato.equals(prim.getData()))
                res = quitaPrimero();
            else{
                Node <T> ant = prim;
                Node <T> act = prim.getSig();
                while(act != null && act.getData().compareTo(dato) < 0){
                    ant = act;
                    act = act.getSig();
                }
                if(act != null && act.getData().equals(dato)){
                    ant.setSig(act.getSig());
                    res = act.getData();
                    act.setSig(null);
                }
            }
        }    
        return res;
    }
    
    public boolean contiene(T dato){
        return contiene(iterator(), dato);
    }
    
    private boolean contiene(Iterator <T> it, T dato){
        if(!it.hasNext())
            return false;
        else{
            T temp = it.next();
            if(temp.equals(dato))
                return true;
            else
                if(temp.compareTo(dato) > 0)
                    return false;
                else 
                    return contiene(it, dato);
        }
    }
    
    //PROBLEMA 39
    public boolean equals(Object otra){
        boolean res = false;
        if(otra != null && otra instanceof ListaOrdenada){
            ListaOrdenada <T> lis = (ListaOrdenada)otra;
            if(this.calculaTamaño() == lis.calculaTamaño())
                res = equals(prim, lis.prim);
        }
        return res;
    }
    
    private boolean equals(Node <T> n1, Node <T> n2){
        if(n1 == null) //O N2
            return true;
        else{
            if(n1.getData().equals(n2.getData()))
                return equals(n1.getSig(), n2.getSig());
            else
                return false;
        }
    }
    
    public int compareTo() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
