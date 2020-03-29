/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conjuntos;

import java.util.Iterator;



/**
 *
 * @author hca
 */
public class ConjuntoA <T> implements ConjuntoADT <T>{
    
    private T conjunto[];
    private int cardinalidad;
    private final int MAX = 25;
    
    public ConjuntoA(){
        conjunto = (T[]) new Object [MAX];
        cardinalidad = 0;
    }
    
    public ConjuntoA(int tam){
        conjunto = (T[]) new Object [tam];
        cardinalidad = 0;
    }
    
    public int getCardinalidad(){
        return this.cardinalidad;
    }
    
    public boolean estáVacío(){
        return cardinalidad == 0;
    }
    
    public boolean contiene(T dato){
        boolean resp = false;
        Iterator <T> it = iterator();
        while(it.hasNext() && !resp)
            resp = it.next().equals(dato);
        return resp;
    }
    
    public boolean agrega(T dato){
        boolean resp = false;
        if(!contiene(dato)){
            resp = true;
            if(cardinalidad == conjunto.length-1)
                expande(conjunto.length*2);
            conjunto[cardinalidad] = dato;
            cardinalidad++;
        }
        return resp;
    }
    
    public T quita(T dato){
        T resp = null;
        int i = 0;
        while(i < cardinalidad && !conjunto[i].equals(dato))
            i++;
        if(i < cardinalidad){
            resp = conjunto[i];
            conjunto[i] = conjunto[cardinalidad-1];
            conjunto [cardinalidad-1] = null;
            cardinalidad--;
        }
        return resp;
    }
    
    private void expande(int tam){
        T nuevo[] = (T[]) new Object[tam];
        for(int i = 0; i < cardinalidad; i++)
            nuevo[i] = conjunto[i];
        conjunto = nuevo;
    }
    
    public Iterator <T> iterator(){
        return new IteradorArreglo(conjunto, cardinalidad);
        
    }
    
    public ConjuntoADT <T> union(ConjuntoADT <T> otro){
        ConjuntoADT <T> res = new ConjuntoA();
        Iterator <T> it = this.iterator();
        while(it.hasNext())
            res.agrega(it.next());
        it = otro.iterator();
        while(it.hasNext())
            res.agrega(it.next());
        return res;
    }

    public ConjuntoADT <T> intersec(ConjuntoADT <T> otro){
        T aux;
        ConjuntoADT <T> res = new ConjuntoA();
        Iterator <T> it = this.iterator();
        while(it.hasNext()){
            aux = it.next();
            if(otro.agrega(aux))
                res.agrega(aux);
        }
        return res;
    }
    
    public ConjuntoADT <T> dif(ConjuntoADT <T> otro){
        T aux;
        ConjuntoADT <T> res = new ConjuntoA();
        Iterator <T> it = this.iterator();
        while(it.hasNext()){
            aux = it.next();
            if(!otro.agrega(aux))
                res.agrega(aux);
        }
        return res;
    }
    
    public String toString(){
        StringBuilder cad = new StringBuilder();
        Iterator <T> it = iterator();
        while(it.hasNext())
            cad.append(it.next() + ", ");
        return cad.toString();               
    }
    
    private String toString(Iterator <T> it, StringBuilder cad){
        if(!it.hasNext())
            return cad.toString();
        else{
            cad.append(it.next());
            return it.next() + toString(it, cad);
        }    
    }
    
    public String toStringR(){
        Iterator <T> it = this.iterator();
        StringBuilder cad = new StringBuilder();
        return toString(it, cad);
    }
    
    public static void main(String[] args) {
        ConjuntoA c1 = new ConjuntoA(10);
        c1.agrega("LOL");
        c1.agrega(2);
        int a = c1.getCardinalidad();
        System.out.println(c1.contiene("LOL"));
        System.out.println(c1.contiene(2));
        System.out.println(a);
        System.out.println(c1.estáVacío());
        System.out.println(c1.toStringR());
    }
    
}
