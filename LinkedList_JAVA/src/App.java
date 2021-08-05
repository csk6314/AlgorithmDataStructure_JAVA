
interface SimpleList<E> {
    /**
     * Returns the number of elements.
     */
    int size();
    /**
     * Returns true if this SimpleList contains no elements.
     */
    boolean isEmpty();

    /**
     * Inserts element to index of SimpleList.
     */
    void add(int index, E element);
    /**
     * Inserts element to last of SimpleList.
     */
    void add(E element);

    /**
     * Removes and returns the element at index of SimpleList.
     */
    E remove(int index);
    /**
     * Removes and returns the last elements of SimpleList.
     */
    E remove();

    /**
     * Returns the element at index of SimpleList.
     */
    E get(int index);
}


class Node<T> {
    T data;
    Node<T> next;

    public Node() {
    }

    public Node(T data) {
        this.data = data;
    }

    public Node(T data, Node<T> next) {
        this.data = data;
        this.next = next;
    }
}


public class App {
    public static void main( String[] args ) {
        System.out.println("Hello, World!");
        System.out.println("class MyList<E> implements SimpleList<E> 를 구현해야합니다!");
    }
}
