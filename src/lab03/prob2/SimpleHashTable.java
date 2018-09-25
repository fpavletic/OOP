package lab03.prob2;

import hr.fer.oopj.lab4.data.StudentGrades;
import hr.fer.oopj.lab4.data.StudentRecord;
import lab03.prob2.consumer.Obrada;
import lab03.prob2.consumer.ProsjecnaVrijednost;
import lab03.prob2.iterator.Obilaznik;
import lab03.prob2.predicate.Ispitivac;

public class SimpleHashTable<K, V> implements HashTable<K, V>{

    private int size;
    private TableEntry<K, V>[] hashTable;
    public SimpleHashTable(int tableSize) {
        hashTable = new TableEntry[Integer.highestOneBit(tableSize) << 1];
    }
    public SimpleHashTable() {
        hashTable = new TableEntry[16];
    }

    public void put (K key, V value ){

        // no null keys
        if ( key == null ){
            throw new IllegalArgumentException("Key must not be null");
        }

        // get first
        TableEntry<K, V> current = hashTable[getIndex(key)];

        // find key match
        while ( current != null && !key.equals(current.key)){
            current = current.next;
        }

        // if no key match found
        if ( current == null ){
            hashTable[getIndex(key)] = new TableEntry<K, V>(key, value, hashTable[getIndex(key)]);
            size++;
            return;
        }

        // if key match found
        current.setValue(value);

    }

    public V get (K key){
        TableEntry<K, V> slot = hashTable[getIndex(key)];

        while ( slot != null ){
            if (key.equals(slot.key)){
                break;
            }
            slot = slot.next;
        }
        return slot == null ? null : slot.value;
    }

    public int size (){
        return size;
    }

    public boolean containsKey (K key){
        TableEntry<K, V> slot = hashTable[getIndex(key)];
        while ( slot != null ){
            if (key.equals(slot.key)){
                return true;
            }
            slot = slot.next;
        }
        return false;
    }

    public boolean containsValue (V value){
        for ( TableEntry<K, V> slot : hashTable ){
            while (slot != null){
                if ( value.equals(slot.value )){
                    return true;
                }
                slot = slot.next;
            }
        }
        return false;
    }

    public void remove ( K key ){

        TableEntry<K, V> current = hashTable[getIndex(key)];
        TableEntry<K, V> previous = null;

        // find key match
        while ( current != null && !key.equals(current.key) ){
            previous = current;
            current = current.next;
        }

        // if no key match found
        if ( current == null ){
            return;
        }

        // if match found in first entry
        if ( previous == null ){
            hashTable[getIndex(key)] = current.next;
            size--;
            return;
        }

        previous.next = current.next;
        size--;

    }

    public boolean isEmpty (){
        return size == 0;
    }

    @Override
    public String toString (){
        StringBuilder out = new StringBuilder();
        for ( TableEntry<K, V> slot : hashTable ){
            while (slot != null ){
                out.append(slot.key).append(" -> ").append(slot.value).append("\n");
                slot = slot.next;
            }
        }
        return out.toString();
    }

    public Obilaznik<K> stvoriObilaznik(){
        return new Obilaznik<K>() {

            private int index = 0;
            TableEntry<K, V> current = null;

            @Override
            public K vratiSljedeceg() {
                if ( current != null ){
                    current = current.next;
                }
                while (current == null){
                    if ( index >= hashTable.length ){
                        return null;
                    }
                    current = hashTable[index++];
                }
                return current.key;
            }
        };
    }

    public void removeIf ( Ispitivac<V> predicate ){
        for ( TableEntry<K, V> slot : hashTable ){
            while ( slot != null ){
                if ( predicate.prolazi(slot.value) ){
                    remove(slot.key);
                }
                slot= slot.next;
            }
        }
    }

    public void forEach( Obrada<K, V> biConsumer){
        for ( TableEntry<K, V> slot : hashTable ){
            while ( slot != null ){
                biConsumer.obradi(slot.key, slot.value);
                slot = slot.next;
            }
        }
    }

    private int getIndex(K key) {
        return Math.abs(key.hashCode() % hashTable.length);
    }

    public static class TableEntry<K, V>{
        private K key;
        private V value;
        private TableEntry<K,V> next;

        public TableEntry(K key, V value, TableEntry<K, V> next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }

        public TableEntry(K key, V value) {
            this(key, value, null);
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }

        public void setValue(V value) {
            this.value = value;
        }
    }


    public static void main(String[] args) {

        SimpleHashTable<String, Integer> jmbagToGrade = new SimpleHashTable<>(StudentGrades.getNumberOfRecords() << 1);
        for ( int i = StudentGrades.getNumberOfRecords() -1; i >= 0; i-- ){
            StudentRecord record = StudentGrades.getRecord(i);
            jmbagToGrade.put(record.getStudentID(), record.getGrade());
        }

        ProsjecnaVrijednost avg = new ProsjecnaVrijednost();
        jmbagToGrade.forEach(avg);

        System.out.println(avg.prosjek());


    }

}
