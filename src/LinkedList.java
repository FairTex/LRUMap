import java.util.HashMap;
import java.util.Map;

public class LinkedList<K, V> {
    private Map<K, Entry<K, V>> table = new HashMap<K, Entry<K, V>>();
    private Entry<K, V> start;
    private Entry<K, V> end;

    public Entry getStart() {
        return start;
    }

    public <K> void remove(K key) {
        Entry el = table.get(key);

        if (el.prev == null) {
            table.get(el.next.key).prev = null;
            start = table.get(el.next.key);
        } else if (el.next == null) {
            table.get(el.prev.key).next = null;
            end = table.get(el.prev.key);
        } else {
            table.get(el.next.key).prev = table.get(el.prev);
            table.get(el.prev.key).next = table.get(el.next);
        }
    }

    public void add(K key, Entry<K, V> value) {
        if (end != null) {
            value.prev = end;
            table.get(end.key).next = value;
        }
        table.put(key, value);

        end = value;
        if (start == null) {
            start = value;
        }
    }

    public boolean contains (K key) {
        return table.get(key) != null;
    }

    public int size () {
        return table.size();
    }

    public Entry<K, V> get (K key) {
        return table.get(key);
    }

    public void removeStart() {
        table.remove(start.key);
        start = start.next;
    }

}
