package it.cs.unicam.pa2021.giochidicarte;

/**
 * Interfaccia che definisce
 * come una carta dovrebbe essere
 * identificata
 *
 * @param <T> tipo di identificativo
 *           utilizzato
 */
public interface Card<T> {

      /**
       * Metodo che definisce
       * l'identit&agrave; di
       * una carta
       *
       * @return identit&agrave;
       * della carta
       */
      T getIdentity();

      /**
       * Metodo che ritorna
       * le informazioni della carta
       *
       * @return stringa contenente
       * la descrizione della carta
       */
      String toString();
}
