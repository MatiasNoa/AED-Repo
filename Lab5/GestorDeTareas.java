import java.util.ArrayList;
import java.util.List;

// Gestor de tareas genérico usando lista enlazada propia
public class GestorDeTareas<T> {

    private ListLinked<T> lista;          // tareas pendientes
    private List<T> completadas;          // tareas finalizadas

    public GestorDeTareas() {
        lista = new ListLinked<>();
        completadas = new ArrayList<>();
    }

    public void agregarTarea(T tarea) {
        lista.insertLast(tarea);
        System.out.println("  [+] Agregada: " + tarea);
    }

    public boolean eliminarTarea(T tarea) {
        if (lista.search(tarea) != -1) {
            lista.removeNode(tarea);
            System.out.println("  [-] Eliminada: " + tarea);
            return true;
        }
        System.out.println("  [!] No se encontro: " + tarea);
        return false;
    }

    public boolean contieneTarea(T tarea) {
        return lista.search(tarea) != -1;
    }

    public void imprimirTareas() {
        if (lista.isEmptyList()) {
            System.out.println("  (Lista vacia)");
            return;
        }
        Node<T> current = lista.getFirst();
        int i = 1;
        while (current != null) {
            System.out.println("  " + i + ". " + current.value);
            current = current.next;
            i++;
        }
    }

    public int contarTareas() {
        return lista.length();
    }

    public T obtenerTareaMasPrioritaria() {
        if (lista.isEmptyList()) return null;

        Node<T> current = lista.getFirst();
        T masPrioritaria = current.value;

        while (current != null) {
            if (current.value instanceof Tarea && masPrioritaria instanceof Tarea) {
                Tarea tActual = (Tarea) current.value;
                Tarea tMejor  = (Tarea) masPrioritaria;
                if (tActual.getPrioridad() > tMejor.getPrioridad()) {
                    masPrioritaria = current.value;
                }
            }
            current = current.next;
        }
        return masPrioritaria;
    }

    public void invertirTareas() {
        Node<T> prev    = null;
        Node<T> current = lista.getFirst();
        Node<T> next    = null;

        while (current != null) {
            next = current.next;   // guardar referencia al siguiente
            current.next = prev;   // invertir el enlace
            prev = current;        // avanzar prev
            current = next;        // avanzar current
        }

        lista.setFirst(prev); // el nuevo primero es el antiguo ultimo
        System.out.println("  [*] Lista invertida.");
    }

    public void completarTarea(T tarea) {
        if (lista.search(tarea) != -1) {
            lista.removeNode(tarea);
            completadas.add(tarea);
            System.out.println("  [OK] Tarea completada: " + tarea);
        } else {
            System.out.println("  [!] Tarea no encontrada para completar: " + tarea);
        }
    }

    public void imprimirCompletadas() {
        if (completadas.isEmpty()) {
            System.out.println("  (No hay tareas completadas)");
            return;
        }
        int i = 1;
        for (T t : completadas) {
            System.out.println("  " + i + ". " + t);
            i++;
        }
    }

    public ListLinked<T> getLista() {
        return lista;
    }
}
