package com.test.assignment.model;

import lombok.Data;

import java.util.Date;

/**
 * This class provides Registration details. This will be modified with the
 * @Entity at class level and properties with @Column and @Id to make it relate with Registration table in database.
 *
 */
@Data
public class Registration {
    private boolean expired;
    private Date expiry_date;

}
