import java.util.ArrayList;
import java.util.Iterator;

// Clase Cajoneria generica - Ejercicios 3, 4 y 6
// Guarda objetos de tipo T dentro de Cajas con color
public class Cajoneria<T> implements Iterable<T> {

    private ArrayList<Caja<T>> lista = new ArrayList<Caja<T>>();
    private int tope;

    // Lista de colores para asignar automaticamente a cada caja
    private static String[] COLORES = {
        "Rojo", "Amarillo", "Verde", "Azul", "Naranja",
        "Morado", "Rosa", "Celeste", "Blanco", "Negro"
    };

    public Cajoneria(int tope) {
        this.tope = tope;
    }

    public Cajoneria() {
        this.tope = 100;
    }

    // Agrega un objeto T en una nueva Caja con color automatico
    public void add(T objeto) {
        if (lista.size() < tope) {
            String color = COLORES[lista.size() % COLORES.length];
            lista.add(new Caja<T>(color, objeto));
        } else {
            throw new RuntimeException("no caben mas");
        }
    }

    // Agrega un objeto T en una Caja con color especifico
    public void add(T objeto, String color) {
        if (lista.size() < tope) {
            lista.add(new Caja<T>(color, objeto));
        } else {
            throw new RuntimeException("no caben mas");
        }
    }

    // Ejercicio 4.1: busca un elemento y retorna posicion y color de su caja
    // Retorna null si no lo encuentra
    public String search(T elemento) {
        for (int i = 0; i < lista.size(); i++) {
            if (lista.get(i).getObjeto().equals(elemento)) {
                return "Posicion: " + (i + 1) + ", Color de caja: " + lista.get(i).getColor();
            }
        }
        return null; // no encontrado
    }

    // Ejercicio 4.2: elimina un elemento de la cajoneria y lo retorna
    // Retorna null si no lo encuentra
    public T delete(T elemento) {
        for (int i = 0; i < lista.size(); i++) {
            if (lista.get(i).getObjeto().equals(elemento)) {
                T eliminado = lista.get(i).getObjeto();
                lista.remove(i);
                return eliminado;
            }
        }
        return null; // no encontrado
    }

    // Ejercicio 6: cuenta cuantas veces aparece un elemento en la cajoneria
    public int contar(T elemento) {
        int count = 0;
        for (Caja<T> caja : lista) {
            if (caja.getObjeto().equals(elemento)) {
                count++;
            }
        }
        return count;
    }

    // Ejercicio 4.3: toString con tabla de posicion, color y objeto
    @Override
    public String toString() {
        String resultado = String.format("%-10s %-12s %-30s%n", "Posicion", "Color Caja", "Objeto");
        for (int i = 0; i < lista.size(); i++) {
            resultado += String.format("%-10d %-12s %-30s%n",
                    (i + 1),
                    lista.get(i).getColor(),
                    lista.get(i).getObjeto().toString());
        }
        return resultado;
    }

    // Iterador para recorrer los objetos T (no las cajas)
    public Iterator<T> iterator() {
        // Iterador anonimo que recorre los objetos dentro de las cajas
        return new Iterator<T>() {
            int index = 0;
            public boolean hasNext() { return index < lista.size(); }
            public T next()          { return lista.get(index++).getObjeto(); }
        };
    }

    public int size() {
        return lista.size();
    }
}
