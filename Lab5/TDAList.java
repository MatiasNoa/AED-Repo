// Define las operaciones básicas que debe tener una lista enlazada
public interface TDAList<T> {

    boolean isEmptyList();
    int length();
    void destroyList();
    int search(T x);  // retorna posición (1-based) o -1
    void insertFirst(T x);
    void insertLast(T x);
    void removeNode(T x);
}
