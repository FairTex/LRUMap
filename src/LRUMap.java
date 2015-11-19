/**
 * Created by mmmvi on 19.11.2015.
 */
public interface LRUMap<K, V> {
    public void addOrUpdate(K key, V value);
    public int size();
    public Object find(K key);
    public void removeLeastRecentlyUsed();
}
