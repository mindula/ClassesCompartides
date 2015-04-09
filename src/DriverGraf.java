import java.util.*;

public class DriverGraf {

    private int type;
    Graf<NodeProva> G;

    public void print(Object o) {
        System.out.println(o);

    }

    public void main() {
        /*G = new Graf<Integer>();
        Scanner input = new Scanner(System.in);
        print("Entri els nodes del graf:");
        input = new Scanner(System.in);
        while (input.hasNextInt()) {
            G.afegirNode(input.nextInt());
        }
        print("Entra les conexions que desitgis, amb el seu pes:");
        input = new Scanner(System.in);
        while (input.hasNextInt()) {
            int o = input.nextInt();
            int d = input.nextInt();
            double p = input.nextInt();
            G.afegirArc(o, d, p);
        }
        print(G);*/
        G = new Graf<NodeProva>();
        G.afegirNode(new NodeProva("Ricard"));
        G.afegirNode(new NodeProva("Guillem"));
        G.afegirNode(new NodeProva("Albert"));
        //G.afegirArc(new NodeProva("Ricard"), new NodeProva("Albert"));
        //G.afegirArc(new NodeProva("Ricard"), new NodeProva("Albert"), 42);
        G.eliminarArc(new NodeProva("Ricard"), new NodeProva("Albert"));
        print(G);

    }
}
