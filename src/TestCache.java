import junit.framework.TestCase;

public class TestCache extends TestCase {
    public void testSize() {
        Cache<Integer, Integer> cache = new Cache<Integer, Integer>();
        cache.addOrUpdate(100, 1000);
        cache.addOrUpdate(200, 2000);
        cache.addOrUpdate(100, 3000);

        assertEquals(2, cache.size());
    }

    public void testAddOrUpdate() {
        Cache<Integer, Integer> cache = new Cache<Integer, Integer>();
        cache.addOrUpdate(100, 1000);
        cache.addOrUpdate(200, 2000);
        cache.addOrUpdate(100, 3000);

        assertEquals(200, cache.getOldElement().key);

        cache.addOrUpdate(200, 5000);

        assertEquals(100, cache.getOldElement().key);
    }

    public void testFind () {
        Cache<Integer, Integer> cache = new Cache<Integer, Integer>();
        cache.addOrUpdate(100, 1000);
        cache.addOrUpdate(200, 2000);
        cache.addOrUpdate(300, 3000);

        assertEquals(1000, cache.find(100));
        assertEquals(200, cache.getOldElement().key);
    }

    public void testRemove () {
        Cache<Integer, Integer> cache = new Cache<Integer, Integer>();
        cache.addOrUpdate(100, 1000);
        cache.addOrUpdate(200, 2000);
        cache.addOrUpdate(100, 3000);
        cache.addOrUpdate(300, 4000);

        assertEquals(200, cache.getOldElement().key);

        cache.removeLeastRecentlyUsed();

        assertEquals(100, cache.getOldElement().key);
    }
}
