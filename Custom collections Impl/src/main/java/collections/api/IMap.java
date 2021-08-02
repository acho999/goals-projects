package collections.api;

import collections.impl.CustomHashMap;

import java.util.Collection;
import java.util.Set;

public interface IMap<K,V> {

    int hash(K key);
    void increseCapacity();
    Collection<CustomHashMap.Entry<K, V>> getEntries(CustomHashMap.Entry<K, V> entry);
    Set<CustomHashMap.Entry<K, V>> entrySet();
    boolean isEmpty();
    boolean remove(K key);
    boolean containsValue (V value);
    boolean containsKey (K key);
    V get(K key);
    void put(K key, V value);
    int size();

}
