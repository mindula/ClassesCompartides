import java.util.*;

public class Graf<T> {

    private Map<T, ArrayList<Arc<T>>> adjacencyMap;
    private int V, E;

    /**
     * Crea un graf buit
     */
    public Graf() {
        adjacencyMap = new HashMap<T, ArrayList<Arc<T>>>();
        V = E = 0;
    }

    /**
     *
     * @return nombre d'arcs del graf
     */
    public int mida() {
        return E;
    }

    /**
     *
     * @return nombre de nodes del graf
     */
    public int ordre() {
        return V;
    }

    /**
     *
     * @param node a afegir.
     * @throws RuntimeException si el node ja es al graf previament
     */
    public void afegirNode(T node) {
        if(adjacencyMap.containsKey(node))
            throw new RuntimeException("No es pot inserir el mateix node multiples vegades al mateix graf");

        adjacencyMap.put(node, new ArrayList<Arc<T>>());
        ++V;
    }

    /**
     *
     * @param nodeOrigen
     * @param nodeDesti
     */
    public void afegirArc(T nodeOrigen, T nodeDesti) {
        afegirArc(nodeOrigen, nodeDesti, 0);
    }

    public void afegirArc(T nodeOrigen, T nodeDesti, double pes) {
        if (!adjacencyMap.containsKey(nodeOrigen))
            throw new  RuntimeException("El node origen ha d'estar previament al graf");
        if (!adjacencyMap.containsKey(nodeDesti))
            throw new  RuntimeException("El node desti ha d'estar previament al graf");
        adjacencyMap.get(nodeOrigen).add(new Arc<T>(pes, nodeDesti));
        ++E;
    }


    public void eliminarNode(T node) {
        if(!adjacencyMap.containsKey(node))
            throw new RuntimeException("No es pot eliminar un node que no està dins el graf");

        for(T b : adjacencyMap.keySet()){
            ArrayList<Arc<T>> bAdjacents = adjacencyMap.get(b);
            int i = 0;
            while(i <bAdjacents.size()) {
                Arc<T> a = bAdjacents.get(i);
                if (a.getNodeDesti() == node) {
                    bAdjacents.remove(a);
                    --E;
                } else i++;
            }
        }

        ArrayList<Arc<T>> nodeAdjacents = adjacencyMap.get(node);
        E -= nodeAdjacents.size();
        adjacencyMap.remove(node);
        --V;
    }

    /**
     *
     * @param nodeOrigen
     * @param nodeDesti
     */
    public void eliminarArcs(T nodeOrigen, T nodeDesti) {
        ArrayList<Arc<T>> bAdjacents = adjacencyMap.get(nodeOrigen);
        boolean trobat = false;
        int i = 0;
        while(i < bAdjacents.size()) {
            Arc<T> a = bAdjacents.get(i);
            if (a.getNodeDesti() == nodeDesti) {
                bAdjacents.remove(a);
                --E;
                trobat = true;
            } ++i;
        }
        if(!trobat)
            throw new RuntimeException("L'arc no existeix");
    }

    public Set<T> getNodes() {
        return adjacencyMap.keySet();
    }

    public ArrayList<Arc<T>> getNodesAdjacents(T node) {
        return adjacencyMap.get(node);
    }

    public int getGrau (T node) {
        return adjacencyMap.get(node).size();
    }

    public boolean existeixNode(T node) {
        return adjacencyMap.containsKey(node);
    }

    public boolean existeixArc(T nodeOrigen, T nodeDesti) {
        if (!adjacencyMap.containsKey(nodeOrigen))
            throw new  RuntimeException("El node origen ha d'estar previament al graf");
        if (!adjacencyMap.containsKey(nodeDesti))
            throw new  RuntimeException("El node desti ha d'estar previament al graf");
        ArrayList<Arc<T>> bAdjacents = adjacencyMap.get(nodeOrigen);
        int i = 0;
        while (i < bAdjacents.size()) {
            Arc<T> a = bAdjacents.get(i);
            if (a.getNodeDesti() == nodeDesti) {
                return true;
            } ++i;
        }
        return false;
    }

    @Override
    public String toString() {
        return adjacencyMap.toString();
    }
}
