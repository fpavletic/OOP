package lab03.prob2;

public interface HashTable <K, V> {

    void put (K key, V value );
    V get (K key);
    int size ();
    boolean containsKey(K key);
    boolean containsValue(V value);
    void remove(K key);
    boolean isEmpty();
    String toString();


}
