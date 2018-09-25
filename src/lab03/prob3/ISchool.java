package lab03.prob3;

import java.util.List;
import java.util.Map;

public interface ISchool<K, V> {

    void addGrades( K key1, K key2, V value);
    List<String> findProfessor(V value);


}
