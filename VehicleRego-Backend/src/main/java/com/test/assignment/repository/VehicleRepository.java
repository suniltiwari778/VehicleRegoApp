package com.test.assignment.repository;

import com.test.assignment.model.User;
import org.springframework.stereotype.Repository;

/**
 * Main Vehicle Repository interface which has a custom method to fetch vehicle details based on userId id.
 */

@Repository
public interface VehicleRepository //extends CrudRepository<User, String>
{
    public User findAllRegistrationsByVehicleId(String userId);
}
