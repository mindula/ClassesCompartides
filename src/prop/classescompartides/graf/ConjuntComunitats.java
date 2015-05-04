package prop.classescompartides.graf;

/**
 * Grup 3: Wikipedia
 * Usuari: agusti.bau
 * Data: 10/3/15
 */

import java.util.ArrayList;

/**
 * Aquesta classe representa un conjunt de Comunitats, amb un seguit d'operacions bàsiques
 * @param <T>
 */

public class ConjuntComunitats<T> {
    protected ArrayList<Comunitat<T>> cjtComunitats;

    /**
     * Constructor per defecte, inicialitza les estructures internes de la classe
     */
    public ConjuntComunitats() {
        cjtComunitats = new ArrayList<Comunitat<T>>();
    }

    /**
     * Afegeix una comunitat al conjunt
     * @param c
     */
    public void afegirComunitat(Comunitat<T> c) {
        this.cjtComunitats.add(c);
    }

    /**
     * Retorna el nombre de comunitats que pertanyen al conjunt
     * @return el nombre de comunitats que pertanyen al conjunt
     */
    public int getNumComunitats() {
        return cjtComunitats.size();
    }

    /**
     * Retorna la comunitat amb id <tt>id</tt>
     * @param id
     * @return la comunitat amb id <tt>id</tt>
     */
    public Comunitat<T> getComunitat(int id) throws Exception{
        for (Comunitat<T> c : cjtComunitats) {
            if (c.getId() == id) {
                return c;
            }
        }
        throw new Exception("No hi ha una comunitat amb aquesta id");
    }

    /**
     * Elimina una comunitat <tt>c</tt>
     * @param c
     */
    public void eliminarComunitat(Comunitat<T> c) {
        cjtComunitats.remove(c);
    }

    /**
     * Retorna una ArrayList de Comunitats
     * @return una ArrayList de Comunitats
     */
    public ArrayList<Comunitat<T>> getComunitats() {
        return cjtComunitats;
    }

    /**
     * Retorna una stirng que representa un conjunt de comunitats
     * @return una stirng que representa un conjunt de comunitats
     */
    @Override
    public String toString() {
        String s = "{";
        for(int i = 0; i<cjtComunitats.size(); i++){
            s+=cjtComunitats.get(i).toString();
            if(i != cjtComunitats.size()-1)
                s+="\n";
        }
        s+="}";
        return s;
    }
}
