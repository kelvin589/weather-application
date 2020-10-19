import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;

/**
 * Keeps track of time
 */
public class TimeKeeper {

    /**
     * Get the string representation of an epoch time in the format HH:mm
     * @param epoch number of seconds from 1 January 1970 (unix epoch format)
     * @param nanoOfSecond the nanosecond within the second from 0 to 999,999,999
     * @param offset zone offset
     * @return return the string representation of unix epoch time
     */
    public static String epochToDateTime(long epoch, int nanoOfSecond, int offset) {
        LocalDateTime time = LocalDateTime.ofEpochSecond(epoch, nanoOfSecond, ZoneOffset.ofTotalSeconds(offset));
        DateTimeFormatter timeFormat = DateTimeFormatter.ofPattern("HH:mm");
        return time.format(timeFormat);
    }
}
