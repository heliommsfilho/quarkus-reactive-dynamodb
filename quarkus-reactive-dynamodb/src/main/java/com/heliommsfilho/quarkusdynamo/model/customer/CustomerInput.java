package com.heliommsfilho.quarkusdynamo.model.customer;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import lombok.extern.jackson.Jacksonized;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Getter
@Builder
@Jacksonized
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class CustomerInput {

    @NotBlank
    private String name;

    @NotBlank
    private String driverLicense;

    @Valid
    @NotNull
    private CustomerAddressInput homeAddress;

    @Valid
    private CustomerAddressInput workAddress;

    @Builder.Default
    private List<@Valid CustomerVehicleInput> vehicles = new ArrayList<>();
}
