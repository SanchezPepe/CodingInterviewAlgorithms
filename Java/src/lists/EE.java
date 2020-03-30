package lists;

import java.util.Iterator;
import common.Node;

/**
 *
 * @author hca
 */
public class EE<T> implements Iterable<T> {

    private Node<T> prim;

    public EE() {
        prim = null;
    }

    public Node<T> getPrim() {
        return prim;
    }

    public Iterator<T> iterator() {
        return new IteradorEE(prim);
    }

    public boolean estaVacia() {
        return prim == null;
    }

    public void agregaInicio(T dato) {
        Node<T> nuevo = new Node(dato);
        nuevo.setSig(prim);
        prim = nuevo;
    }

    public void agregaFinal(T dato) {
        Node<T> nuevo = new Node(dato);
        if (estaVacia())
            prim = nuevo;
        else {
            Node<T> ap = prim;
            while (ap.getSig() != null)
                ap = ap.getSig();
            ap.setSig(nuevo);
        }
    }

    public T quitaPrimero() {
        T res = null;
        if (!estaVacia()) {
            res = prim.getData();
            Node<T> aux = prim;
            prim = prim.getSig();
            aux.setSig(null);
        }
        return res;
    }

    public T busca(T dato) {
        return busca(iterator(), dato);
    }

    private T busca(Iterator<T> it, T dato) {
        if (!it.hasNext())
            return null;
        else {
            T temp = it.next();
            if (temp.equals(dato))
                return temp;
            else
                return busca(it, dato);
        }
    }

    public T busca2(T dato) {
        T res = null;
        Node<T> ap = prim;
        while (ap != null && !ap.getData().equals(dato))
            ap.getSig();
        if (res != null)
            res = ap.getData();
        return res;
    }

    public T quitaUlt() {
        T res = null;
        if (!estaVacia()) {
            Node<T> ap = prim;
            Node<T> ant = null;
            while (ap.getSig() != null) {
                ant = ap;
                ap = ap.getSig();
            }
            res = ap.getData();
            if (ant == null)
                prim = null;
            else
                ant.setSig(null);
        }
        return res;
    }

    public String toString() {
        return toString(iterator(), new StringBuilder());
    }

    private String toString(Iterator<T> it, StringBuilder cad) {
        if (!it.hasNext())
            return cad.toString();
        else {
            cad.append(it.next()).append(" ");
            return toString(it, cad);
        }
    }

    public T quitaDato(T dato) {
        T res = null;
        if (!estaVacia())
            if (prim.getData().equals(dato))
                res = quitaPrimero();
            else {
                Node<T> ap = prim.getSig();
                Node<T> ant = prim;
                while (ap != null && !ap.getData().equals(dato)) {
                    ant = ap;
                    ap = ap.getSig();
                }
                if (ap != null) {
                    res = ap.getData();
                    ant.setSig(ap.getSig());
                    ap.setSig(null);
                }
            }
        return res;
    }

    public int eliminaRep() {
        Node<T> ant, act;
        ant = null;
        int cont = 0;
        act = prim;
        while (act != null)
            if (act.getSig() != null && act.getData().equals(act.getSig().getData())) {
                ant.getSig();
                act.setSig(act.getSig().getSig());
                ant.setSig(null);
                cont++;
            } else {
                act = act.getSig();
            }
        return cont;
    }

    // NO CONSECUTIVOS
    public int elimRep() {
        int cont = 0;
        Node<T> ant, act, aux = null;
        act = prim;
        while (act != null) {
            ant = aux;
            aux = act.getSig();
            while (aux != null)
                if (act.getData().equals(aux.getData())) {
                    ant.setSig(aux.getSig());
                    aux.setSig(null);
                    aux = ant.getSig();
                    cont++;
                } else {
                    ant = aux;
                    aux = aux.getSig();
                }
            act = act.getSig();
        }
        return cont++;
    }

    // RECURSIVO
    public int elimRR() {
        return elimRR(prim, 0);
    }

    private int elimRR(Node<T> act, int cont) {
        if (act == null)
            return cont;
        else {
            if (act.getSig() != null && act.getData().equals(act.getSig().getData())) {
                cont = cont + 1;
                Node<T> aux = act.getSig();
                act.setSig(aux.getSig());
                aux.setSig(null);
            } else
                act = act.getSig();
            return elimRR(act, cont);
        }
    }

