package transactions;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Clock {

    public static final String DD_MM_YYYY = "dd/MM/yyyy";

    public String formattedToday() {
        LocalDate today = LocalDate.now();
        return today.format(DateTimeFormatter.ofPattern(DD_MM_YYYY));
    }
}
