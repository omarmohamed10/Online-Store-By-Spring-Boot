package com.SWEPROJECT;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.SWEPROJECT.Controller.ProductController;

@SpringBootApplication
public class MainController 
{
	public static void main(String[]args) 
	{	
		SpringApplication.run(MainController.class, args);	
	}
}
