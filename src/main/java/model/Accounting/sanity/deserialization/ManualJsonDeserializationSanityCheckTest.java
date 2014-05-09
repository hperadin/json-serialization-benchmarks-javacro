package model.Accounting.sanity.deserialization;

import java.io.IOException;

import org.junit.BeforeClass;
import org.junit.Test;
import org.openjdk.jmh.Main;

import com.dslplatform.client.Bootstrap;
import com.dslplatform.patterns.ServiceLocator;
import com.fasterxml.jackson.core.JsonFactory;
import com.javacro.benchmarks.TestCases;
import com.javacro.dslplatform.model.Accounting.Account;
import com.javacro.dslplatform.model.Accounting.Customer;
import com.javacro.dslplatform.model.Accounting.Profile;
import com.javacro.dslplatform.model.Accounting.Transaction;
import com.javacro.serialization.manual.AccountManualJsonStreaming;
import com.javacro.serialization.manual.CustomerManualJsonStreaming;
import com.javacro.serialization.manual.ProfileManualJsonStreaming;
import com.javacro.serialization.manual.TransactionManualJsonStreaming;

public class ManualJsonDeserializationSanityCheckTest {

    private static ServiceLocator locator;
    private static final JsonFactory jsonFactory = new JsonFactory();

    /**
     * Call to initialize an instance of ServiceLocator with a dsl-project.ini
     */
    @BeforeClass
    public static void init() throws IOException {
        locator = Bootstrap.init(Main.class.getResourceAsStream("/dsl-project.ini"));
    }

    @Test
    public void TransactionTest() throws IOException {

        for (final String useCase : TestCases.getTransactionUseCases()) {
            System.out.println("Transaction; Testing for test case: " + useCase);
            final Transaction transaction = TransactionManualJsonStreaming.deserialize(useCase.getBytes("UTF-8"));

            System.out.println(transaction.toString().replace(", ",","));
        }
    }

    @Test
    public void ProfileTest() throws IOException {

        for (final String useCase : TestCases.getProfileUseCases()) {
            System.out.println("Profile; Testing for test case: " + useCase);

            final Profile profile = ProfileManualJsonStreaming.deserialize(useCase.getBytes("UTF-8"));

            System.out.println(profile.toString().replace(", ",","));
        }
    }

    @Test
    public void AccountTest() throws IOException {

        for (final String useCase : TestCases.getAccountUseCases()) {
            System.out.println("Account; Testing for test case: " + useCase);

            final Account account = AccountManualJsonStreaming.deserialize(useCase.getBytes("UTF-8"));

            System.out.println(account.toString().replace(", ",","));
        }
    }

    @Test
    public void CustomerTest() throws IOException {

        for (final String useCase : TestCases.getCustomerUseCases()) {
            System.out.println("Customer; Testing for test case: " + useCase);

            final Customer customer = CustomerManualJsonStreaming.deserialize(useCase.getBytes("UTF-8"));

            System.out.println(customer.toString().replace(", ",","));
        }
    }

}
