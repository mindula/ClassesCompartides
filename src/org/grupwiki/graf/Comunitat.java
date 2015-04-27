package org.grupwiki.graf;

import java.util.ArrayList;

/**
 * Aquesta classe representa una Comunitat, la qual és un conjunt de nodes.
 * @param <T>
 */

public class Comunitat<T> {
    private int id;
    protected ArrayList<T> nodes;

    /**
     * Constructor per defecte, a partir d'un identificador <tt>id</tt> inicialitza les estructures internes
     * @param id
     */
    public Comunitat(int id) {
        nodes = new ArrayList<T>();
        this.id = id;
    }

    /**
     * Afegeix un node <tt>node</tt> a la comunitat
     * @param node
     */
    public void afegirNode(T node){
        nodes.add(node);
    }

    /**
     * Retorna la mida de la comunitat, és a dir, el nombre de nodes que la componen
     * @return la mida de la comunitat
     */
    public int mida(){
        return nodes.size();
    }


    public ArrayList<T> getComunitat() {
        return nodes;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        String s = "(";
        for( int i = 0 ; i<nodes.size(); i++){
            s+= nodes.get(i).toString();
            if(i != nodes.size()-1)
                s+=", ";
        }
        s+=")";
        return s;
    }
}
