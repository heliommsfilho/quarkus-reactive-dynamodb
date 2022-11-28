package com.heliommsfilho.quarkusdynamo.model.tableinfo;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import lombok.extern.jackson.Jacksonized;

import java.time.Instant;
import java.util.List;

@Getter
@Builder
@Jacksonized
@ToString
public class TableInfoOutput {

    private String name;
    private List<Attribute> keys;
    private List<Attribute> attributes;
    private String status;
    private Long rcu;
    private Long wcu;
    private Long tableSize;
    private Long itemCount;
    private String arn;
    private Instant creationDate;

    @Getter
    @Builder
    @Jacksonized
    @ToString
    public static class Attribute {

        private String name;
        private String type;
    }
}
