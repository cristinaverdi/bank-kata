package account;

import printstatement.StatementPrinter;
import transactions.Transaction;
import transactions.TransactionsHistory;

import java.util.List;

public class Account {
    private StatementPrinter statementPrinter;
    private TransactionsHistory transactionsHistory;

    public Account(TransactionsHistory transactionsHistory, StatementPrinter statementPrinter) {
        this.transactionsHistory = transactionsHistory;
        this.statementPrinter = statementPrinter;
    }

    public void deposit(int amount) {
        transactionsHistory.addDeposit(amount);
    }

    public void withdraw(int amount) {
        transactionsHistory.addWithdraw(amount);
    }

    public void printStatement() {
        List<Transaction> transactions = transactionsHistory.findAll();
        statementPrinter.print(transactions);
    }
}
