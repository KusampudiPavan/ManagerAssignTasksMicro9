package com.stl.ManagerAssignTasks;

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
class ManagerAssignTasksEmpCheckProgMicroserviceApplicationTests {

    @Test
    @Order(1)
    public void testtask() {
        String jsonbody="{\"employeeemailid\":\"janvitha@gmail.com\",\"manageremailid\":\"hemanth@gmail.com\",\"title\":\"Solve Bugs\",\"task\":\"Bugs in java using spring boot\",\"closedate\":\"2023-05-01\",\"status\":\"0\"}";
        String res=given()
                .header("Content-type","application/json").contentType(ContentType.JSON).accept(ContentType.JSON)
                .body(jsonbody)
                .when()
                .post("http://localhost:8090/task/add")
                .then()
                .assertThat().statusCode(200)
                .extract().response().asString();
    }
    
    
    
    @Test
    @Order(4)
    public void testgetEmployees() {
        String result=given()
                .header("Content-type","application/json").contentType(ContentType.JSON).accept(ContentType.JSON)
                .when()
                .get("http://localhost:8090/task/get/hema@gmail.com")
                .then()
                .assertThat().statusCode(200)
                .extract().response().asString();
    }
    
   
}
