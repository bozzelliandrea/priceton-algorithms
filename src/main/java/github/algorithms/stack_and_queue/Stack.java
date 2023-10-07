package github.algorithms.stack_and_queue;

public interface Stack<T> extends Iterable<T> {

    void push(T item);

    T pop();

    T peek();

    int size();

    boolean isEmpty();
}
