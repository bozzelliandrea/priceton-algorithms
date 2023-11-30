package github.algorithms.stack_and_queue;

public interface Queue<T> extends Iterable<T>, Collection {

    void enqueue(T item);

    T dequeue();

    T peek();
}
