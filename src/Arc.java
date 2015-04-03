
public class Arc {
    private double pes;
    private Node node;

    public Arc(double pes, Node node) {
        this.pes = pes;
        this.node = node;
    }

    public double getPes() {
        return pes;
    }

    public void setPes(double pes) {
        this.pes = pes;
    }

    public Node getNode() {
        return node;
    }

    public void setNode(Node node) {
        this.node = node;
    }
}
