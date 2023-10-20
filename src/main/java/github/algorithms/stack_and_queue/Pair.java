package github.algorithms.stack_and_queue;

public class Pair<F, S> {

    private F first;
    private S second;

    private Pair(F f, S s) {
        first = f;
        second = s;
    }

    public static <F, S> Pair<F, S> of(F f, S s) {
        return new Pair<>(f, s);
    }

    public static <T> Pair<T, ?> of(T f) {
        return new Pair<>(f, null);
    }

    public static Pair<?, ?> of() {
        return new Pair<>(null, null);
    }

    public Pair<F, S> first(F f) {
        first = f;
        return this;
    }

    public Pair<F, S> second(S s) {
        second = s;
        return this;
    }

    public F first() {
        return first;
    }

    public S second() {
        return second;
    }
}
