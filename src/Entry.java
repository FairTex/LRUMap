/**
 * Created by mmmvi on 19.11.2015.
 */
public class Entry<K, V> {
    public K key;
    public V value;
    public Entry next;
    public Entry prev;

    public Entry(K key, V value) {
        this.key = key;
        this.value = value;
    }
}
