package printstatement;

import transactions.Transaction;

import java.util.ArrayList;
import java.util.List;

public class BalanceHistory {

    public List<Integer> calculateFrom(List<Transaction> transactions) {
        List<Integer> balances = new ArrayList<>();
        int balance = 0;
        for (Transaction transaction : transactions) {
            balance += transaction.amount();
            balances.add(balance);
        }

        return balances;
    }
}
