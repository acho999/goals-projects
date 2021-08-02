package collections.impl;

import collections.api.IMap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CustomHashMap<K, V> implements IMap<K,V> {

    private int capacity = 2;
    private Entry<K, V>[] table;
    private int count = 0;
    private List<Entry<K, V>> entriesList ;


    public CustomHashMap() {
        this.table = new Entry[capacity];
    }

    @Override
    public int size() {//TODO returns actual count of elements in array
        return this.count;
    }

    @Override
    public void put(K key, V value) {
        if (key == null) {
            return;
        }
        if (this.capacity == this.table.length) {
            this.increseCapacity();
        }
        int hash = this.hash(key);//compute hash

        Entry<K, V> entry = new Entry(key, value, null);//new entry

        if (this.table[hash] == null) {//check if array position of hash is enpty
            this.table[hash] = entry;
            this.count++;
        } else {
            Entry<K, V> previous = null;//here we keep previous element
            Entry<K, V> current = this.table[hash];

            while (true) {
                if (current == null) {
                    break;
                }
                if (current.getKey().equals(key)) {
                    if (previous
                        == null) {//if on first place element is null I mean previous is null and keys are equal
                        //we just rewrite the element
                        entry.next = this.table[hash].next;
                        this.table[hash] = entry;
                        return;
                    } else {//if previous element is not null and keys are equal we rewrite current element with new value
                        entry.next = current.next;
                        previous.next = entry;
                        return;
                    }
                }
                previous =
                    current;//here we create reference to previous element and that way we can modify its next property
                current = current.next;

            }
            previous.next = entry;//when we arrive to last element we add to it's next new entry
            count++;
        }
    }

    @Override
    public V get(K key) {

        if (key == null) {
            return null;
        }
        int hash = this.hash(key);

        if(hash < 0){return null;}

        Entry<K, V> current = this.table[hash];
        if (current == null) {
            return null;
        } else {

            while (true) {
                if (current == null) {
                    return null;
                } else if (current.getKey().equals(key)) {
                    break;
                }
                current = current.next;
            }
        }

        return current.getValue();//TODO
    }

    @Override
    public boolean containsKey (K key){
        return true;//todo
    }

    @Override
    public boolean containsValue (V value){
        return true;//TODO
    }

    @Override
    public boolean remove(K key) {

        int hash = this.hash(key);
        Entry<K,V> previous = null;
        Entry<K,V> current = this.table[hash];

        if(current == null){
            return false;
        }else{

            while (current != null){
                if(current.getKey().equals(key)) {
                    if (previous == null) {//here we check if first element will be removed
                        table[hash] = current.next;
                        this.count--;
                        return true;
                    } else {
                        table[hash] = current.next;//here we remove element greater than first
                        this.count--;
                        return true;
                    }
                }
                previous = current;
                current = current.next;
            }

        }

        return false;
    }

    @Override
    public boolean isEmpty() {
        return this.count == 0;
    }

    @Override
    public String toString(){

        StringBuilder builder = new StringBuilder();

        Set<Entry<K, V>> entries = this.entrySet();

        for (Entry<K,V> entry: entries) {

            builder.append("[ " + entry.getKey() + "-" + entry.getValue() + " ]");

        }
        return builder.toString();
    }

    @Override
    public Set<Entry<K, V>> entrySet() {//here we return all entries
        Set<Entry<K, V>> elements = new HashSet<Entry<K, V>>();
        this.entriesList = new ArrayList<>();
        for (int i = 0; i < this.table.length; i++) {
            Entry<K,V> en = this.table[i];
            if (en == null){break;}
            elements.addAll(this.getEntries(en));
        }
        return elements;
    }

    @Override
    public Collection<Entry<K, V>> getEntries(Entry<K, V> entry) {

        if (entry.next == null) {
            this.entriesList.add(entry);
            return entriesList;
        }

        this.entriesList.add(entry);

        getEntries(entry.next);

        return this.entriesList;

    }

    @Override
    public void increseCapacity() {
        int length = capacity * 2;
        table = Arrays.copyOf(this.table, length);
    }

    @Override
    public int hash(K key) {
        return (key.hashCode()) % this.capacity;
    }

    public static class Entry<K, V> {

        K key;
        V value;
        Entry<K, V> next;

        public Entry(K key, V value, Entry<K, V> next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }
    }

}
