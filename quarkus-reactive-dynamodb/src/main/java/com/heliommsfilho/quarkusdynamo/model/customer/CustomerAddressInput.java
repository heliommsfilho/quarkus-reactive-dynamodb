package com.heliommsfilho.quarkusdynamo.model.customer;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import lombok.extern.jackson.Jacksonized;

import javax.validation.constraints.NotBlank;

@Getter
@Builder
@Jacksonized
@ToString
public class CustomerAddressInput {

    @NotBlank
    private String country;

    @NotBlank
    private String state;

    @NotBlank
    private String city;

    @NotBlank
    private String postalCode;

    @NotBlank
    private String addressLine1;

    private String addressLine2;
}
