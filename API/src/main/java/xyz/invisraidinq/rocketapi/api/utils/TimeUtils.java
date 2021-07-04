package xyz.invisraidinq.rocketapi.api.utils;

public class TimeUtils {

    /**
     * Format an int to time
     *
     * @param seconds The amount of seconds
     * @return A formatted time string
     */
    public static String formatAsHHMMSS(int seconds) {
        return String.format("%02d:%02d:%02d", seconds / 3600, (seconds % 3600) / 60, seconds % 60);
    }

    /**
     * Format a long to time
     *
     * @param millis The amount of milliseconds
     * @return A formatted time string
     */
    public static String formatAsHHMMSS(long millis) {
        return formatAsHHMMSS(millis * 1000);
    }
}
