public class Stack<T> {
    private record Node<E>(E data, Node<E> previous) {}

    private Node<T> top;

    public Stack() {
        top = null;
    }

    public boolean isEmpty() {
        return top == null;
    }

    public void push(T data) {
        top = new Node<>(data, top);
    }

    public T pop() {
        if (isEmpty())
            return null;

        T data = top.data();
        top = top.previous();

        return data;
    }
}