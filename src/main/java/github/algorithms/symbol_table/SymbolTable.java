package github.algorithms.symbol_table;

import java.io.Serializable;

public interface SymbolTable<K, V> extends Serializable {

    V get(K key);

    void put(K key, V value);

    void delete(K key);

    boolean contains(K key);

    int size();

    default boolean isEmpty() {
        return this.size() == 0;
    }

}
