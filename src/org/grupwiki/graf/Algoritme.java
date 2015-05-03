package org.grupwiki.graf;

/**
 * Grup 3: Wikipedia
 * Usuari: agusti.bau
 * Data: 10/3/15
 */

/**
 * Aquesta classe cerca comunitats en un graf a partir d'un seguit de paràmetres
 * @param <T>
 */

public abstract class Algoritme<T>  {
    public abstract ConjuntComunitats<T> cercarComunitats(Graf<T> graf, int k, int l);
}
