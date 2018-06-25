package transactions;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Clock {
    public String formattedToday() {
        LocalDate today = LocalDate.now();
        return today.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
    }
}
