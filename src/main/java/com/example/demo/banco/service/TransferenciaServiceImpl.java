package com.example.demo.banco.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.example.demo.banco.repository.CuentaRepository;
import com.example.demo.banco.repository.TransferenciaRepository;
import com.example.demo.banco.repository.modelo.Cuenta;
import com.example.demo.banco.repository.modelo.Transferencia;

@Service
public class TransferenciaServiceImpl implements TransferenciaService {
	
	@Autowired
	private TransferenciaRepository transferenciaRepository;
	
	@Autowired
	private CuentaRepository cuentaRepository;
	
	@Autowired
	@Qualifier("internacional")
	private MontoDebitarService debitarService;
	

	@Override
	public void insertar(Transferencia transferencia) {
		this.transferenciaRepository.insertar(transferencia);
		
	}

	@Override
	public void actualizar(Transferencia transferencia) {
		this.transferenciaRepository.actualizar(transferencia);
		
	}

	@Override
	public void borrar(String numero) {
		
		this.transferenciaRepository.eliminar(numero);
		
	}

	@Override
	public Transferencia buscar(String numero) {
		
		return this.transferenciaRepository.seleccionar(numero);
	}

	@Override
	public void realizar(String numeroCtaOrigen, String numeroCtaDestino, BigDecimal monto) {
		//1.Consultar la cuenta de origen por el numero 
		Cuenta ctaOrigen = this.cuentaRepository.seleccionar(numeroCtaOrigen);
		//2. Consultar el saldo de la cuenta origen
		BigDecimal saldoOrigen = ctaOrigen.getSaldo();
		
		BigDecimal montoDebitar = this.debitarService.calcular(monto);
		//3.Validar si el saldo es suficiente
		if(montoDebitar.compareTo(saldoOrigen)<=0) {
			
			//5. Si es suficiente ir al paso 6
			//6. Si es suficiente entonces realizamos la resta  del saldo origen y el monto
			BigDecimal nuevoSaldoOrigen = saldoOrigen.subtract(montoDebitar);
			//7. Actualizamos el nuevo saldop de la cuenta origen
			ctaOrigen.setSaldo(nuevoSaldoOrigen);
			this.cuentaRepository.actualizar(ctaOrigen);
			
			//8. Consultamos la cuenta de destino por el numero
			Cuenta ctaDestino = this.cuentaRepository.seleccionar(numeroCtaDestino);
			
			//9. Consultamos el saldo de la cuenta destino
			BigDecimal saldoDestino = ctaDestino.getSaldo();
			//10. Realizamos la suma del saldo destino + monto
			BigDecimal nuevoSaldoDestino = saldoDestino.add(monto);
			//11. Actualizamos el nuevo saldo de la cuenta destino
			ctaDestino.setSaldo(nuevoSaldoDestino);
			
			this.cuentaRepository.actualizar(ctaDestino);
			
			//12. Creamos la Transferencia
			Transferencia transfer = new Transferencia();
			transfer.setCuentaOrigen(ctaOrigen);
			transfer.setCuentaDestino(ctaDestino);
			transfer.setMonto(monto);
			Double numero =Math.random();
			transfer.setNumero(numero.toString());
			transfer.setFecha(LocalDateTime.now());
			
			this.transferenciaRepository.insertar(transfer);
				
		}else {
			//4. Si no es suficiente imprimir mensaje de no hay saldo suficiente

			System.out.println("Saldo no disponible, su saldo es: " + saldoOrigen);
		}
		
		
		
		
	}

	@Override
	public List<Transferencia> reporte() {
		// TODO Auto-generated method stub
		return this.transferenciaRepository.reporte();
	}

}
