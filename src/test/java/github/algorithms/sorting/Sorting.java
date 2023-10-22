package github.algorithms.sorting;

@FunctionalInterface
public interface Sorting {

    <T extends Comparable<T>> void sort(T[] arr);
}
