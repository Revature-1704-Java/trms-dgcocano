package com.revature.controllers;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.*;
public class TestServlet extends HttpServlet {

  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

//    response.getWriter().append("Hello World1");
    String jsonString = "{\"name\":\"Test \"}";

    response.setContentType("application/json"); //Technically not needed, lets browser know exactly what its dealing with

    ObjectMapper mapper = new ObjectMapper();

    Person me = mapper.readValue(jsonString, Person.class);

    //send back person object
    mapper.writeValue(response.getOutputStream(), me);
  }

}
