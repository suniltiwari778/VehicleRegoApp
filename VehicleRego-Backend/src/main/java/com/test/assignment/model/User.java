package com.test.assignment.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

/**
 * This class is used as holder of a list of vehicle registration details.
 * The Class will be further modified as-
 * @Entity
 * @Table(name="USER")
 *
 * and the property registrationsList will be modified as-
 *
 * @OneToMany(mappedBy="user")
 *
 * One user can have multiple registrations, so when making it as Entity the
 */
@Data
public class User {

    @JsonProperty("registrations")
    private List<Registrations> registrationsList;

    @JsonIgnore
    private String userId;
}
