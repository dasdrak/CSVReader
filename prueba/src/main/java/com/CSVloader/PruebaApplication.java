package com.CSVloader;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication

public class PruebaApplication implements CommandLineRunner {

	public static void main(String[] args) throws FileNotFoundException, IOException, SQLException {
		SpringApplication.run(PruebaApplication.class, args);
		CSVRead.main(args);
	}

	@Override
	public void run(String... args) throws Exception {

	}

}
