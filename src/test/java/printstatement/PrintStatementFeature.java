package printstatement;

import account.Account;
import org.junit.Test;
import org.junit.Before;
import org.mockito.Mock;
import transactions.Clock;
import org.mockito.InOrder;
import org.junit.runner.RunWith;
import transactions.TransactionsHistory;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.inOrder;
import static org.mockito.BDDMockito.given;


@RunWith(MockitoJUnitRunner.class)
public class PrintStatementFeature {

    @Mock Clock clock;
    @Mock BankConsole console;

    private Account account;
    private StatementPrinter statementPrinter;
    private StatementFormatter statementFormatter;
    private TransactionsHistory transactionsHistory;

    @Before public void
    set_up() {
        given(clock.formattedToday()).willReturn("01/04/2014", "02/04/2014", "10/04/2014");

        statementFormatter = new StatementFormatter();
        transactionsHistory = new TransactionsHistory(clock);
        statementPrinter = new StatementPrinter(console, statementFormatter);

        account = new Account(transactionsHistory, statementPrinter);
        account.deposit(1000);
        account.withdraw(100);
        account.deposit(500);
    }

    @Test public void
    print_formatted_statement() {
        account.printStatement();

        InOrder inOrder = inOrder(console);
        inOrder.verify(console).printStatement("DATE | AMOUNT | BALANCE");
        inOrder.verify(console).printStatement("10/04/2014 | 500.00 | 1400.00");
        inOrder.verify(console).printStatement("02/04/2014 | -100.00 | 900.00");
        inOrder.verify(console).printStatement("01/04/2014 | 1000.00 | 1000.00");
    }
}
