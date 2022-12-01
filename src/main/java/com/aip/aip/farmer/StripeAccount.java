package com.aip.aip.farmer;

import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.Card;
import com.stripe.model.Customer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StripeAccount {
    String name;

    public StripeAccount() {
    }

    public StripeAccount(String name) {
        this.name = name;
    }

    public String createAccount(String accountName) throws StripeException {
        //Stripe.apiKey = "sk_test_51Ls7HlGvqUtLRXinT72GCFdpOvcEdGNUBiHJZT3Q6yUGOPNgxisvs5pQkgiVxR8o9yigXbydqlKDKymLldzYuX4s00gX6iovn9";
        Map<String, Object> customerParameter = new HashMap<>();
        customerParameter.put("email", (accountName.trim()).charAt(0) + "@gmail.com");
        customerParameter.put("name", accountName);
        customerParameter.put("balance", 50000);

        Customer customer = Customer.create(customerParameter);

        return customer.getId();

    }

    public String customerCard(String accountName) throws StripeException{
        Stripe.apiKey = "sk_test_51Ls7HlGvqUtLRXinT72GCFdpOvcEdGNUBiHJZT3Q6yUGOPNgxisvs5pQkgiVxR8o9yigXbydqlKDKymLldzYuX4s00gX6iovn9";
        String userId = createAccount(accountName);

        Map<String, Object> retrieveParams = new HashMap<>();
        List<String> expandList = new ArrayList<>();
        expandList.add("sources");
        retrieveParams.put("expand", expandList);
        Customer customer = Customer.retrieve(
                userId,
                retrieveParams,
                null
        );

        Map<String, Object> params = new HashMap<>();
        params.put("source", "tok_visa");

        Card card = (Card) customer.getSources().create(params);
        return userId;

    }
}
