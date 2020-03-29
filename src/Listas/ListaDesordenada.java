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
public class ListaDesordenada <T> extends Lista <T> implements ListaDesordenadaADT <T> {

    
    public Object quita() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    public boolean contiene() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void agregaInicio() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void agregaFinal() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean agregaAntesQue() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean agregaDespuesQue() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean contiene(T dato) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    //PROBLEMA 37
    public T busca(T dato){
        return busca(iterator(), dato);
    }
    
    private T busca(Iterator <T> it, T dato){
        if(!it.hasNext())
            return null;
        else{
            T temp = it.next();
            if(temp.equals(dato))
                return temp;
            else
                return busca(it, dato);
        }
    }
    
    //PROBLEMA 37 USANDO NODOS
    public T busca2(T dato){
        return busca2(prim, dato);
    }
    
    private T busca2(Nodo <T> act, T dato){
        if(act == null)
            return null;
        else{
            if(act.getDato().equals(dato))
                return act.getDato();
            else
                return busca2(act.getSig(), dato);
        }
    }
    
    //TOSTRING IGUAL
   
    
    
    
}
