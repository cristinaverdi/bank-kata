package printstatement;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.InOrder;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import transactions.TransactionsHistory;

import static org.mockito.Mockito.inOrder;


@RunWith(MockitoJUnitRunner.class)
public class PrintStatementFeature {

    private Account account;
    @Mock BankConsole console;
    @Mock StatementPrinter statementPrinter;
    @Mock TransactionsHistory transactionsHistory;

    @Before public void
    set_up() {
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
