package Lab6;

class QueueArray<E> implements Queue<E> {
    private E[] array;
    private int front;
    private int rear;
    private int size;
    
    public QueueArray(int n) {
        array = (E[]) new Object[n];
        front = 0;
        rear = -1;
        size = 0;
    }
    
    public void enqueue(E x) {
        // implementar
    }
    public E dequeue() throws ExceptionIsEmpty {
        // implementar
    }
    public E front() throws ExceptionIsEmpty {
        // implementar
    }
    public boolean isEmpty() {
        return size == 0;
    }
    public boolean isFull() {
        // implementar
    }
    public String toString() {
        // mostrar desde front hasta rear
    }
}