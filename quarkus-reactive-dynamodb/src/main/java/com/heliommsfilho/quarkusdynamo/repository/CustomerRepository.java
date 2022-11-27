package com.heliommsfilho.quarkusdynamo.repository;

import com.heliommsfilho.quarkusdynamo.document.Customer;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbEnhancedAsyncClient;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class CustomerRepository extends DynamoDBAsyncRepository<Customer> {

    @Inject
    public CustomerRepository(DynamoDbEnhancedAsyncClient enhancedClient) {
        super(enhancedClient);
    }

    @Override
    Class<Customer> getTableClass() {
        return Customer.class;
    }

    @Override
    String getTableName() {
        return "Customer";
    }
}
