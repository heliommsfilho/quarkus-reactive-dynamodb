package com.heliommsfilho.quarkusdynamo.model.tableinfo;

import com.heliommsfilho.quarkusdynamo.model.tableinfo.TableInfoOutput.Attribute;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import software.amazon.awssdk.services.dynamodb.model.AttributeDefinition;
import software.amazon.awssdk.services.dynamodb.model.KeySchemaElement;
import software.amazon.awssdk.services.dynamodb.model.TableDescription;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.CDI)
public interface TableInfoMapper {

    @Mapping(target = "name", expression = "java(tableDescription.tableName())")
    @Mapping(target = "keys", expression = "java(toKeys(tableDescription.keySchema()))")
    @Mapping(target = "attributes", expression = "java(toAttributes(tableDescription.attributeDefinitions()))")
    @Mapping(target = "status", expression = "java(tableDescription.tableStatusAsString())")
    @Mapping(target = "rcu", expression = "java(tableDescription.provisionedThroughput().readCapacityUnits())")
    @Mapping(target = "wcu", expression = "java(tableDescription.provisionedThroughput().writeCapacityUnits())")
    @Mapping(target = "tableSize", expression = "java(tableDescription.tableSizeBytes())")
    @Mapping(target = "itemCount", expression = "java(tableDescription.itemCount())")
    @Mapping(target = "arn", expression = "java(tableDescription.tableArn())")
    @Mapping(target = "creationDate", expression = "java(tableDescription.creationDateTime())")
    TableInfoOutput toTableInfo(final TableDescription tableDescription);

    @Mapping(target = "name", expression = "java(attribute.attributeName())")
    @Mapping(target = "type", expression = "java(attribute.attributeTypeAsString())")
    Attribute toKey(AttributeDefinition attribute);

    List<Attribute> toAttributes(final List<AttributeDefinition> attributes);

    @Mapping(target = "name", expression = "java(key.attributeName())")
    @Mapping(target = "type", expression = "java(key.keyType().toString())")
    Attribute toKey(KeySchemaElement key);

    List<Attribute> toKeys(final List<KeySchemaElement> keys);
}
