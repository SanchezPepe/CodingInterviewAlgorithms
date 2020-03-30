package common;
/**
 *
 * @author hca
 */
public class NodeAVL<T extends Comparable<T>> extends BinaryNode<T> {

    private NodeAVL<T> izq, der, papa;
    private int fe;

    public NodeAVL(T dato) {
        super(dato);
        fe = 0;
        this.izq = (NodeAVL<T>) super.izq;
        this.der = (NodeAVL<T>) super.der;
    }

    public void cuelga(NodeAVL<T> nodo) {
        if (nodo == null)
            return;
        if (nodo.getElem().compareTo(elem) <= 0)
            izq = nodo;
        else
            der = nodo;
        nodo.setPapa(this);
    }

    public NodeAVL<T> getIzq() {
        return izq;
    }

    public NodeAVL<T> getDer() {
        return der;
    }

    public void setIzq(NodeAVL<T> nodo) {
        this.izq = nodo;
    }

    public void setDer(NodeAVL<T> nodo) {
        this.der = nodo;
    }

    public NodeAVL getPapa() {
        return papa;
    }

    public int getFe() {
        return fe;
    }

    public void setPapa(NodeAVL papa) {
        this.papa = papa;
    }

    public void setFe(int nuevo) {
        this.fe = nuevo;
    }

    public int actFe() {
        if (this.izq != null && this.der != null)
            return 0;
        if (this.izq != null && this.der == null)
            return -1;
        if (this.der != null && this.izq == null)
            return 1;
        else
            return 0;
    }

    public static void main(String[] args) {
        NodeAVL<Integer> n = new NodeAVL(4);
        n.setDer(new NodeAVL(5));
        System.out.println(n.getDer().elem);
    }

}
