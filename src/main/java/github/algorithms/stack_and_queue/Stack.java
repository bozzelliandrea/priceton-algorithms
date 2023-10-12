package github.algorithms.stack_and_queue;

public interface Stack<T> extends Iterable<T>, Collection {

    void push(T item);

    T pop();

    T peek();
}
