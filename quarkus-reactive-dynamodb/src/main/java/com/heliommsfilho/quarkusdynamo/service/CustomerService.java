package com.heliommsfilho.quarkusdynamo.service;

import com.heliommsfilho.quarkusdynamo.model.TableInfo;
import com.heliommsfilho.quarkusdynamo.model.mapper.TableMapper;
import com.heliommsfilho.quarkusdynamo.repository.CustomerRepository;
import io.smallrye.mutiny.Uni;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class CustomerService {

    @Inject
    CustomerRepository customerRepository;

    @Inject
    TableMapper tableMapper;

    public Uni<TableInfo> getTableInfo() {
        return customerRepository.getTableInfo().map(tableMapper::toTableInfo);
    }
}
