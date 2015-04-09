import java.util.ArrayList;

/**
 * Created by Agusti Bau on 09/04/15.
 */
public abstract class Algoritme<T>  {

    public class Comunitat<T>{
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

    abstract ArrayList<Comunitat<T>> cercarComunitats(Graf<T> graf);
}
