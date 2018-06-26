package transactions;

import java.util.Objects;

public class Transaction {
    private final int amount;
    private final String date;

    public Transaction(String date, int amount) {
        this.date = date;
        this.amount = amount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Transaction)) return false;
        Transaction that = (Transaction) o;
        return amount == that.amount && Objects.equals(date, that.date);
    }

    @Override
    public int hashCode() {

        return Objects.hash(amount, date);
    }

    public String date() {
        return date;
    }

    public int amount() {
        return amount;
    }
}
