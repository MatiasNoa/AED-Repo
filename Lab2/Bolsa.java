package Lab2;

import java.util.ArrayList;
import java.util.Iterator;

public class Bolsa<T> implements Iterable<T> {

    private ArrayList<T> lista = new ArrayList<>();
    private int limite = 5;

    public void add(T objeto) {
        if (lista.size() < limite) {
            lista.add(objeto);
        } else {
            System.out.println("Bolsa llena");
        }
    }

    @Override
    public Iterator<T> iterator() {
        return lista.iterator();
    }
}