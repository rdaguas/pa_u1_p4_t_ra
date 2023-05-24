package com.example.demo.banco.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.banco.repository.modelo.Cuenta;

@Repository
public class CuentaRepositoryImpl implements CuentaRepository{
	
private static List<Cuenta> baseDatos = new ArrayList<>();
	
	
	@Override
	public void insertar(Cuenta cuenta) {
		// TODO Auto-generated method stub
		baseDatos.add(cuenta);
	}

	@Override
	public void actualizar(Cuenta cuenta) {
		// TODO Auto-generated method stub
		this.eliminar(cuenta.getNumero());
		this.insertar(cuenta);
	}

	@Override
	public void eliminar(String numero) {
		Cuenta cuen =this.seleccionar(numero);
		baseDatos.remove(cuen);
	}
		// TODO Auto-generated method stub
		
		

	@Override
	public Cuenta seleccionar(String numero) {
		Cuenta cuenEncontrado = new Cuenta();
		for(Cuenta cuen : baseDatos){
			if(numero.equals(cuen.getNumero())) {
				cuenEncontrado= cuen;
				
			}
		}
	
		return cuenEncontrado;

	}


}
