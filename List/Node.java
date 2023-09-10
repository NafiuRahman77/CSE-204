public class Node<E> {
    private E element;
    private Node<E> next;

    Node(E item, Node<E> temp) {
        element = item;
        next = temp;
    }

    Node(Node<E> temp) {
        next = temp;
    }

    Node<E> next() {
        return next;
    }

    Node<E> setNext(Node<E> temp) {
        return next = temp;
    }

    E element() {
        return element;
    }

    E setElement(E it) {
        return element = it;
    }
}