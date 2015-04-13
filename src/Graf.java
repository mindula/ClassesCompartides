/*************************************************************************
 *  Compilació:   javac Graf.java
 *  Execució:     java Graf
 *  Dependències: Map.java Arc.java
 *
 *  Un graf no dirigit amb pesos a les arestes, implementat utilitzant llistes
 *  d'adjacències
 *
 *************************************************************************/

/**
 *  La classe <tt>Graf</tt> representa un graf no dirigit amb pesos als arcs,
 *  amb vèrtex parametritzats; cada arc és del tipus {@link Arc}
 *  i té un pes en el rang dels reals.
 *  La classe suporta un seguit d'opracions primaries: afegir un node,
 *  afegir un arc amb pes entre dos nodes del graf, iterar sobre tots els arcs
 *  incidents d'un node donat, i les conseqüents operacions d'eliminar un node del
 *  graf i eliminar els arcs entre dos nodes donats.
 *  A més la classe proporciona un seguit de mètodes per retornar el nombre
 *  de vèrtex <em>V</em> i el nombre d'arestes <em>E</em>, anomenats ordre i
 *  mida respectivament. També es pot consultar el nombre d'arcs adjacents a un
 *  node, consultar si existeix un node en concret dins el graf i consultar
 *  si hi ha algun arc entre dos nodes donats.
 *  IMPORTANT: el paràmetre T ha d'implementar la funció equals que el programador
 *  trobi pertinent. A més, es recomana tenir la classe Graf en un package
 *  individual, donat que un dels seus atributs és protected.
 *  <p>
 *  Aquesta implementació utilitza llistes d'adjacència per representar
 *  el graf, què són un seguit de Sets continguts dins un Map.
 *  Degut a això, es permet afegir més d'un arc entre dos nodes donats.
 *  És responsabilitat del programador les possibles conseqüencies que això
 *  podria suposar.
 *  <p>
 */

import java.util.*;

public class Graf<T> {

    protected Map<T, Set<Arc<T>>> adjacencyMap;
    private int V, E;

    /**
     * Inicialitza un Graf buit
     */
    public Graf() {
        adjacencyMap = new HashMap<T, Set<Arc<T>>>();
        V = E = 0;
    }

    /**
     * Constructor còpia. Còpia un graf <tt>other</tt> al paràmetre implicit
     * @param other
     */
    public Graf(Graf<T> other) {
        adjacencyMap = new HashMap<T, Set<Arc<T>>>();
        for (T n : other.adjacencyMap.keySet()){
            Set<Arc<T>> otherAdjacents = other.adjacencyMap.get(n);
            Set<Arc<T>> adjacents = new LinkedHashSet<Arc<T>>();
            for (Arc<T> otherArc : otherAdjacents){
                Arc<T> arc;

                if(adjacencyMap.containsKey(otherArc.getNodeA()) || adjacencyMap.containsKey(otherArc.getNodeA()) ){
                    arc = getArcEntre(otherArc.getNodeA(), otherArc.getNodeB());
                }
                else{
                    arc = new Arc<T>(otherArc);
                }
                adjacents.add(arc);

            }
            adjacencyMap.put(n, adjacents);
        }
    }

    /**
     * Retorna el nombre d'arcs del graf
     * @return el nombre d'arcs del graf
     */
    public int mida() {
        return E;
    }

    /**
     * Retorna el nombre de vèrtex del graf
     * @return el nombre de vèrtex del graf
     */
    public int ordre() {
        return V;
    }

    /**
     * Afegeix un node <tt>node</tt> al graf
     * @param node a afegir.
     * @throws RuntimeException si el node ja es al graf previament
     */
    public void afegirNode(T node) {
        if(adjacencyMap.containsKey(node))
            throw new RuntimeException("No es pot inserir el mateix node multiples vegades al mateix graf");

        adjacencyMap.put(node, new LinkedHashSet<Arc<T>>());
        ++V;
    }

