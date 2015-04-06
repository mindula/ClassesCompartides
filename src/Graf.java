import java.util.*;

public class Graf<T> {

    private Map<T, ArrayList<Arc<T>>> adjacencyMap;
    private int V, E;

    public Graf() {
        adjacencyMap = new HashMap<T, ArrayList<Arc<T>>>();
        V = E = 0;
    }

    public int mida() {
        return E;
    }

    public int ordre() {
        return V;
    }

    public void afegirNode(T node) {
        if(adjacencyMap.containsKey(node))
            throw new RuntimeException("No es pot inserir el mateix node multiples vegades al mateix graf");

        adjacencyMap.put(node, new ArrayList<Arc<T>>());
        ++V;
    }

    public void afegirArc(T origen, T desti) {
       afegirArc(origen, desti, 0);
    }

    public void afegirArc(T origen, T desti, double pes) {
        if (!adjacencyMap.containsKey(origen))
            throw new  RuntimeException("El node origen ha d'estar previament al graf");

        if (!adjacencyMap.containsKey(origen))
            throw new  RuntimeException("El node desti ha d'estar previament al graf");

            adjacencyMap.get(origen).add(new Arc<T>(pes, desti));
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
                }
                else{
                    i++;
                }
            }
        }

        ArrayList<Arc<T>> nodeAdjacents = adjacencyMap.get(node);
        E -= nodeAdjacents.size();
        adjacencyMap.remove(node);
        --V;
    }

    public void eliminarArc(T origen, T desti) {
        ArrayList<Arc<T>> bAdjacents = adjacencyMap.get(origen);
        boolean trobat = false;
        int i = 0;
        while(i < bAdjacents.size() && !trobat) {
            Arc<T> a = bAdjacents.get(i);
            if (a.getNodeDesti() == desti) {
                bAdjacents.remove(a);
                --E;
                trobat = true;
            }
        }

        if(!trobat){
            throw new RuntimeException("El arc no existeix");
        }
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

    @Override
    public String toString() {
        return adjacencyMap.toString();
    }
}
