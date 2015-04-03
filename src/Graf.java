import java.util.*;

public class Graf<T> {

    private Map<Node<T>, ArrayList<T>> adjacencyMap;
    private int V, E;

    public Graf() {
        adjacencyMap = new HashMap<Node<T>, ArrayList<T>>();
        V = E = 0;
    }

    public int mida() {
        return E;
    }

    public int ordre() {
        return V;
    }

    public void afegirNode(Node<T> node) {
        adjacencyMap.put(node, new ArrayList<T>());
        ++V;
    }

    public void afegirArc(Node<T> origen, T desti) {
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
            if(bAdjacents.contains(node.getDades())) {
                bAdjacents.remove(node.getDades());
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

    public Set<Node<T>> getNodes() {
        return adjacencyMap.keySet();
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
