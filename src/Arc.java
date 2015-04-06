
public class Arc<T> {
    private double pes;
    private T nodeDesti;
    
    public Arc(T nodeDesti) {
        this.pes = 0;
        this.nodeDesti = nodeDesti;
    }

    public Arc(double pes, T nodeDesti) {
        this.pes = pes;
        this.nodeDesti = nodeDesti;
    }

    public double getPes() {
        return pes;
    }

    public void setPes(double pes) {
        this.pes = pes;
    }

    public T getNodeDesti() {
        return nodeDesti;
    }

    public void setNodeDesti(T nodeDesti) {
        this.nodeDesti = nodeDesti;
    }

    @Override
    public String toString() {
        return "{" + nodeDesti + "," + pes + "}";
    }
}
