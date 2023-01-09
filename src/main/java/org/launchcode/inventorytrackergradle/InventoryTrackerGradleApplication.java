package org.launchcode.inventorytrackergradle;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class InventoryTrackerGradleApplication {
	@RequestMapping("/")
	public String hello() {
		return "Hello, World!";
	}
	public static void main(String[] args) {
		SpringApplication.run(InventoryTrackerGradleApplication.class, args);
		System.out.println("Hello world!");
	}

}
