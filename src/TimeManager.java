/**
 * Created by mmmvi on 19.11.2015.
 */
public class TimeManager {
    public double calculateTime(int elementCount) {
        Cache<Integer, Integer> cache = new Cache<Integer, Integer>();

        double start = System.currentTimeMillis();

        for (int i = 0; i < elementCount; i++) {
            cache.addOrUpdate(i, i);
        }

        double end = System.currentTimeMillis();

        return end - start;
    }
}
