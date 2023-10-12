package github.algorithms.stack_and_queue;

import java.io.Serializable;

public interface Collection extends Serializable {

    int size();

    default boolean isEmpty() {
        return this.size() == 0;
    }
}
