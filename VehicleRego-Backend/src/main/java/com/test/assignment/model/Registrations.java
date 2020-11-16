package com.test.assignment.model;

import lombok.Data;

/**
 * This class provides Registrations details. This Class will be modified as
 * @Entity
 * @Table(name="REGISTRATIONS")
 * and the further the mapping with User class will be done as -
 * //    @ManyToOne
 * //    @JoinColumn(name="userId", nullable=false)
 * //    private User user;
 */
@Data
public class Registrations {
    //plate_number
    private String plateNumber;

    //registration
    private Registration registration;

    //vehicle
    private Vehicle vehicle;

    //insurer
    private Insurer insurer;

}
