import java.util.*;

public class DriverGraf {

    private int type;
    Graf<NodeProva> G;

    public void print(Object o) {
        System.out.println(o);

    }

    public void main() {
        G = new Graf<NodeProva>();
        G.afegirNode(new NodeProva("Ricard"));
        G.afegirNode(new NodeProva("Guillem"));
        G.afegirNode(new NodeProva("Albert"));
        G.afegirNode(new NodeProva("Eudald"));
        G.afegirArc(new NodeProva("Ricard"), new NodeProva("Albert"));
        G.modificarPesArc(new NodeProva("Ricard"), new NodeProva("Albert"), 42);
        G.afegirArc(new NodeProva("Ricard"), new NodeProva("Eudald"));
        G.afegirArc(new NodeProva("Eudald"), new NodeProva("Ricard"));
        print(G.mida() + " " + G.ordre());
        print(G);
        print(G.existeixArc(new NodeProva("Ricard"), new NodeProva("Eudald")));
        G.eliminarNode(new NodeProva("Ricard"));
        //G.eliminarArc(new NodeProva("Ricard"), new NodeProva("Albert"));
        print (G.mida() + " " + G.ordre());
        print(G);
        print(G.existeixArc(new NodeProva("Albert"), new NodeProva("Eudald")));

    }
}
