package com.test.assignment.controller;

import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

class VehicleRegistrationControllerTest {

    @Test
    public void testStatusShouldBe200() {

        String userId = "1";

        given().
                pathParam("id", userId).
                when().
                get("http://localhost:8088/vehicle/registrations/{id}/details").
                then().
                assertThat().
                statusCode(200);

    }
    @Test
    public void testStatusShouldBe404() {

        String userId = "";

        given().
                pathParam("id", userId).
                when().
                get("http://localhost:8088/vehicle/registrations/{id}/details").
                then().
                assertThat().
                statusCode(404);

    }
}