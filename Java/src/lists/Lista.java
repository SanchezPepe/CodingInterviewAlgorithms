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
public abstract class Lista <T> implements ListaADT <T>{
    
    protected Node <T> prim;
    
    public Lista(){
        prim = null;
    }
    
    public Iterator <T> iterator(){
        return new IteradorEE(prim);
    }
    
    public boolean estaVacia(){
        return prim == null;
    }
    
    public T quitaPrimero(){
        T res = null;
        if(!estaVacia()){
            res = prim.getData();
            Node <T> aux = prim;
            prim = prim.getSig();
            aux.setSig(null);
        }
        return res;
    }
    
    public T quita(T dato){
        T res = null;
        if(!estaVacia())
            if(prim.getData().equals(dato))
                res = quitaPrimero();
            else{
                Node <T> ap = prim.getSig();
                Node <T> ant = prim;
                while(ap != null && !ap.getData().equals(dato)){
                    ant = ap;
                    ap = ap.getSig();
                }
                if(ap != null){
                    res = ap.getData();
                    ant.setSig(ap.getSig());
                    ap.setSig(null);
                }
            }
        return res;
    }
    
    public T quitaUltimo(){
        T res = null;
        if(!estaVacia()){
            Node <T> ap = prim;
            Node <T> ant = null;
            while(ap.getSig() != null){
                ant = ap;
                ap = ap.getSig();
            }
            res = ap.getData();
            if(ant == null)
                prim = null;
            else
                ant.setSig(null);
        }
        return res;
    }
    
    public String toString(){
        return toString(iterator(), new StringBuilder());
    }

    private String toString(Iterator <T> it, StringBuilder cad){
        if(!it.hasNext())
            return cad.toString();
        else{
            cad.append(it.next()).append(" ");
            return toString(it, cad);
        }
    }
    
    public int calculaTamaño(){
        return calculaTamaño(prim, 0);
    }

    private int calculaTamaño(Node <T> act, int cont){
        if(act == null)
            return cont;
        else
            return calculaTamaño(act.getSig(), cont+1);
    }
    
    public T obtienePrimero() {
        return prim.getData();
    }
    
    public T obtieneUltimo(){
        Node <T> aux = prim;
        while(aux != null)
            aux = aux.getSig();
        return aux.getData();
                
    }
    
    public abstract boolean contiene(T dato);

}
