package com.heliommsfilho.quarkusdynamo.service;

import com.heliommsfilho.quarkusdynamo.model.TableInfo;
import com.heliommsfilho.quarkusdynamo.model.mapper.TableMapper;
import com.heliommsfilho.quarkusdynamo.repository.ParkingRepository;
import io.smallrye.mutiny.Uni;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class ParkingService {

    @Inject
    ParkingRepository parkingRepository;

    @Inject
    TableMapper tableMapper;

    public Uni<TableInfo> getTableInfo() {
        return parkingRepository.getTableInfo().map(tableMapper::toTableInfo);
    }
}
