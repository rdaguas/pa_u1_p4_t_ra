package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.EstudianteRepository;
import com.example.demo.repository.modelo.Estudiante;

@Service
public class EstudianteServiceImpl implements EstudianteSevice {
	
	@Autowired
	private EstudianteRepository estudianteRepository;
	
	@Override
	public void guardar(Estudiante estudiante) {
		this.estudianteRepository.insertar(estudiante);
			
	}

	@Override
	public void actualizar(Estudiante estudiante) {
		this.estudianteRepository.actualizar(estudiante);
			
	}

	@Override
	public Estudiante buscarporCedula(String cedula) {
		
		return this.estudianteRepository.seleccionar(cedula);
	}

	@Override
	public void borrar(String cedula) {
		this.estudianteRepository.eliminar(cedula);
		
	}

	@Override
	public List<Estudiante> reporteTodos() {
		
		return this.estudianteRepository.seleccionarTodos();
	}

}
