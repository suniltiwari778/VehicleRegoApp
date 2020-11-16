package com.test.assignment.model;

import lombok.Data;


/**
 * This class provides Insurer details. This will be modified with the
 * @Entity at class level and properties with @Column and @Id to make it relate with Insurer table in database.
 *
 */
@Data
public class Insurer {
    private String name;
    private String code;
}
