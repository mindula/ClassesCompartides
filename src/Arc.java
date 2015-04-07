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
     * Retorna una representació de l'arc en String
     * @return una representació de l'arc en String
     */
    @Override
    public String toString() {
        return "{" + nodeDesti + "," + pes + "}";
    }
}
