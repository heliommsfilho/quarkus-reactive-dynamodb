package com.heliommsfilho.quarkusdynamo.service;

import com.heliommsfilho.quarkusdynamo.document.Parking;
import com.heliommsfilho.quarkusdynamo.model.tableinfo.TableInfoOutput;
import com.heliommsfilho.quarkusdynamo.model.tableinfo.TableInfoMapper;
import com.heliommsfilho.quarkusdynamo.repository.ParkingRepository;
import io.smallrye.mutiny.Uni;
import software.amazon.awssdk.enhanced.dynamodb.Key;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.List;

@ApplicationScoped
public class ParkingService {

    @Inject
    ParkingRepository parkingRepository;

    @Inject
    TableInfoMapper tableInfoMapper;

    public Uni<TableInfoOutput> getTableInfo() {
        return parkingRepository.getTableInfo().map(tableInfoMapper::toTableInfo);
    }

    public Uni<Parking> getSingle(final String customerId, final String licensePlate) {
        final Key key = Key.builder().partitionValue(customerId).sortValue(licensePlate).build();
        return parkingRepository.getSingle(key);
    }
    public Uni<List<Parking>> getAll() {
        return parkingRepository.getAll();
    }
}
