package com.example.demo.service;

import java.util.List;

import com.example.demo.repository.modelo.Estudiante;

public interface EstudianteSevice {
	
	public void guardar(Estudiante estudiante);
	
	
	public void actualizar(Estudiante estudiante);
	
	//Buscar por un identificador
	public Estudiante buscarporCedula(String cedula);
	public void borrar(String cedula);
	
	public List<Estudiante>reporteTodos();
	

}
