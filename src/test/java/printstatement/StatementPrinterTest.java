package printstatement;

import org.junit.Test;
import org.mockito.Mock;
import org.junit.Before;
import org.mockito.InOrder;
import org.junit.runner.RunWith;
import transactions.Transaction;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.inOrder;

@RunWith(MockitoJUnitRunner.class)
public class StatementPrinterTest {

    @Mock BankConsole console;
    private List<Transaction> transactions;
    private StatementPrinter statementPrinter;
    private StatementFormatter statementFormatter;
    public static final String STATEMENT_HEADER = "DATE | AMOUNT | BALANCE";

    @Before public void
    set_up() {
        statementFormatter = new StatementFormatter();
        statementPrinter = new StatementPrinter(console, statementFormatter);
    }

    @Test public void
    print_header_in_each_statement() {
        transactions = new ArrayList<>();

        statementPrinter.print(transactions);

        verify(console).printStatement(STATEMENT_HEADER);
    }

    @Test public void
    print_transactions_in_reverse_chronological_order() {
        transactions = Arrays.asList(transactions());
        statementPrinter.print(transactions);

        InOrder inOrder = inOrder(console);
        verify(console).printStatement(STATEMENT_HEADER);
        inOrder.verify(console).printStatement("10/04/2014 | 500.00 | 1400.00");
        inOrder.verify(console).printStatement("02/04/2014 | -100.00 | 900.00");
        inOrder.verify(console).printStatement("01/04/2014 | 1000.00 | 1000.00");

    }

    private Transaction[] transactions() {
        return new Transaction[]{
                new Transaction("01/04/2014", 1000),
                new Transaction("02/04/2014", -100),
                new Transaction("10/04/2014", 500)
        };
    }
}
