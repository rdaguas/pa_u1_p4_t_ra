package com.example.demo;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.repository.modelo.Estudiante;
import com.example.demo.service.EstudianteSevice;

@SpringBootApplication
public class PaU1P4TRaApplication implements CommandLineRunner {

	@Autowired
	private EstudianteSevice estudianteSevice;
	
	public static void main(String[] args) {
		SpringApplication.run(PaU1P4TRaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Estudiante miEstudiante= new Estudiante();
		miEstudiante.setApellido("Ortega");
		miEstudiante.setCedula("0105966337");
		miEstudiante.setNombre("Jimmy");
		miEstudiante.setFechaNacimiento(LocalDateTime.of(1999, 03, 9, 10, 30));
		
		Estudiante miEstudiante2= new Estudiante();
		miEstudiante2.setApellido("Aguas");
		miEstudiante2.setCedula("123456877");
		miEstudiante2.setNombre("Roberto");
		miEstudiante2.setFechaNacimiento(LocalDateTime.of(2001, 04, 5, 10, 30));
		//1.Guardar
		this.estudianteSevice.guardar(miEstudiante);
		this.estudianteSevice.guardar(miEstudiante2);
		
		
		
		//5.Imprimir Reporte
		List<Estudiante>reporte=this.estudianteSevice.reporteTodos();
		System.out.println("Reporte de todos los Estudiantes");
		for(Estudiante estu: reporte) {
			System.out.println(estu);
			
		}
		
		//2.Actualizar
		miEstudiante.setApellido("Salinas");
		this.estudianteSevice.actualizar(miEstudiante);
	
		
		//5.Imprimir Reporte
		List<Estudiante>reporte2=this.estudianteSevice.reporteTodos();
		System.out.println("Reporte 2 de todos los Estudiantes");
		for(Estudiante estu: reporte2) {
			System.out.println(estu);
			
		}
		
		//3.Eliminar
		this.estudianteSevice.borrar("0105966337");
		//5.Imprimir Reporte
		List<Estudiante>reporte3=this.estudianteSevice.reporteTodos();
		System.out.println("Reporte 3 de todos los Estudiantes");
		for(Estudiante estu: reporte3) {
			System.out.println(estu);
			
		}
		
		//4.Buscar
		Estudiante estudianteEncontrado= this.estudianteSevice.buscarporCedula("123456877");
		System.out.println("Estudainte Encontrado");
		System.out.println(estudianteEncontrado);
		
		Estudiante estudianteEncontrado2= this.estudianteSevice.buscarporCedula("0105966337");
		System.out.println("Estudainte No Encontrado");
		System.out.println(estudianteEncontrado2);
	}
	
	

}
