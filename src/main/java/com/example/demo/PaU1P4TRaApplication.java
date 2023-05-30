package com.example.demo;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.banco.repository.modelo.Cuenta;
import com.example.demo.banco.service.CuentaService;
import com.example.demo.banco.service.TransferenciaService;
import com.example.demo.repository.modelo.Estudiante;
import com.example.demo.service.EstudianteSevice;

@SpringBootApplication
public class PaU1P4TRaApplication implements CommandLineRunner {

	@Autowired
	private CuentaService cuentaService;
	
	@Autowired
	private TransferenciaService transferenciaService;
	
	
	public static void main(String[] args) {
		SpringApplication.run(PaU1P4TRaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		//Cta1
		Cuenta cta1 = new Cuenta();
		cta1.setCedulaPropietario("1234");
		cta1.setFechaApertura(LocalDate.now());
		cta1.setNumero("432");
		cta1.setSaldo(new BigDecimal(200));
		cta1.setTipo("A");
		
		this.cuentaService.guardar(cta1);
		
		//Cta2
		Cuenta cta2 = new Cuenta();
		cta2.setCedulaPropietario("222");
		cta2.setFechaApertura(LocalDate.now());
		cta2.setNumero("789");
		cta2.setSaldo(new BigDecimal(100));
		cta2.setTipo("A");
				
		this.cuentaService.guardar(cta2);
		
		this.transferenciaService.realizar("1234", "222", new BigDecimal(10));
		
		System.out.println("Saldo Origen:" + this.cuentaService.buscarPorNumero("1234").getSaldo());
		System.out.println("Saldo Destino:" + this.cuentaService.buscarPorNumero("222").getSaldo());
		
		
	}
		
	
	
	

}
