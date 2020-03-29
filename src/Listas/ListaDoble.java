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
public class ListaDoble <T>{
    
    private NodoDoble <T> prim, ult;
    
    public ListaDoble(){
        prim = null;
        ult = null;
    }
    
    public boolean estaVacia(){
        return prim == null;
    }
    
    public void agregaInicio(T dato){
        NodoDoble <T> nuevo = new NodoDoble(dato);
        nuevo.setSig(prim);
        if(prim != null)
            prim.setAnt(nuevo);
        else
            ult = nuevo;
        prim = nuevo;
    }
    
    public void agregaFinal(T dato){
        NodoDoble <T> nuevo = new NodoDoble(dato);
        nuevo.setAnt(ult);
        if(ult != null)
            ult.setSig(nuevo);
        else
            prim = nuevo;
        ult = nuevo;
    }
    
    public String toString(){
        return toString(ult, new StringBuilder());
    }
    
    private String toString(NodoDoble <T> act, StringBuilder cad){
        if(act == null)
            return cad.toString();
        else{
            cad.append(act.getDato() + " ");
            return toString(act.getAnt(), cad);
        }
    }
    
    public T quitaPrim(){
        T resp = null;
        if(!estaVacia()){
            resp = prim.getDato();
            NodoDoble <T> aux = prim;
            prim = prim.getSig();
            if(prim == null)
                ult = null;
            else{
                aux.setSig(null);
                prim.setAnt(null);
            }
        }
        return resp;
    }
    
    public T quitaUlt(){
        T resp = null;
        if(!estaVacia()){
            resp = ult.getDato();
            NodoDoble <T> aux = ult;
            ult = ult.getAnt();
            if(ult == null)
                prim = null;
            else{
                aux.setAnt(null);
                ult.setSig(null);
            }
        }
        return resp;
    }
    
    public T quitaDato(T dato){
        T resp = null;
        if(!estaVacia())
            resp = quitaDato(prim, dato);
        return resp;
    }
    
    private T quitaDato(NodoDoble <T> act, T dato){
        if(act == null)
            return null;
        else
            if(act.getDato().equals(dato)){
                if(act == prim)
                    return quitaPrim();
                else
                    if(act == ult)
                        return quitaUlt();
                    else{
                        act.getAnt().setSig(act.getSig());
                        act.getSig().setSig(act.getAnt());
                        act.setSig(null);
                        act.setAnt(null);
                        return act.getDato();
                    }
            }
            else
                return quitaDato(act.getSig(), dato);
    }
    
    public boolean estaOrdenCrec(){
        return estaOrdenCrec(prim);
    }
    
    private boolean estaOrdenCrec(NodoDoble <T> act){
        if(act == null || act.getSig() == null)
            return true;
        else{
            T dato1 = act.getDato();
            T dato2 = act.getSig().getDato();
            if(((Comparable)dato1).compareTo(dato2) <= 0)
                return estaOrdenCrec(act.getSig());
            else
                return false;
        }
    }
    
    public boolean estaContenida(ListaDoble <T> otra){
        boolean resp = false;
        if(otra != null)
            resp = estaContenida(prim, otra.prim, otra);
        return resp;
    }
    
    private boolean estaContenida(NodoDoble <T> act, NodoDoble <T> temp, ListaDoble <T> otra){
        if(act == null)
            return true;
        else
            if(temp == null)
                return false;
            else
                if(act.getDato().equals(temp.getDato()))
                    return estaContenida(act.getSig(), otra.prim, otra);
                else
                    return estaContenida(act, temp.getSig(), otra);
    }
    
    public static void main(String[] args) {
        ListaDoble <String> lis = new ListaDoble();
        lis.agregaInicio("Rojo");
        lis.agregaInicio("Azul");
        System.out.println(lis);
        lis.agregaFinal("Verde");
        lis.agregaFinal("Blanco");
        System.out.println(lis);
        lis.quitaUlt();
        lis.quitaPrim();
        System.out.println(lis);
    }
}
