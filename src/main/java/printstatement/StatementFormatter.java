package printstatement;

public class StatementFormatter {

    public static final String SEPARATOR = " | ";
    public static final String DECIMALS = ".00";

    public String format(String date, int amount, int balance) {
        return date + SEPARATOR + amount + DECIMALS + SEPARATOR + balance + DECIMALS;
    }
}
