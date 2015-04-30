package org.grupwiki.graf;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 * Aquesta classe representa una Comunitat, la qual és un conjunt de nodes.
 * @param <T>
 */

public class Comunitat<T> {
    protected HashSet<T> nodes;

    /**
     * Constructor per defecte, a partir d'un identificador <tt>id</tt> inicialitza les estructures internes
     */
    public Comunitat() {
        nodes = new HashSet<T>();
    }

    /**
     * Constructor on un node es la seva propia comunitat
     * @param node
     */
    public Comunitat(T node) {
        this.nodes = new HashSet<T>();
        this.nodes.add(node);
    }

    /**
     * Afegeix un node <tt>node</tt> a la comunitat
     * @param node
     */
    public void afegirNode(T node){
        nodes.add(node);
    }

    public void eliminarNode(T node) {
        nodes.remove(node);
    }

    /**
     * Retorna la mida de la comunitat, és a dir, el nombre de nodes que la componen
     * @return la mida de la comunitat
     */
    public int mida(){
        return nodes.size();
    }


    public HashSet<T> getNodes() {
        return nodes;
    }

    public boolean estaBuida() {return nodes.isEmpty();}

    @Override
    public String toString() {
        String s = "(";
        int i = 0;
        for(T t : nodes){
            s+= t.toString();
            if(i != nodes.size()-1)
                s+=", ";
            ++i;
        }
        s+=")";
        return s;
    }
}
