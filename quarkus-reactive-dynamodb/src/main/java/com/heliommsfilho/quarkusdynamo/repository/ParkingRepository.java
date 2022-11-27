package com.heliommsfilho.quarkusdynamo.repository;

import com.heliommsfilho.quarkusdynamo.document.Parking;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbEnhancedAsyncClient;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class ParkingRepository extends DynamoDBAsyncRepository<Parking> {

    @Inject
    public ParkingRepository(DynamoDbEnhancedAsyncClient enhancedClient) {
        super(enhancedClient);
    }

    @Override
    Class<Parking> getTableClass() {
        return Parking.class;
    }

    @Override
    String getTableName() {
        return "Parking";
    }
}
