package transactions;

import java.util.List;
import org.junit.Test;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.is;

@RunWith(MockitoJUnitRunner.class)
public class TransactionsHistoryTest {

    private Clock clock;
    private List<Transaction> transactions;
    private TransactionsHistory transactionshistory;

    @Before public void
    set_up() {
        clock = new Clock();
        transactionshistory = new TransactionsHistory(clock);
    }

    @Test public void
    create_transaction_and_save_deposit_into_history() {
        transactionshistory.addDeposit(100);
        transactions = transactionshistory.findAll();

        assertThat(transactions.size(), is(1));
        assertThat(transactions.get(0), is(aTransaction(100)));
    }

    @Test public void
    create_transaction_and_save_withdrawal_into_history() {
        transactionshistory.addWithdraw(100);
        transactions = transactionshistory.findAll();

        assertThat(transactions.size(), is(1));
        assertThat(transactions.get(0), is(aTransaction(-100)));
    }

    private Transaction aTransaction(int amount) {
        return new Transaction(clock.formattedToday(), amount);
    }
}
