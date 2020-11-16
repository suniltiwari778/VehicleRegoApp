package com.test.assignment.service;

import com.test.assignment.exceptions.UserRegistrationNotFoundException;
import com.test.assignment.model.User;
import com.test.assignment.repository.VehicleRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * This is a service class for vehicle registration. The will provide the capability to fetch the data
 * from database.
 */
@Slf4j
@Service
public class VehicleService {

    @Autowired
    private VehicleRepository vehicleRepository;

    /**
     *
     * @param userId
     * @return This will return registration details of vehicle by its user id.
     * @throws Exception
     */
    public User registrationDetails(String userId) throws UserRegistrationNotFoundException {
        return vehicleRepository.findAllRegistrationsByVehicleId(userId);
    }
}
