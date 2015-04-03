
public class DriverGraf {
    public void main() {
        GrafProva G = new GrafProva();
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

        G.afegirArc(n, new Arc(1, n1));
        G.afegirArc(n1, new Arc(1, n2));
        G.afegirArc(n1, new Arc(1, n3));
        G.afegirArc(n, new Arc(1,n2));
        G.afegirArc(n2, new Arc(1,n3));

        System.out.print("mida(arcs): " + G.mida() + " deberia ser: 5");
        System.out.print("ordre(arcs): " + G.ordre() + " deberia ser: 4");
        System.out.print("Treiem node n2");
        System.out.print("mida(arcs): " + G.mida() + " deberia ser: 2");
        System.out.print("ordre(arcs): "+G.ordre()+" deberia ser: 3");

        System.out.println(G);
        System.out.println(G.getNodesAdjacents(n3));
        System.out.println("Size: " + G.mida());
        System.out.println("Order: " + G.ordre());
    }
}
