/*************************************************************************
 *  Compilació:   javac Arc.java
 *  Execució:     java Arc
 *
 *  Un arc amb un valor que representa el pes entre dos nodes concrets
 *  i un paràmetre T que representa el node al qual va destinat l'arc
 *
 *************************************************************************/

/**
 *  La classe <tt>Arc</tt> representa un arc amb pes, amb el nodeA parametritzat.
 */

public class Arc<T> {
    private double pes;
    private final T nodeA, nodeB;

    /**
     * Crea un arc amb pes <tt>pes</tt> i un node de destí <tt>nodeA</tt>
     * @param pes

     * @param nodeA
     */
    public Arc(double pes, T nodeA, T nodeB) {
        this.pes = pes;
        this.nodeA = nodeA;
        this.nodeB = nodeB;
    }

    /**
     * Crea un arc amb pes 0 i un node de destí <tt>nodeA</tt>
      * @param nodeA
     */
    public Arc(T nodeA, T nodeB) {
       this(0, nodeA, nodeB);
    }

    public Arc(Arc<T> other){
        this.pes = other.pes;
        this.nodeA = other.nodeA;
        this.nodeB = other.nodeB;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Arc arc = (Arc) o;

        if (!nodeA.equals(arc.nodeA)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return nodeA.hashCode();
    }

    /**
     * Retorna el pes de l'arc
     * @return el pes de l'arc
     */
    public double getPes() {
        return pes;
    }

    /**
     * Modifica el pes de l'arc a <tt>pes</tt>
     * @param pes
     */
    public void setPes(double pes) {
        this.pes = pes;
    }

    /**
     * Retorna el node A de l'arc
     * @return el node A de l'arc
     */
    public T getNodeA() {
        return nodeA;
    }

    /**
     * Retorna el node B de l'arc
     * @return el node B de l'arc
     */
    public T getNodeB() {
        return nodeB;
    }

    /**
     * Retorna una representació de l'arc en String del tipus {nodeA, pes}
     * @return una representació de l'arc en String del tipus {nodeA, pes}
     */
    @Override
    public String toString() {
        return "{ " + nodeA + " , " + nodeB + " ( "+pes+" )}";
    }
}
