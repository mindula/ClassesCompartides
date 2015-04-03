import java.lang.reflect.Array;
import java.util.*;

public abstract class Graf<T> {

    private Map<Node, ArrayList<T>> adjacencyList;
    private int V, E;

    public Graf() {
        adjacencyList = new HashMap<Node, ArrayList<T>>();
        V = E = 0;
    }

    public int mida() {
        return E;
    }

    public int ordre() {
        return V;
    }

    public void afegirNode(Node node) {
        adjacencyList.put(node, new ArrayList<T>());
        ++V;
    }

    public void afegirArc(Node origen, T desti) {
        if (adjacencyList.containsKey(origen)) {
            adjacencyList.get(origen).add(desti);
            ++E;
        } else {
            System.out.println("No existeix el node origen");
        }
    }

    public void eliminarNode(Node node) {
        //Falta acabar d'implementar l'operació
        for(Node n : adjacencyList.keySet()){
            ArrayList<T> adjacents = adjacencyList.get(n);
            if(adjacents.contains(node)){
                adjacents.remove(node);
            }
        }
        adjacencyList.remove(node);

        --V;
    }

    public void eliminarArc(Node origen, T desti) {
        adjacencyList.get(origen).remove(desti);
        --E;
    }

    public ArrayList<T> getNodesAdjacents(Node node) {
        return adjacencyList.get(node);
    }

    public int getGrau (Node node) {
        return adjacencyList.get(node).size();
    }

    public boolean existeixNode(Node node) {
        return adjacencyList.containsKey(node);
    }

    @Override
    public String toString() {
        return adjacencyList.toString();
    }
}