    /**
     * Afegeix un arc <tt>a</tt>
     * @param a
     * @throws RuntimeException quan algun dels dos nodes no existeix al graf
     */
    public void afegirArc(Arc<T> a) {
        if (!adjacencyMap.containsKey(a.getNodeA()))
            throw new  RuntimeException("El node origen ha d'estar previament al graf");
        if (!adjacencyMap.containsKey(a.getNodeB()))
            throw new  RuntimeException("El node desti ha d'estar previament al graf");

        if(adjacencyMap.get(a.getNodeA()).contains(a)){
                throw new  RuntimeException("L'arc ja existeix");
        }
        else{
            adjacencyMap.get(a.getNodeA()).add(a);
            adjacencyMap.get(a.getNodeB()).add(a);
            ++E;
        }

    }


    /**
     * Elimina un node <tt>node</tt> del graf.
     * @param node
     * @throws RuntimeException si el node <tt>node</tt> no existeix al graf
     */
    public void eliminarNode(T node) {
        if(!adjacencyMap.containsKey(node))
            throw new RuntimeException("No es pot eliminar un node que no està dins el graf");

        adjacencyMap.remove(node);
        --V;
    }


    public void eliminarArc(Arc<T> arc) {

        Set<Arc<T>> aAdjacents = adjacencyMap.get(arc.getNodeA());
        Set<Arc<T>> bAdjacents = adjacencyMap.get(arc.getNodeB());

        if(! aAdjacents.remove(arc) || !bAdjacents.remove(arc))
            throw new RuntimeException("L'arc no existeix");

        --E;
    }

    /**
     * Retorna un Set amb tots els nodes del graf
     * @return un Set amb tots els nodes del graf
     */
    public Set<T> getNodes() {
        return adjacencyMap.keySet();
    }

    /**
     * Retorna una Set amb els arcs que surten d'un node <tt>node</tt>
     * @param node
     * @return una Set amb els arcs que surten d'un node <tt>node</tt>
     */
    public Set<Arc<T>> getNodesAdjacents(T node) {
        return adjacencyMap.get(node);
    }

    /**
     * Retorna l'arc entre <tt>nodeA</tt> i <tt>nodeB</tt>
     * @param nodeA
     * @param nodeB
     * @return l'arc entre <tt>nodeA</tt> i <tt>nodeB</tt>
     */
    private Arc<T> getArcEntre(T nodeA, T nodeB){
        Arc<T> arc = null;
        Set<Arc<T>> adjacentsA = adjacencyMap.get(nodeA);
        for(Arc<T> a : adjacentsA){
            if(a.getNodeB() == nodeB || a.getNodeA() == nodeB){
                arc = a;
                break;
            }
        }
        return arc;
    }

    /**
     * Retorna un nombre corresponent al nombre d'arcs que surten d'un node <tt>node</tt>
     * @param node
     * @return un nombre corresponent al nombre d'arcs que surten d'un node <tt>node</tt>
     */
    public int getGrau (T node) {
        return adjacencyMap.get(node).size();
    }

    /**
     * Retorna un valor indicant si existeix un node <tt>node</tt> dins el graf
     * @param node
     * @return un valor indicant si existeix un node <tt>node</tt> dins el graf
     */
    public boolean existeixNode(T node) {
        return adjacencyMap.containsKey(node);
    }

    /**
     * Retorna un valor indicant si existeix un arc del node <tt>nodeOrigen</tt> a
     * <tt>nodeDesti</tt>
     * @param nodeOrigen
     * @param nodeDesti
     * @return un valor indicant si existeix un arc del node <tt>nodeOrigen</tt> a
     * <tt>nodeDesti</tt>
     */
    public boolean existeixArc(T nodeOrigen, T nodeDesti) {
        if (!adjacencyMap.containsKey(nodeOrigen))
            throw new  RuntimeException("El node origen ha d'estar previament al graf");
        if (!adjacencyMap.containsKey(nodeDesti))
            throw new  RuntimeException("El node desti ha d'estar previament al graf");

        for(Arc<T> arc : adjacencyMap.get(nodeDesti)){
            if(arc.getNodeA() == nodeOrigen ||arc.getNodeB() == nodeOrigen)
                return true;
        }
        return false;
    }

    /**
     * Retorna una representació en String del graf
     * @return una representació en String del graf
     */
    @Override
    public String toString() {
        return adjacencyMap.toString();
    }

}
