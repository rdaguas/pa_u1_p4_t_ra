package com.example.demo.banco.service;

import com.example.demo.banco.repository.modelo.Transferencia;

public interface TransferenciaService {
	public void insertar(Transferencia transferencia);
	public void actualizar(Transferencia transferencia);
	public void borrar(String numero);
	public Transferencia buscar(String numero);

}
