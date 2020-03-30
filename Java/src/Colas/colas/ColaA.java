/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Colas.colas;

/**
 *
 * @author hca
 */
public class ColaA <T> implements ColaADT <T> {
    
    private T cola[];
    private int frente, fin;
    private final int MAX = 10;
    
    public ColaA(){
        cola = (T[]) new Object[MAX];
        frente = -1;
        fin = -1;
    }
    
    public ColaA(int max){
        cola = (T[]) new Object[max];
        frente = -1;
        fin = -1;
    }
    
    public boolean estaVacia(){
        return fin == -1;
    }
    
    public boolean estaLlena(){
        return (fin + 1) % cola.length == frente;
    }
    
    public T primero(){
        if(!estaVacia())
            return cola [frente];
        else
            throw new EmptyCollectionException("Cola Vacía");
    }
    
    //Sin EXCEPTION
    public T primero2(){
        T resp = null;
        if(!estaVacia())
            resp = cola [frente];
        return resp;
    }
    
    public T quita(){
        if(!estaVacia()){
            T resp = cola[frente];
            cola[frente] = null;
            if(frente  == fin){
                frente = -1;
                fin = -1;
            }
            else
                frente = (frente + 1) % cola.length;
            return resp;
        }
        else
            throw new EmptyCollectionException("Cola vacía");
    }
    
    public T quita2(){
        T resp = null;
        if(!estaVacia()){
            resp = cola[frente];
            cola[frente] = null;
            if(frente  == fin){
                frente = -1;
                fin = -1;
            }
            else
                frente = (frente + 1) % cola.length;  
        }
        return resp;
    }
    
    private void expandCapacity(int n){
        T nueva[] = (T[]) new Object[n];
        int i, j;
        j = 0;
        for(i = frente; i < cola.length; i++){
            nueva[j] = cola[i];
            j++;
        }
        if(fin + 1 == frente)
            for(i = 0; i <= fin; i++){
                nueva[j] = cola[i];
                j++;
            }
        cola = nueva;
        frente = 0;
        fin = j-1;
      
    }
    
    private void expandCapacity2(int tam){
        T nueva[] = (T[]) new Object[tam];
        int i, j;
        int aux = cola.length;
        for(i = 0; i < aux; i++)
            nueva[i] = cola [(i + frente) % aux];
        cola = nueva;
        frente = 0;
        fin = aux - 1;
    }
    
    public void agrega(T nuevo){
        if(estaLlena())
            expandCapacity(cola.length * 2);
        fin = (fin + 1) % cola.length;
        cola[fin] = nuevo;
        if(frente == -1)
            frente = 0;
    }
    
    public String toString(){
        StringBuilder cad = new StringBuilder();
        int i = 0;
        while(primero() != null){
            cad.append(cola[i]);
            i++;
        }
        return cad.toString();
    }
}
