package com.club.club.services.dto;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.club.club.persistence.entities.Salida;
import com.club.club.persistence.repository.SalidaRepository;

@Service
public class SalidaService {
	
	@Autowired
    private SalidaRepository salidaRepository;
	
	public List<Salida> getSalida(){
		return this.salidaRepository.findAll();
	}
	
	public Optional<Salida> getSalida(int idSalida){
		return this.salidaRepository.findById(idSalida);
	}
	
	public Salida crearSalida(Salida salida) {
		
		return this.salidaRepository.save(salida);
	}
	
	public Salida actualizarSalida(Salida salida) {
		return this.salidaRepository.save(salida);
	}

	public boolean borrarSalida(int idSalida) {
		boolean result = false;
		
		if(this.salidaRepository.findById(idSalida).isPresent()) {
			this.salidaRepository.deleteById(idSalida);
			result = true;
		}
		
		return result;
	}

}
