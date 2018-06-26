package printstatement;

import transactions.Transaction;

import java.util.List;

public class StatementPrinter {
    private BankConsole console;
    private BalanceHistory balanceHistory;
    private StatementFormatter statementFormatter;
    public static final String STATEMENT_HEADER = "DATE | AMOUNT | BALANCE";

    public StatementPrinter(BankConsole console, StatementFormatter statementFormatter) {
        this.console = console;
        this.balanceHistory = new BalanceHistory();
        this.statementFormatter = statementFormatter;
    }

    public void print(List<Transaction> transactions) {
        printHeader();
        calculateBalanceAndPrint(transactions);
    }

    private void printHeader() {
        console.printStatement(STATEMENT_HEADER);
    }

    private void calculateBalanceAndPrint(List<Transaction> transactions) {
        List<Integer> balances = balanceHistory.calculateFrom(transactions);

        int reverse = transactions.size() - 1;
        for (int i = 0; i < transactions.size(); i++) {
            String formattedStatement = statementFormatter.format(transactions.get(reverse).date(), transactions.get(reverse).amount() , balances.get(reverse));
            console.printStatement(formattedStatement);
            reverse --;
        }
    }
}
