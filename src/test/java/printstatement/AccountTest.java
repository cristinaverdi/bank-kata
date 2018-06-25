package printstatement;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import transactions.Clock;
import transactions.TransactionsHistory;

import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class AccountTest {

    private Account account;

    @Mock Clock clock;
    @Mock StatementPrinter statementPrinter;

    @Mock TransactionsHistory transactionsHistory;

    @Before public void
    set_up() {
        account = new Account(transactionsHistory, statementPrinter);
    }

    @Test public void
    save_deposit_transaction() {
        account.deposit(100);
        verify(transactionsHistory).addDeposit(100);
    }

}