package com.heliommsfilho.quarkusdynamo.service;

import com.heliommsfilho.quarkusdynamo.document.Customer;
import com.heliommsfilho.quarkusdynamo.model.customer.CustomerInput;
import com.heliommsfilho.quarkusdynamo.model.tableinfo.TableInfoOutput;
import com.heliommsfilho.quarkusdynamo.model.customer.CustomerMapper;
import com.heliommsfilho.quarkusdynamo.model.tableinfo.TableInfoMapper;
import com.heliommsfilho.quarkusdynamo.repository.CustomerRepository;
import io.smallrye.mutiny.Uni;
import software.amazon.awssdk.enhanced.dynamodb.Key;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.List;

@ApplicationScoped
public class CustomerService {

    @Inject
    CustomerRepository customerRepository;

    @Inject
    CustomerMapper customerMapper;

    @Inject
    TableInfoMapper tableInfoMapper;

    public Uni<TableInfoOutput> getTableInfo() {
        return customerRepository.getTableInfo().map(tableInfoMapper::toTableInfo);
    }


    public Uni<Customer> getSingle(final String customerId) {
        final Key key = Key.builder().partitionValue(customerId).build();
        return customerRepository.getSingle(key);
    }
    public Uni<List<Customer>> getAll() {
        return customerRepository.getAll();
    }

    public Uni<Customer> create(final CustomerInput input) {
        return Uni.createFrom().item(customerMapper.mapForCreate(input))
                .chain(customer -> customerRepository.save(customer).replaceWith(customer))
                .chain(customer -> getSingle(customer.getCustomerId()));
    }
}
