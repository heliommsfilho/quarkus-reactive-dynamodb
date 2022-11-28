package com.heliommsfilho.quarkusdynamo.model.customer;

import com.heliommsfilho.quarkusdynamo.document.Customer;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.CDI)
public interface CustomerAddressMapper {

    @Mapping(target = "createTimestamp", expression = "java(java.time.Instant.now())")
    @Mapping(target = "updateTimestamp", expression = "java(java.time.Instant.now())")
    Customer.Address toCustomerAddress(final CustomerAddressInput input);
}
