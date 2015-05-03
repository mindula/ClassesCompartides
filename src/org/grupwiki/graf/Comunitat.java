package org.grupwiki.graf;

/**
 * Grup 3: Wikipedia
 * Usuari: agusti.bau
 * Data: 10/3/15
 */

import java.util.HashSet;

/**
 * Aquesta classe representa una Comunitat, la qual és un conjunt de nodes.
 * @param <T>
 */

public class Comunitat<T> {
    private int id;
    protected HashSet<T> nodes;

    /**
     * Constructor per defecte, a partir d'un identificador <tt>id</tt> inicialitza les estructures internes
     */
    public Comunitat() {
        nodes = new HashSet<T>();
    }

    public Comunitat(int id) {
        nodes = new HashSet<T>();
        this.id = id;
    }

    /**
     * Constructor on un node es la seva propia comunitat
     * @param node
     */
    public Comunitat(int id, T node) {
        this.nodes = new HashSet<T>();
        this.nodes.add(node);
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
     * Afegeix una altra comunitat al paràmetre implícit
     * @param c
     */
    public void afegirCjtNodes(Comunitat<T> c) {
        HashSet<T> s = c.getNodes();
        nodes.addAll(s);
    }

    /**
     * Elimina un node <tt>node</tt> del paràmetre implícit
     * @param node
     */
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

    /**
     * Retorna un HashSet dels nodes de la comunitat
     * @return un HashSet dels nodes de la comunitat
     */
    public HashSet<T> getNodes() {
        return nodes;
    }

    /**
     * Retorna la id de la comunitat
     * @return la id de la comunitat
     */
    public int getId() {
        return id;
    }

    /**
     * id de la comunitat passa a ser <tt>id</tt>
     * @param id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Retorna cert si la comunitat està buida
     * @return cert si la comunitat està buida
     */
    public boolean estaBuida() {return nodes.isEmpty();}

    /**
     * Retorna cert si existeix un node <tt>node</tt> dins la comunitat
     * @param node
     * @return
     */
    public boolean teNode(T node) {return nodes.contains(node);}

    /**
     * Converteix a String la comunitat
     * @return una string que representa la comunitat
     */
    @Override
    public String toString() {
        String s = "(";
        int i = 0;
        for(T t : nodes){
            s+= t.toString() + ", id:" + id;
            if(i != nodes.size()-1)
                s+=", ";
            ++i;
        }
        s+=")";
        return s;
    }
}
