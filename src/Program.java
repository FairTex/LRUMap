/**
 * Created by mmmvi on 19.11.2015.
 */
public class Program {

    public static void main(String[] args) {
        TimeManager manager = new TimeManager();
        manager.calculateTime(1000000);
        manager.calculateTime(1000000);

        for (int i = 1; i < 7; i++) {
            int count = (int)Math.pow(10, i);
            double time = manager.calculateTime(count);
            System.out.println(count + " элементов: " + time + " ms");
        }

    }
}
