package com.test.assignment.repository;

import com.test.assignment.model.Registrations;
import com.test.assignment.model.User;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * This is vehicle repository implementation which provides various CRUD operation that can be performed with Database on User table.
 *
 */
@Repository
public class VehicleRepositoryImpl implements VehicleRepository{

    @Setter
    @Getter
    private User vehicleRegistrations;


    /**
     *This is returning hardcoded vehicle registration details based on userId id (Same details) for all id.
     *This will be modified to fetch data from DB based on specific userId id passed as argument.
     * @param userId
     * @return
     */
    @Override
    public User findAllRegistrationsByVehicleId(String userId) {
        return  vehicleRegistrations;
    }

    public void saveRegistrations(List<Registrations> registrations) {
        vehicleRegistrations = new User();
        vehicleRegistrations.setRegistrationsList(registrations);

    }


}
