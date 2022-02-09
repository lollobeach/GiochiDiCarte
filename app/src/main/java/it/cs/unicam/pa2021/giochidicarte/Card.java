package it.cs.unicam.pa2021.giochidicarte;

/**
 * Interfaccia che definisce
 * come una carta dovrebbe essere
 * identificata
 */
public interface Card<T> {

      T getIdentity();

      String toString();
}
