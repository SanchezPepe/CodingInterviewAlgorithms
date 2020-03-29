package listas;

import java.util.Iterator;

/**
 *
 * @author hca
 */
public class EE <T> implements Iterable <T>{

    private Nodo<T> prim;

    public EE(){
        prim = null;
    }

    public Nodo<T> getPrim() {
        return prim;
    }

    public Iterator <T> iterator(){
        return new IteradorEE(prim);
    }

    public boolean estaVacia(){
        return prim == null;
    }

    public void agregaInicio(T dato){
        Nodo<T> nuevo = new Nodo(dato);
        nuevo.setSig(prim);
        prim = nuevo;
    }

    public void agregaFinal(T dato){
        Nodo <T> nuevo = new Nodo(dato);
        if(estaVacia())
            prim = nuevo;
        else{
            Nodo <T> ap = prim;
            while(ap.getSig() != null)
                ap = ap.getSig();
            ap.setSig(nuevo);
        }
    }

    public T quitaPrimero(){
        T res = null;
        if(!estaVacia()){
            res = prim.getDato();
            Nodo <T> aux = prim;
            prim = prim.getSig();
            aux.setSig(null);
        }
        return res;
    }

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

    public T busca2(T dato){
        T res = null;
        Nodo <T> ap = prim;
        while(ap != null && !ap.getDato().equals(dato))
            ap.getSig();
        if(res != null)
            res = ap.getDato();
        return res;
    }

