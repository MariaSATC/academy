package com.ctw.workstation.resource;//package com.ctw.workstation.resource;
//
//import io.quarkus.test.junit.QuarkusTest;
//import io.restassured.RestAssured;
//import io.restassured.http.ContentType;
//import org.jboss.logging.Logger;
//import org.junit.jupiter.api.MethodOrderer;
//import org.junit.jupiter.api.Order;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.TestMethodOrder;
//
//
//import static org.junit.jupiter.api.Assertions.*;
//
//@QuarkusTest
//@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
//class BookingResourceTest {
//
//    Logger log = Logger.getLogger(BookingResourceTest.class);
// injects
//    @Order(4)
//    @Test
//    void create_booking(){
//        RestAssured.given()
//                .contentType(ContentType.JSON)
//                .body("""
//                        {
//                  "NAME": "string",
//                  "book_from": "2022-03-10T12:15:50",
//                  "book_to": "2022-03-10T12:15:50",
//                  "created_at": "2022-03-10T12:15:50",
//                  "modified_at": "2022-03-10T12:15:50",
//                  "teamMemberId": "0",
//                  "teamMember": null,
//                  "rackId": "0",
//                  "rack": null,
//                  "bookFrom": "2022-03-10T12:15:50",
//                  "bookTo": "2022-03-10T12:15:50",
//                  "nAME": "string"
//                }
//                """)
//                .when()
//                .post("/bookings")
//                .then()
//                .statusCode(201);
//    }
//
//    @Order(3)
//    @Test
//    void create_rack(){
//        RestAssured.given()
//                .contentType(ContentType.JSON)
//                .body("""
//                       {
//                   "id": "8A0Fea93-2Ce7-B497-A66F-fBF072CC6bB1",
//                   "serialNumber": "string",
//                   "assembledAt": "2022-03-10T12:15:50",
//                   "createddAt": "2022-03-10T12:15:50",
//                   "modifiedAt": "2022-03-10T12:15:50",
//                   "status": "ACTIVE",
//                   "teamId": "0",
//                   "team": null,
//                   "rackAssets": null,
//                   "bookings": null
//                 }
//                """)
//                .when()
//                .post("/racks")
//                .then()
//                .statusCode(201);
//    }
//
//    @Order(2)
//    @Test
//    void create_teamMember(){
//        RestAssured.given()
//                .contentType(ContentType.JSON)
//                .body("""
//                      {
//                        "id": "74b840bB-bebb-95a3-47f3-91d4fd8d4e5C",
//                        "NAME": "string",
//                        "ctw_id": "string",
//                        "created_at": "2022-03-10T12:15:50",
//                        "modified_at": "2022-03-10T12:15:50",
//                        "teamId": "0",
//                        "team": null,
//                        "nAME": "string"
//                      }
//                """)
//                .when()
//                .post("/teamMembers")
//                .then()
//                .statusCode(201);
//    }
//
//    @Order(1)
//    @Test
//    void create_team(){
//        RestAssured.given()
//                .contentType(ContentType.JSON)
//                .body("""
//                      {
//
//                         "name": "string",
//                          "product": "string",
//                          "created_at": "2022-03-10T12:15:50",
//                          "modified_at": "2022-03-10T12:15:50",
//                          "default_location": "string",
//                          "racks": null,
//                          "teamMembers": null
//                      }
//                """)
//                .when()
//                .post("/teams")
//                .then()
//                .statusCode(201);
//    }
//}