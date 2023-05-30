package com.example.demo.banco.service;

import java.math.BigDecimal;

import com.example.demo.banco.repository.modelo.Transferencia;

public interface TransferenciaService {
	public void insertar(Transferencia transferencia);
	public void actualizar(Transferencia transferencia);
	public void borrar(String numero);
	public Transferencia buscar(String numero);
	
	public void realizar(String numeroCtaOrigen,String numeroCtaDestino, BigDecimal monto);

}
