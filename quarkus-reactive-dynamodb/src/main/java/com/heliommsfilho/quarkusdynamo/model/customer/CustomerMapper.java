package com.heliommsfilho.quarkusdynamo.model.customer;

import com.heliommsfilho.quarkusdynamo.document.Customer;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.CDI,
        uses = { CustomerAddressMapper.class, CustomerVehicleMapper.class })
public interface CustomerMapper {

    @Mapping(target = "customerId", expression = "java(java.util.UUID.randomUUID().toString())")
    @Mapping(target = "createTimestamp", expression = "java(java.time.Instant.now())")
    @Mapping(target = "updateTimestamp", expression = "java(java.time.Instant.now())")
    Customer mapForCreate(final CustomerInput input);
}
