/*************************************************************************
 *  Compilació:   javac Arc.java
 *  Execució:     java Arc
 *
 *  Un arc amb un valor que representa el pes entre dos nodes concrets
 *  i un paràmetre T que representa el node al qual va destinat l'arc
 *
 *************************************************************************/

/**
 *  La classe <tt>Arc</tt> representa un arc amb pes, amb el nodeDesti parametritzat.
 */

public class Arc<T> {
    private double pes;
    private T nodeDesti;

    /**
     * Crea un arc amb pes 0 i un node de destí <tt>nodeDesti</tt>
      * @param nodeDesti
     */
    public Arc(T nodeDesti) {
        this.pes = 0;
        this.nodeDesti = nodeDesti;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Arc arc = (Arc) o;

        if (!nodeDesti.equals(arc.nodeDesti)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return nodeDesti.hashCode();
    }

    /**
     * Crea un arc amb pes <tt>pes</tt> i un node de destí <tt>nodeDesti</tt>
     * @param pes

     * @param nodeDesti
     */
    public Arc(double pes, T nodeDesti) {
        this.pes = pes;
        this.nodeDesti = nodeDesti;
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
     * Retorna el node de destí de l'arc
     * @return el node de destí de l'arc
     */
    public T getNodeDesti() {
        return nodeDesti;
    }

    /**
     * Modifica el node de destí a <tt>nodeDesti</tt>
     * @param nodeDesti
     */
    public void setNodeDesti(T nodeDesti) {
        this.nodeDesti = nodeDesti;
    }

    /**
     * Retorna una representació de l'arc en String del tipus {nodeDesti, pes}
     * @return una representació de l'arc en String del tipus {nodeDesti, pes}
     */
    @Override
    public String toString() {
        return "{" + nodeDesti + "," + pes + "}";
    }
}
