package com.heliommsfilho.quarkusdynamo.repository;

import io.smallrye.mutiny.Uni;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbAsyncTable;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbEnhancedAsyncClient;
import software.amazon.awssdk.enhanced.dynamodb.Key;
import software.amazon.awssdk.enhanced.dynamodb.TableSchema;
import software.amazon.awssdk.enhanced.dynamodb.model.DescribeTableEnhancedResponse;
import software.amazon.awssdk.enhanced.dynamodb.model.Page;
import software.amazon.awssdk.services.dynamodb.model.TableDescription;

import java.util.List;

@NoArgsConstructor
public abstract class DynamoDBAsyncRepository<T> {

    @Getter(AccessLevel.PROTECTED)
    private DynamoDbAsyncTable<T> table;

    public DynamoDBAsyncRepository(DynamoDbEnhancedAsyncClient enhancedClient) {
        this.table = enhancedClient.table(getTableName(), TableSchema.fromClass(getTableClass()));
    }

    abstract Class<T> getTableClass();
    abstract String getTableName();

    public Uni<TableDescription> getTableInfo() {
        return Uni.createFrom().completionStage(table::describeTable).map(DescribeTableEnhancedResponse::table);
    }

    public Uni<Void> save(final T item) {
        return Uni.createFrom().completionStage(table.putItem(item));
    }

    public Uni<T> getSingle(final Key key) {
        return Uni.createFrom().completionStage(table.getItem(key));
    }

    public Uni<List<T>> getAll() {
        return Uni.createFrom().publisher(getTable().scan()).map(Page::items);
    }
}
