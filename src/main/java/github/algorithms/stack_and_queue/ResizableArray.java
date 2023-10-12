package github.algorithms.stack_and_queue;

public class ResizableArray<T> extends Resizable implements Collection {

    transient T[] data;
    int size;

    @SuppressWarnings("unchecked")
    public ResizableArray() {
        data = (T[]) new Object[INITIAL_CAPACITY];
        size = 0;
    }

    public void add(T item) {

    }

    public T get(int idx) {
        return null;
    }

    @Override
    public int size() {
        return size;
    }
}
