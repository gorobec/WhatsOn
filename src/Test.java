import java.io.File;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;

/**
 * Created by gorobec on 12.02.16.
 */
public class Test {
    public static void main(String[] args) {
        Instant instant = Instant.ofEpochMilli(new File("src/resources/afisha.xml").lastModified());
        long lastUpdate = ChronoUnit.DAYS.between(LocalDateTime.ofInstant(instant, ZoneId.systemDefault()).toLocalDate(), LocalDate.now());
        System.out.println(lastUpdate > 0);
    }
}
