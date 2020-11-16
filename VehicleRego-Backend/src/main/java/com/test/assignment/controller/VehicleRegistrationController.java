package com.test.assignment.controller;

import com.test.assignment.exceptions.UserRegistrationNotFoundException;
import com.test.assignment.model.User;
import com.test.assignment.service.VehicleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * This is a rest controller class for vehicle registration
 */
@CrossOrigin(origins = "http://localhost:3000")
@RestController
@Slf4j
public class VehicleRegistrationController {

    @Autowired
    VehicleService service;

    /**
     * @param userId
     * @return Vehicle registration details based on User Id supplied as path variable
     * Currently this is retrieving hardcode values.The vales are loaded when the application starts.
     * @throws Exception
     */
    @GetMapping(value = "/vehicle/registrations/{id}/details")
    public ResponseEntity<User> getVehicleRegDetails(@PathVariable("id") String userId) throws UserRegistrationNotFoundException {
        log.info("Called getVehicleRegDetails controller");
        User user = service.registrationDetails(userId);
        if (null == user) {
            throw new UserRegistrationNotFoundException();
        }
        return new ResponseEntity<User>(user, HttpStatus.OK);
    }
}
