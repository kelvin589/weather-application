import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Keeps track of time
 */
public class TimeKeeper {
    private static final DateTimeFormatter HH_MM = DateTimeFormatter.ofPattern("HH:mm");
    private static final DateTimeFormatter HH_MM_DD_MM = DateTimeFormatter.ofPattern("HH:mm, E dd MMMM");
    private static final ScheduledExecutorService ses = Executors.newScheduledThreadPool(1);

    /**
     * Get the string representation of an epoch time in the format HH:mm
     * @param epoch number of seconds from 1 January 1970 (unix epoch format)
     * @param nanoOfSecond the nanosecond within the second from 0 to 999,999,999
     * @param offset zone offset
     * @return return the string representation of unix epoch time
     */
    public static String epochToDateTime(long epoch, int nanoOfSecond, int offset) {
        LocalDateTime time = LocalDateTime.ofEpochSecond(epoch, nanoOfSecond, ZoneOffset.ofTotalSeconds(offset));
        return time.format(HH_MM);
    }

    /**
     * Get the current time in a string format
     * @return the String representation of the current time
     */
    public static String currentTime() {
        LocalDateTime currentDateTime = LocalDateTime.now();
        return currentDateTime.format(HH_MM_DD_MM);
    }

    /**
     * Execute a {@link Runnable} task every so often
     * @param task the {@link Runnable} task
     * @param initialDelay the initial delay in seconds
     * @param period the time in seconds in which the task should execute periodically
     */
    public static void startRegularIntervals(Runnable task, int initialDelay, int period) {
        ses.scheduleAtFixedRate(task, initialDelay, period, TimeUnit.SECONDS);
    }

    /**
     * Shutdown the {@link ScheduledExecutorService}
     */
    public static void shutdown() {
        ses.shutdown();
    }
}
