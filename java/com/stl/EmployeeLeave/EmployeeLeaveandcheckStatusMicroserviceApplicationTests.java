package com.stl.EmployeeLeave;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import io.restassured.http.ContentType;
import static io.restassured.RestAssured.*;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.boot.test.context.SpringBootTest;


@SuppressWarnings("unused")
@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class EmployeeLeaveandcheckStatusMicroserviceApplicationTests {

    @Test
    @Order(1)
    public void testaddleave() {
        String jsonbody="{\"employeeemail\":\"janvitha@gmail.com\",\"fromdate\":\"2023-05-09\",\"todate\":\"2023-05-15\",\"leavereason\":\"Health Issues\",\"leavestatus\":\"Pending\",\"manageremail\":\"hemanth@gmail.com\"}";
        String res=given()
                .header("Content-type","application/json").contentType(ContentType.JSON).accept(ContentType.JSON)
                .body(jsonbody)
                .when()
                .post("http://localhost:8088/leave/addleave")
                .then()
                .assertThat().statusCode(200)
                .extract().response().asString();
    }
    
//    @Test
//    @Order(2)
//    public void testLogin() {
//        String jsonbody= "{\"email\" : \"pavan@gmail.com\",\"password\" : \"pavan0209\"}";
//        String token=given()
//                .header("Content-type","application/json").contentType(ContentType.JSON).accept(ContentType.JSON)
//                .body(jsonbody)
//                .when()
//                .post("http://localhost:8082/Employees/authenticate")
//                .then()
//                .assertThat().statusCode(200)
//                .extract().response().asString();
//    }
    
    @Test
    @Order(3)
    public void testgetallLeaves() {
        String result=given()
                .header("Content-type","application/json").contentType(ContentType.JSON).accept(ContentType.JSON)
                .when()
                .get("http://localhost:8088/leave/get")
                .then()
                .assertThat().statusCode(200)
                .extract().response().asString();
    }
    
    @Test
    @Order(4)
    public void testgetleavesbyid() {
        String result=given()
                .header("Content-type","application/json").contentType(ContentType.JSON).accept(ContentType.JSON)
                .when()
                .get("http://localhost:8088/leave/get/all/janvitha@gmail.com")
                .then()
                .assertThat().statusCode(200)
                .extract().response().asString();
    }
    
//    @Test
//    @Order(5)
//    public void testdeleteleavebyid() {
//        String jsonbody= "{\"email\" : \"janvitha@gmail.com\",\"password\" : \"janvitha\"}";
//        String token=given()
//                .header("Content-type","application/json").contentType(ContentType.JSON).accept(ContentType.JSON)
//                .body(jsonbody)
//                .when()
//                .put("http://localhost:8088/leave/delete/14")
//                .then()
//                .assertThat().statusCode(200)
//                .extract().response().asString();
//
//    }
}

