package com.gresmer;

import com.gresmer.controller.MessageJdbcRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class ExperimentsApplication {

	@Autowired
	MessageJdbcRepository repository;

	private static final Logger log = LoggerFactory.getLogger(ExperimentsApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(ExperimentsApplication.class, args);
	}

	@PostConstruct
	public void init() {
		log.info("Message id 1 -> {}", repository.findById(1));
	}

}
