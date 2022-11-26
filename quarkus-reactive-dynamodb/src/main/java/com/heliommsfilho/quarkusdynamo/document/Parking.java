package com.heliommsfilho.quarkusdynamo.document;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import software.amazon.awssdk.enhanced.dynamodb.extensions.annotations.DynamoDbAutoGeneratedTimestampAttribute;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbBean;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbPartitionKey;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbSortKey;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@DynamoDbBean
@Getter
@Setter
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Parking {

    private String customerId;
    private String licensePlate;
    private Instant startingTime;
    private Instant endTime;
    private Integer durationInMinutes;
    private BigDecimal cost;
    private List<TimeExtension> timeExtensions = new ArrayList<>();
    private Instant createTimestamp;
    private Instant updateTimestamp;

    @DynamoDbPartitionKey
    public String getCustomerId() { return customerId; }

    @DynamoDbSortKey
    public String getLicensePlate() { return licensePlate; }

    @DynamoDbAutoGeneratedTimestampAttribute
    public Instant getUpdateTimestamp() { return updateTimestamp; }

    @Getter
    @Setter
    @ToString
    public static class TimeExtension {

        private Integer durationInMinutes;
        private BigDecimal cost;
        private Instant createTimestamp;
        private Instant updateTimestamp;

        @DynamoDbAutoGeneratedTimestampAttribute
        public Instant getUpdateTimestamp() { return updateTimestamp; }
    }
}