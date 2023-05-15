package com.example.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PaU1P4TRaApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(PaU1P4TRaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("Repaso Tarea 3");
		/* Se ha realizado los cambios correctamente*/
		System.out.println("Paso 4 realizado!");
	}

}
