package Loading;

public class Time {
    // returns the current time as a double
    public static double now()
    {
        long t = System.currentTimeMillis();

        return (double)t / 1000.0f;
    }
}
