package printstatement;

import transactions.Transaction;

import java.util.ArrayList;
import java.util.List;

public class StatementPrinter {
    private BankConsole console;
    private StatementFormatter statementFormatter;

    public StatementPrinter(BankConsole console, StatementFormatter statementFormatter) {
        this.console = console;
        this.statementFormatter = statementFormatter;
    }

    public void print(List<Transaction> transactions) {
        console.printStatement("DATE | AMOUNT | BALANCE");

        List<Integer> balances = new ArrayList<>();
        int balance = 0;
        for (Transaction transaction : transactions) {
            balance += transaction.amount();
            balances.add(balance);
        }

        int reverse = transactions.size() - 1;
        for (int i = 0; i < transactions.size(); i++) {
            String formattedStatement = statementFormatter.format(transactions.get(reverse).date(), transactions.get(reverse).amount() , balances.get(reverse));
            console.printStatement(formattedStatement);
            reverse --;
        }
    }
}