    // METODO RECURISIVO QUE CUENTA EL NUMERO DE NodeS
    public int cuentaNodes() {
        return cuentaNodes(prim, 0);
    }

    private int cuentaNodes(Node<T> act, int cont) {
        if (act == null)
            return cont;
        else
            return cuentaNodes(act.getSig(), cont + 1);
    }

    // MÉTODO QUE ELIMINA DESPUES DE ENCONTRADO EL NUMERO
    public boolean elimA(T dato) {
        Node<T> ant = null, act;
        act = prim;
        boolean resp = false;
        if (act.getSig().equals(dato) && ant != null) {
            ant.setSig(act.getSig());
            resp = true;
        }

        return resp;

    }

    public boolean elimSigDe(T dato) {
        boolean resp = false;
        if (!estaVacia()) {
            Node<T> act = prim;
            while (act.getSig() != null && !act.getData().equals(dato))
                act = act.getSig();
            if (act.getSig() != null) {
                resp = true;
                Node<T> aux = act.getSig();
                act.setSig(aux.getSig());
                aux.setSig(null);
            }
        }
        return resp;
    }

    public boolean elimAntDe(T dato) {
        boolean resp = false;
        if (!estaVacia() && !prim.getData().equals(dato)) {
            Node<T> act, aElim, sig, ant;
            act = prim.getSig();
            aElim = prim;
            ant = prim;
            while (act != null && !act.getData().equals(dato)) {
                ant = aElim;
                aElim = act;
                act = act.getSig();
            }
            if (act != null) {
                resp = true;
                if (ant == prim)
                    quitaPrimero();
                else {
                    ant.setSig(act);
                    aElim.setSig(null);
                }
            }
        }
        return resp;
    }

    public T getData(int pos) {
        T res = null;
        Node<T> act = prim;
        int cont = 0;
        pos = pos - 1;
        while (act != null && cont != pos) {
            act = act.getSig();
            cont++;
        }
        if (act != null)
            res = act.getData();
        return res;
    }

    public boolean insertaAntesQue(T ref, T dato) {
        boolean resp = false;
        if (!estaVacia()) {
            if (ref.equals(prim.getData())) {
                resp = true;
                agregaInicio(dato);
            } else {
                Node<T> ant, act;
                ant = prim;
                act = prim.getSig();
                while (act != null && !act.getData().equals(ref)) {
                    ant = act;
                    act = act.getSig();
                }
                if (act != null) {
                    resp = true;
                    Node<T> nuevo = new Node(dato);
                    nuevo.setSig(act);
                    ant.setSig(nuevo);
                }
            }
        }
        return resp;
    }

    public EE<T> mezcla(EE<T> otra) {
        EE<T> res = null;
        if (otra != null) {
            if (otra.estaVacia())
                res = this;
            else if (this.estaVacia())
                res = otra;
            else {
                res = new EE();
                res.prim = prim;
                Node<T> n2 = otra.prim;
                Node<T> n1 = prim.getSig();
                Node<T> r = res.prim;
                while (n1 != null && n2 != null) {
                    r.setSig(n2);
                    r = n2;
                    n2 = n2.getSig();
                    r.setSig(n1);
                    r = n1;
                    n1 = n1.getSig();
                }
                if (n1 == null)
                    r.setSig(n2);
                prim = null;
                otra.prim = null;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        EE<String> e = new EE();
        e.agregaInicio("rojo");
        e.agregaInicio("verde");
        System.out.println("Estructura enlazada: " + e);
        e.agregaFinal("azul");
        System.out.println("Estructura enlazada: " + e);
        System.out.println("Total de Nodes: " + e.cuentaNodes());
        System.out.println("Busca: " + e.busca("rojo"));
        System.out.println("Elimina: " + e.quitaDato("gris"));
        System.out.println("Elimina: " + e.quitaDato("verde"));
        e.agregaInicio("negro");
        System.out.println("Estructura enlazada: " + e);
        System.out.println("Total de Nodes: " + e.cuentaNodes());

        EE<Integer> unos = new EE();
        EE<Integer> dos = new EE();
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
