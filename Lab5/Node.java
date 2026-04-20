// Nodo de la lista enlazada
public class Node<T> {

    public T value;
    public Node<T> next;  // null = último nodo

    public Node(T value) {
        this.value = value;
        this.next = null;
    }
}
