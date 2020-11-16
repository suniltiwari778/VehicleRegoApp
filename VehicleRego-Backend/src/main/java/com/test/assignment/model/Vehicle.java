package com.test.assignment.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * This class provides Vehicle details. This will be modified with the
 * @Entity at class level and properties with @Column and @Id to make it relate with Vehicle table in database.
 *
 */
@Data
public class Vehicle {

    private String type;
    private String make;
    private String model;
    private String colour;
    private long vin;
    @JsonProperty("tare_weight")
    private int tareWeight;
    @JsonProperty("gross_mass")
    private String grossMass;
}
