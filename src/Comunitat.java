import java.util.ArrayList;

public class Comunitat<T> {
    int id;
    ArrayList<T> nodes;

    public Comunitat(int id) {
        nodes = new ArrayList<T>();
        this.id = id;
    }

    public void afegirNode(T node){
        nodes.add(node);
    }

    public int mida(){
        return nodes.size();
    }
}
