import java.util.HashMap;
import java.util.Map;

public class Cache<K, V> implements LRUMap<K, V>{

    private LinkedList<K, V> linkedList = new LinkedList<K, V>();

    public Entry getOldElement() {
        return linkedList.getStart();
    }

    public void addOrUpdate(K key, V value) {
        Entry<K, V> entry = new Entry<K, V>(key, value);

        if (linkedList.contains(key)) {
            linkedList.remove(key);
        }
        linkedList.add(key, entry);
    }

    public int size() {
        return linkedList.size();
    }

    public Object find(K key) {
        addOrUpdate(key, linkedList.get(key).value);
        return linkedList.get(key).value;
    }

    public void removeLeastRecentlyUsed() {
        linkedList.removeStart();
    }

}
