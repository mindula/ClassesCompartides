
public class DriverGraf {
    public void main() {
        Graf<NodeLouvain> G = new Graf<NodeLouvain>();
        String s = "Ricard";
        String s1 = "Peter";
        String s2 = "Juliana";
        String s3 = "Sopas";

        NodeLouvain n = new NodeLouvain(s);
        NodeLouvain n1 = new NodeLouvain(s1);
        NodeLouvain n2 = new NodeLouvain(s2);
        NodeLouvain n3 = new NodeLouvain(s3);

        G.afegirNode(n);
        G.afegirNode(n1);
        G.afegirNode(n2);
        G.afegirNode(n3);

        G.afegirArc(n, n1, 1);
        G.afegirArc(n1, n2, 1);
        G.afegirArc(n1, n3, 1);
        G.afegirArc(n, n2, 2);
        G.afegirArc(n2, n3, 1);

        System.out.println("mida(arcs): " + G.mida() + " deberia ser: 5");
        System.out.println("ordre(arcs): " + G.ordre() + " deberia ser: 4");
        System.out.println("Treiem node n2");
        G.eliminarNode(n2);
        G.eliminarArc(n, n1);
        System.out.println("mida(arcs): " + G.mida() + " deberia ser: 2");
        System.out.println("ordre(arcs): "+G.ordre()+" deberia ser: 3");

        System.out.println(G);
        System.out.println(G.getNodesAdjacents(n));
        System.out.println("Size: " + G.mida());
        System.out.println("Order: " + G.ordre());
    }
}
