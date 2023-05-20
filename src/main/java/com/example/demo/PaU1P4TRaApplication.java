package com.example.demo;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PaU1P4TRaApplication implements CommandLineRunner {

	@Autowired
	private Profesor profe2;
	
	@Autowired
	private Profesor profe3;	
	
	public static void main(String[] args) {
		SpringApplication.run(PaU1P4TRaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("Mi primer proyecto");
		Profesor profe = new Profesor();
		profe.setNombre("Jimmy");
		profe.setCedula("0105966337");
		profe.setFechaNacimiento(LocalDateTime.now());
		profe.setApellido("Ortega");
		
		System.out.println(profe);
		profe.setApellido("Aguas");
		System.out.println(profe.getApellido());		

		System.out.println(profe2);
		profe2.setApellido("Teran");
		profe2.setApellido("");
		System.out.println(profe2.getApellido());
		
		//Profesor profe3 = new Profesor();
		profe3 = profe;
		System.out.println(profe3);
		profe.setApellido("Valencia");
		System.out.println(profe3);
		
		MatriculaCalculo mat = new MatriculaCalculo();
		mat.realizarMatricula("1");
	}

}
