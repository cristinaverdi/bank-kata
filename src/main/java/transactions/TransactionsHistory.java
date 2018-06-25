package transactions;

import java.util.List;
import java.util.ArrayList;

public class TransactionsHistory {
    private List<Transaction> history;
    private Clock clock;

    public TransactionsHistory(Clock clock) {
        this.clock = clock;
        this.history = new ArrayList<>();
    }

    public void addDeposit(int amount) {
        history.add(transaction(amount));
    }

    public void addWithdraw(int amount) {
        history.add(transaction(-amount));
    }

    private Transaction transaction(int amount) {
        return new Transaction(clock.formattedToday(), amount);
    }

    public List<Transaction> findAll() {
        return history;
    }
}
