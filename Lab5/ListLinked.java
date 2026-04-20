// Implementación de lista enlazada genérica
public class ListLinked<T> implements TDAList<T> {

    private Node<T> first;  // primer nodo (null = lista vacía)

    public ListLinked() {
        first = null;
    }

    @Override
    public boolean isEmptyList() {
        return first == null;
    }

    @Override
    public int length() {
        int count = 0;
        Node<T> current = first;
        while (current != null) {
            count++;
            current = current.next;
        }
        return count;
    }

    @Override
    public void destroyList() {
        first = null;
    }

    @Override
    public int search(T x) {
        Node<T> current = first;
        int pos = 1;
        while (current != null) {
            if (current.value.equals(x)) return pos;
            current = current.next;
            pos++;
        }
        return -1;
    }

    @Override
    public void insertFirst(T x) {
        Node<T> newNode = new Node<>(x);
        newNode.next = first;
        first = newNode;
    }

    @Override
    public void insertLast(T x) {
        Node<T> newNode = new Node<>(x);
        if (isEmptyList()) {
            first = newNode;
        } else {
            Node<T> current = first;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }

    @Override
    public void removeNode(T x) {
        if (isEmptyList()) return;

        if (first.value.equals(x)) {
            first = first.next;
            return;
        }

        Node<T> prev = first;
        Node<T> current = first.next;
        while (current != null) {
            if (current.value.equals(x)) {
                prev.next = current.next;
                return;
            }
            prev = current;
            current = current.next;
        }
    }

    public Node<T> getFirst() {
        return first;
    }

    public void setFirst(Node<T> node) {
        this.first = node;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        Node<T> current = first;
        while (current != null) {
            sb.append(current.value);
            if (current.next != null) sb.append(" -> ");
            current = current.next;
        }
        sb.append("]");
        return sb.toString();
    }
}
