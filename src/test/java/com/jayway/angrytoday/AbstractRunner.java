package com.jayway.angrytoday;

import com.jayway.angrytoday.repository.AngryTodayRepository;
import com.jayway.restassured.RestAssured;
import com.jayway.restassured.builder.RequestSpecBuilder;
import com.jayway.restassured.specification.RequestSpecification;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.mortbay.jetty.testing.ServletTester;

import static com.jayway.restassured.parsing.Parser.JSON;

public class AbstractRunner {

    protected static ServletTester tester;

    @Before
    public void setup() {
        AngryTodayRepository.INSTANCE.clear();
    }

    @BeforeClass
    public static void initServletContainer () throws Exception {
        tester = new ServletTester();
        tester.setContextPath("/");
        tester.addServlet( AngryTodayRestService.class, "/angrytoday/*");
        RestAssured.baseURI = tester.createSocketConnector(true);
        RestAssured.defaultParser = JSON;
        RestAssured.basePath = "/angrytoday";
        RestAssured.requestContentType("application/json");
        tester.start();
    }

    /**
     * Stops the Jetty container.
     */
    @AfterClass
    public static void cleanupServletContainer () throws Exception
    {
        tester.stop();
        RestAssured.reset();
    }

    protected RequestSpecification contentTypeFormUrlEncoded() {
        return new RequestSpecBuilder().addHeader( "Content-type", "application/x-www-form-urlencoded").addHeader("Accept", "text/html").build();
    }

    protected RequestSpecification acceptTextHtml() {
        return new RequestSpecBuilder().addHeader("Accept", "text/html").build();
    }

    protected RequestSpecification acceptAtomXml() {
        return new RequestSpecBuilder().addHeader("Accept", "application/atom+xml").build();
    }

}
