package com.rest.cruddemo;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

@SpringBootApplication
public class DemoRestServiceApplication {

	public static void main(String[] args) {

		SpringApplication.run(DemoRestServiceApplication.class, args);
	}

}
