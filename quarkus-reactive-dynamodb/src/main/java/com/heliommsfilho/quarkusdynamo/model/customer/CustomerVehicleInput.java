package com.heliommsfilho.quarkusdynamo.model.customer;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import lombok.extern.jackson.Jacksonized;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Builder
@Jacksonized
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class CustomerVehicleInput {

    @NotBlank
    @EqualsAndHashCode.Include
    private String licensePlate;

    @NotBlank
    private String brand;

    @NotBlank
    private String model;

    @NotNull
    private Integer year;

    @NotBlank
    private String color;
}
