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
        adjacencyMap.put(node, new ArrayList<Arc<T>>());
        ++V;
    }

    public void afegirArc(T origen, T desti) {
        if (adjacencyMap.containsKey(origen)) {
            adjacencyMap.get(origen).add(new Arc<T> (desti));
            ++E;
        } else {
            System.out.println("No existeix el node origen");
        }
    }

    public void afegirArc(T origen, T desti, double pes) {
        if (adjacencyMap.containsKey(origen)) {
            adjacencyMap.get(origen).add(new Arc<T> (pes, desti));
            ++E;
        } else {
            System.out.println("No existeix el node origen");
        }
    }


    public void eliminarNode(T node) {
        for(T b : adjacencyMap.keySet()){
            ArrayList<Arc<T>> bAdjacents = adjacencyMap.get(b);
            for (Arc<T> a : bAdjacents) {
                if (a.getNodeDesti() == node) {
                    bAdjacents.remove(a);
                    --E;
                    break;
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
        for (Arc<T> a : bAdjacents) {
            if (a.getNodeDesti() == desti) {
                bAdjacents.remove(a);
                --E;
                break;
            }
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
