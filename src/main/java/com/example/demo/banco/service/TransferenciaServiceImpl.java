package com.example.demo.banco.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.example.demo.banco.repository.modelo.Transferencia;

@Service
public class TransferenciaServiceImpl implements TransferenciaService {

	@Autowired
	private TransferenciaService transferenciaService;
	@Override
	public void insertar(Transferencia transferencia) {
		this.transferenciaService.insertar(transferencia);
		
	}

	@Override
	public void actualizar(Transferencia transferencia) {
		// TODO Auto-generated method stub
		this.transferenciaService.actualizar(transferencia);
		
	}

	@Override
	public void borrar(String numero) {
		// TODO Auto-generated method stub
		this.transferenciaService.borrar(numero);
		
	}

	@Override
	public Transferencia buscar(String numero) {
		// TODO Auto-generated method stub
		return this.transferenciaService.buscar(numero);
	}

}
