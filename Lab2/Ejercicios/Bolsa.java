package Lab2.Ejercicios;

import java.util.ArrayList;
import java.util.Iterator;

// Clase generica Bolsa - Actividad 2
public class Bolsa<T> implements Iterable<T> {

    private ArrayList<T> lista = new ArrayList<T>();
    private int tope;

    // Constructor con tope
    public Bolsa(int tope) {
        super();
        this.tope = tope;
    }

    // Constructor sin parametros (tope por defecto: 100)
    public Bolsa() {
        super();
        this.tope = 100;
    }

    // Agrega un objeto si no se ha llegado al tope
    public void add(T objeto) {
        if (lista.size() < tope) {
            lista.add(objeto);
        } else {
            throw new RuntimeException("no caben mas");
        }
    }

    // Retorna el iterador de la lista
    public Iterator<T> iterator() {
        return lista.iterator();
    }

    // Tamano actual de la bolsa
    public int size() {
        return lista.size();
    }
}
