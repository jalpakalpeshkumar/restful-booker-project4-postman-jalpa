package com.herokuapp.restfulbooker.testbase;

import io.restassured.RestAssured;
import org.testng.annotations.BeforeClass;

/**
 * Created by Jay Vaghani
 */
public class TestBase {

    @BeforeClass
    public void init(){
        RestAssured.baseURI = "https://restful-booker.herokuapp.com/" ;
        RestAssured.basePath = "/apidoc";

    }

}