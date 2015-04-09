    //S'ha de posar al Projecte propi
public class Node<T> {
    private T id;

    public Node(T id) {
        this.id = id;
    }

    public T getDades() {
        return id;
    }

    public void setDades(T dades) {
        this.id = dades;
    }

    @Override
    public String toString() {
        return id.toString();
    }

}
