import java.util.ArrayList;
import java.util.List;

public class Ejercicios {

    // Busca un valor en una lista
    public static <T> boolean buscarElemento(List<T> lista, T valor) {
        for (T elemento : lista) {
            if (elemento.equals(valor)) return true;
        }
        return false;
    }

    // Retorna una nueva lista invertida (sin modificar la original)
    public static <T> List<T> invertirLista(List<T> lista) {
        List<T> invertida = new ArrayList<>();
        // Recorrer de atras hacia adelante e ir agregando al inicio
        for (int i = lista.size() - 1; i >= 0; i--) {
            invertida.add(lista.get(i));
        }
        return invertida;
    }

    // Inserta un valor al final de una lista enlazada
    public static <T> Node<T> insertarAlFinal(Node<T> head, T valor) {
        Node<T> newNode = new Node<>(valor);

        if (head == null)
            return newNode;

        Node<T> current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = newNode;
        return head;
    }

    // Cuenta los nodos de una lista enlazada
    public static <T> int contarNodos(Node<T> head) {
        int count = 0;
        Node<T> current = head;
        while (current != null) {
            count++;
            current = current.next;
        }
        return count;
    }

    // Compara si dos listas enlazadas son iguales (mismo contenido y orden)
    public static <T> boolean sonIguales(Node<T> lista1, Node<T> lista2) {
        Node<T> a = lista1;
        Node<T> b = lista2;

        while (a != null && b != null) {
            if (!a.value.equals(b.value)) return false;
            a = a.next;
            b = b.next;
        }

        return a == null && b == null;
    }

    // Concatena dos listas enlazadas en una nueva lista
    public static <T> Node<T> concatenarListas(Node<T> lista1, Node<T> lista2) {
        Node<T> cabecera = new Node<>(null);  // cabeza ficticia
        Node<T> tail = cabecera;

        // Copiar todos los nodos de lista1
        Node<T> current = lista1;
        while (current != null) {
            tail.next = new Node<>(current.value);
            tail = tail.next;
            current = current.next;
        }

        // Copiar todos los nodos de lista2
        current = lista2;
        while (current != null) {
            tail.next = new Node<>(current.value);
            tail = tail.next;
            current = current.next;
        }

        return cabecera.next;
    }

    public static <T> void imprimirNodos(Node<T> head, String etiqueta) {
        System.out.print(etiqueta + ": [");
        Node<T> current = head;
        while (current != null) {
            System.out.print(current.value);
            if (current.next != null) System.out.print(" -> ");
            current = current.next;
        }
        System.out.println("]");
    }

    public static void main(String[] args) {

        System.out.println("=== Ejercicio 1: buscarElemento ===");
        List<String> nombres = new ArrayList<>();
        nombres.add("Ana");
        nombres.add("Luis");
        nombres.add("Pedro");
        System.out.println("Lista: " + nombres);
        System.out.println("Buscar 'Luis': "  + buscarElemento(nombres, "Luis"));
        System.out.println("Buscar 'Maria': " + buscarElemento(nombres, "Maria"));

        List<Integer> numeros = new ArrayList<>();
        numeros.add(10); numeros.add(20); numeros.add(30);
        System.out.println("Buscar 20 en " + numeros + ": " + buscarElemento(numeros, 20));
        System.out.println("Buscar 99 en " + numeros + ": " + buscarElemento(numeros, 99));

        System.out.println("\n=== Ejercicio 2: invertirLista ===");
        List<Integer> original = new ArrayList<>();
        original.add(1); original.add(2); original.add(3); original.add(4); original.add(5);
        List<Integer> invertida = invertirLista(original);
        System.out.println("Original : " + original);
        System.out.println("Invertida: " + invertida);

        System.out.println("\n=== Ejercicio 3: insertarAlFinal ===");
        Node<Integer> head = null;
        head = insertarAlFinal(head, 10);
        head = insertarAlFinal(head, 20);
        head = insertarAlFinal(head, 30);
        head = insertarAlFinal(head, 40);
        imprimirNodos(head, "Lista enlazada");

        System.out.println("\n=== Ejercicio 4: contarNodos ===");
        System.out.println("Cantidad de nodos: " + contarNodos(head));

        Node<String> headStr = null;
        headStr = insertarAlFinal(headStr, "A");
        headStr = insertarAlFinal(headStr, "B");
        headStr = insertarAlFinal(headStr, "C");
        imprimirNodos(headStr, "Lista strings");
        System.out.println("Cantidad de nodos: " + contarNodos(headStr));

        System.out.println("\n=== Ejercicio 5: sonIguales ===");
        Node<Integer> l1 = insertarAlFinal(null, 1);
        l1 = insertarAlFinal(l1, 2);
        l1 = insertarAlFinal(l1, 3);

        Node<Integer> l2 = insertarAlFinal(null, 1);
        l2 = insertarAlFinal(l2, 2);
        l2 = insertarAlFinal(l2, 3);

        Node<Integer> l3 = insertarAlFinal(null, 1);
        l3 = insertarAlFinal(l3, 2);
        l3 = insertarAlFinal(l3, 9);

        Node<Integer> l4 = insertarAlFinal(null, 1);
        l4 = insertarAlFinal(l4, 2);

        imprimirNodos(l1, "Lista1");
        imprimirNodos(l2, "Lista2");
        imprimirNodos(l3, "Lista3");
        imprimirNodos(l4, "Lista4");
        System.out.println("Lista1 == Lista2: " + sonIguales(l1, l2));
        System.out.println("Lista1 == Lista3: " + sonIguales(l1, l3));
        System.out.println("Lista1 == Lista4: " + sonIguales(l1, l4));

        System.out.println("\n=== Ejercicio 6: concatenarListas ===");
        Node<Integer> listaA = insertarAlFinal(null, 10);
        listaA = insertarAlFinal(listaA, 20);
        listaA = insertarAlFinal(listaA, 30);


        Node<Integer> listaB = insertarAlFinal(null, 40);
        listaB = insertarAlFinal(listaB, 50);

        Node<Integer> concatenada = concatenarListas(listaA, listaB);
        imprimirNodos(listaA, "Lista A    ");
        imprimirNodos(listaB, "Lista B    ");
        imprimirNodos(concatenada, "Concatenada");
    }
}
