package com.test.assignment;

import com.test.assignment.model.Insurer;
import com.test.assignment.model.Registration;
import com.test.assignment.model.Registrations;
import com.test.assignment.model.Vehicle;
import com.test.assignment.repository.VehicleRepositoryImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@SpringBootApplication
@Slf4j
public class AssignmentApplication implements ApplicationRunner {

    @Autowired
    private VehicleRepositoryImpl vehicleRepository;

    public static void main(String[] args) {
        SpringApplication.run(AssignmentApplication.class, args);
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {


        buildRegistrationData();
    }

    private void buildRegistrationData() {

        log.info("build data");
        List<Registrations> listRegistrations = new ArrayList<Registrations>();

        /* -----   registrations A start ----------*/
        Registrations registrationsA = new Registrations();

        Registration registrationA = new Registration();
        registrationA.setExpired(false);
        registrationA.setExpiry_date(new Date());

        //Vehicle details

        Vehicle vehicleA = new Vehicle();
        vehicleA.setType("Wagon");
        vehicleA.setMake("BMW");
        vehicleA.setModel("X4 M40i");
        vehicleA.setColour("Blue");
        vehicleA.setVin(Long.valueOf("12389347324"));
        vehicleA.setTareWeight(1700);
        vehicleA.setGrossMass(null);

        //insurer details
        Insurer insurerA = new Insurer();
        insurerA.setCode("Allianz");
        insurerA.setCode("32");

        //
        registrationsA.setPlateNumber("EBF28E");
        registrationsA.setRegistration(registrationA);
        registrationsA.setVehicle(vehicleA);
        registrationsA.setInsurer(insurerA);

        /*------------------- registrations A End ------ */

        /* -----   registrations B start ----------*/

        Registrations registrationsB = new Registrations();

        Registration registrationB = new Registration();
        registrationB.setExpired(true);
        registrationB.setExpiry_date(new Date());

        //Vehicle details

        Vehicle vehicleB = new Vehicle();
        vehicleB.setType("Hatch");
        vehicleB.setMake("Toyota");
        vehicleB.setModel("Corolla");
        vehicleB.setColour("Silver");
        vehicleB.setVin(Long.valueOf("54646546313"));
        vehicleB.setTareWeight(1432);
        vehicleB.setGrossMass("1500");

        //insurer details
        Insurer insurerB = new Insurer();
        insurerB.setCode("AAMI");
        insurerB.setCode("17");

        //
        registrationsB.setPlateNumber("CXD82F");
        registrationsB.setRegistration(registrationB);
        registrationsB.setVehicle(vehicleB);
        registrationsB.setInsurer(insurerB);

        /*------------------- registrations B End ------ */

        /* -----   registrations C start ----------*/
        Registrations registrationsC = new Registrations();

        Registration registrationC = new Registration();
        registrationC.setExpired(false);
        registrationC.setExpiry_date(new Date());

        //Vehicle details

        Vehicle vehicleC = new Vehicle();
        vehicleC.setType("Sedan");
        vehicleC.setMake("Mercedes");
        vehicleC.setModel("X4 M40i");
        vehicleC.setColour("Blue");
        vehicleC.setVin(Long.valueOf("87676676762"));
        vehicleC.setTareWeight(1700);
        vehicleC.setGrossMass(null);

        //insurer details
        Insurer insurerC = new Insurer();
        insurerC.setCode("GIO");
        insurerC.setCode("13");

        registrationsC.setPlateNumber("WOP29P");
        registrationsC.setRegistration(registrationC);
        registrationsC.setVehicle(vehicleC);
        registrationsC.setInsurer(insurerC);

        /*------------------- registrations C End ------ */


        /* -----   registrations D start ----------*/
        Registrations registrationsD = new Registrations();

        Registration registrationD = new Registration();
        registrationD.setExpired(false);
        registrationD.setExpiry_date(new Date());

        //Vehicle details

        Vehicle vehicleD = new Vehicle();
        vehicleD.setType("SUV");
        vehicleD.setMake("Jaguar");
        vehicleD.setModel("F pace");
        vehicleD.setColour("Green");
        vehicleD.setVin(Long.valueOf("65465466541"));
        vehicleD.setTareWeight(1620);
        vehicleD.setGrossMass(null);

        //insurer details
        Insurer insurerD = new Insurer();
        insurerD.setCode("NRMA");
        insurerD.setCode("27");

        registrationsD.setPlateNumber("QWX55Z");
        registrationsD.setRegistration(registrationD);
        registrationsD.setVehicle(vehicleD);
        registrationsD.setInsurer(insurerD);

        /*------------------- registrations D End ------ */


        listRegistrations.add(registrationsA);
        listRegistrations.add(registrationsB);
        listRegistrations.add(registrationsC);
        listRegistrations.add(registrationsD);
        vehicleRepository.saveRegistrations(listRegistrations);
    }
}
