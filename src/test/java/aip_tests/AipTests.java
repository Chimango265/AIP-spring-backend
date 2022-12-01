/*package aip_tests;

import com.aip.aip.farmer.StripeAccount;
import com.stripe.exception.StripeException;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AipTests {

    @Test
    void testStripeCreateCustomer() throws StripeException {

        StripeAccount customer = new StripeAccount();
        assertTrue('u' == (char)identifyCustomer(customer.customerCard("NG'OMA CHIMANGO")) );

    }

    public char identifyCustomer(String customerId) {
        char fLetter = customerId.charAt(1) ;
        return fLetter;
    }
}
*/