    public T quitaUlt(){
        T res = null;
        if(!estaVacia()){
            Nodo <T> ap = prim;
            Nodo <T> ant = null;
            while(ap.getSig() != null){
                ant = ap;
                ap = ap.getSig();
            }
            res = ap.getDato();
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

    public T quitaDato(T dato){
        T res = null;
        if(!estaVacia())
            if(prim.getDato().equals(dato))
                res = quitaPrimero();
            else{
                Nodo <T> ap = prim.getSig();
                Nodo <T> ant = prim;
                while(ap != null && !ap.getDato().equals(dato)){
                    ant = ap;
                    ap = ap.getSig();
                }
                if(ap != null){
                    res = ap.getDato();
                    ant.setSig(ap.getSig());
                    ap.setSig(null);
                }
            }
        return res;
    }

    public int eliminaRep(){
        Nodo <T> ant, act;
        ant = null;
        int cont = 0;
        act = prim;
        while(act != null)
            if(act.getSig() != null && act.getDato().equals(act.getSig().getDato())){
                ant.getSig();
                act.setSig(act.getSig().getSig());
                ant.setSig(null);
                cont++;
            }
            else{
                act = act.getSig();
            }
        return cont;
    }

    //NO CONSECUTIVOS
    public int elimRep(){
        int cont = 0;
        Nodo <T> ant, act, aux = null;
        act = prim;
        while(act != null){
            ant = aux;
            aux = act.getSig();
            while(aux != null)
                if(act.getDato().equals(aux.getDato())){
                    ant.setSig(aux.getSig());
                    aux.setSig(null);
                    aux = ant.getSig();
                    cont++;
                }
                else{
                    ant = aux;
                    aux = aux.getSig();
                }
            act = act.getSig();
        }
        return cont++;
    }

    //RECURSIVO
    public int elimRR(){
        return elimRR(prim, 0);
    }

    private int elimRR(Nodo <T> act, int cont){
        if(act == null)
            return cont;
        else{
            if(act.getSig() != null && act.getDato().equals(act.getSig().getDato())){
                cont = cont+1;
                Nodo <T> aux = act.getSig();
                act.setSig(aux.getSig());
                aux.setSig(null);
            }
            else
                act = act.getSig();
            return elimRR(act, cont);
        }
    }

    //METODO RECURISIVO QUE CUENTA EL NUMERO DE NODOS
    public int cuentaNodos(){
        return cuentaNodos(prim, 0);
    }

    private int cuentaNodos(Nodo <T> act, int cont){
        if(act == null)
            return cont;
        else
            return cuentaNodos(act.getSig(), cont+1);
    }

    //MÉTODO QUE ELIMINA DESPUES DE ENCONTRADO EL NUMERO
    public boolean elimA(T dato){
        Nodo <T> ant = null, act;
        act = prim;
        boolean resp = false;
        if(act.getSig().equals(dato) && ant != null){
            ant.setSig(act.getSig());
            resp = true;
        }

        return resp;

    }

    public boolean elimSigDe(T dato){
        boolean resp = false;
        if(!estaVacia()){
            Nodo <T> act = prim;
            while(act.getSig() != null && !act.getDato().equals(dato))
                act = act.getSig();
            if(act.getSig() != null){
                resp = true;
                Nodo <T> aux = act.getSig();
                act.setSig(aux.getSig());
                aux.setSig(null);
            }
        }
        return resp;
    }

    public boolean elimAntDe(T dato){
        boolean resp = false;
        if(!estaVacia() && !prim.getDato().equals(dato)){
            Nodo <T> act, aElim, sig, ant;
            act = prim.getSig();
            aElim = prim;
            ant = prim;
            while(act != null && !act.getDato().equals(dato)){
                ant = aElim;
                aElim = act;
                act = act.getSig();
            }
            if(act != null){
                resp = true;
                if(ant == prim)
                    quitaPrimero();
                else{
                    ant.setSig(act);
                    aElim.setSig(null);
                }
            }
        }
        return resp;
    }

    public T getDato(int pos){
        T res = null;
        Nodo <T> act = prim;
        int cont = 0;
        pos = pos-1;
        while(act != null && cont != pos){
            act = act.getSig();
            cont++;
        }
        if(act != null)
            res = act.getDato();
        return res;
    }

    public boolean insertaAntesQue(T ref, T dato){
        boolean resp = false;
        if(!estaVacia()){
            if(ref.equals(prim.getDato())){
                resp = true;
                agregaInicio(dato);
            }
            else{
                Nodo <T> ant, act;
                ant = prim;
                act = prim.getSig();
                while(act != null && !act.getDato().equals(ref)){
                    ant = act;
                    act = act.getSig();
                }
                if(act != null){
                    resp = true;
                    Nodo <T> nuevo = new Nodo(dato);
                    nuevo.setSig(act);
                    ant.setSig(nuevo);
                }
            }
        }
        return resp;
    }
    
    public EE<T> mezcla(EE <T> otra){
        EE <T> res = null;
        if(otra != null){
            if(otra.estaVacia())
                res = this;
            else
                if(this.estaVacia())
                    res = otra;
                else{
                    res = new EE();
                    res.prim = prim;
                    Nodo <T> n2 = otra.prim;
                    Nodo <T> n1 = prim.getSig();
                    Nodo <T> r = res.prim;
                    while(n1 != null && n2 != null){
                        r.setSig(n2);
                        r = n2;
                        n2 = n2.getSig();
                        r.setSig(n1);
                        r = n1;
                        n1 = n1.getSig();
                    }
                    if(n1 == null)
                        r.setSig(n2);
                    prim = null;
                    otra.prim = null;
                }
        }
        return res;
    }

    public static void main(String[] args) {
        EE <String> e = new EE();
        e.agregaInicio("rojo");
        e.agregaInicio("verde");
        System.out.println("Estructura enlazada: " + e);
        e.agregaFinal("azul");
        System.out.println("Estructura enlazada: " + e);
        System.out.println("Total de nodos: " + e.cuentaNodos());
        System.out.println("Busca: " + e.busca("rojo"));
        System.out.println("Elimina: " + e.quitaDato("gris"));
        System.out.println("Elimina: " + e.quitaDato("verde"));
        e.agregaInicio("negro");
        System.out.println("Estructura enlazada: " + e);
        System.out.println("Total de nodos: " + e.cuentaNodos());
        
        EE <Integer> unos = new EE();
        EE <Integer> dos = new EE();
        unos.agregaFinal(1);
        unos.agregaFinal(1);
        unos.agregaFinal(1);
        unos.agregaFinal(1);
        dos.agregaFinal(2);
        dos.agregaFinal(3);
        dos.agregaFinal(2);
        
        System.out.println(unos);
        System.out.println(dos);
        
        System.out.println(unos.mezcla(dos));
        
    }


}
