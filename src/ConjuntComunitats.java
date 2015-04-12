import java.util.ArrayList;

/**
 *
 * @param <T>
 */

public class ConjuntComunitats<T> {
    private ArrayList<Comunitat<T>> cjtComunitats;

    public ConjuntComunitats() {
        cjtComunitats = new ArrayList<Comunitat<T>>();
    }

    public void afegirCominitat(Comunitat<T> c) {
        this.cjtComunitats.add(c);
    }

    public int getNumComunitats() {
        return cjtComunitats.size();
    }

    public Comunitat<T> getComunitat(int i) {
        return cjtComunitats.get(i);
    }


}
