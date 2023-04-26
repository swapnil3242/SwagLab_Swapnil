package utility;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateTime {

    public static String time()
    {
        LocalDateTime currentTime = LocalDateTime.now();
        DateTimeFormatter pattern = DateTimeFormatter.ofPattern("dd-MM-yyyy-HH-mm-ss");
        String time = currentTime.format(pattern);
        return time;
    }

}
