import java.util.*;

public abstract class Graf<T> {

    private Map<Node, ArrayList<T>> adjacencyMap;
    private int V, E;

    public Graf() {
        adjacencyMap = new HashMap<Node, ArrayList<T>>();
        V = E = 0;
    }

    public int mida() {
        return E;
    }

    public int ordre() {
        return V;
    }

    public void afegirNode(Node node) {
        adjacencyMap.put(node, new ArrayList<T>());
        ++V;
    }

    public void afegirArc(Node origen, T desti) {
        if (adjacencyMap.containsKey(origen)) {
            adjacencyMap.get(origen).add(desti);
            ++E;
        } else {
            System.out.println("No existeix el node origen");
        }
    }

    public void eliminarNode(Node node) {
        for(Node b : adjacencyMap.keySet()){
            ArrayList<T> bAdjacents = adjacencyMap.get(b);
            if(bAdjacents.contains(node)) {
                bAdjacents.remove(node);
                --E;
            }
        }
        ArrayList<T> nodeAdjacents = adjacencyMap.get(node);
        E -= nodeAdjacents.size();
        adjacencyMap.remove(node);
        --V;
    }

    public void eliminarArc(Node origen, T desti) {
        adjacencyMap.get(origen).remove(desti);
        --E;
    }

    public ArrayList<T> getNodesAdjacents(Node node) {
        return adjacencyMap.get(node);
    }

    public int getGrau (Node node) {
        return adjacencyMap.get(node).size();
    }

    public boolean existeixNode(Node node) {
        return adjacencyMap.containsKey(node);
    }

    @Override
    public String toString() {
        return adjacencyMap.toString();
    }
}
