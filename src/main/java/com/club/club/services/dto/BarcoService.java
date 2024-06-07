package com.club.club.services.dto;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.club.club.persistence.entities.Barco;
import com.club.club.persistence.repository.BarcoRepository;

@Service
public class BarcoService {
	
	@Autowired
    private BarcoRepository barcoRepository;
	
	public List<Barco> getBarco(){
		return this.barcoRepository.findAll();
	}
	
	public Optional<Barco> getBarco(int idBarco){
		return this.barcoRepository.findById(idBarco);
	}
	
	public Barco crearBarco(Barco barco) {
		
		return this.barcoRepository.save(barco);
	}
	
	public Barco actualizarBarco(Barco barco) {
		return this.barcoRepository.save(barco);
	}

	public boolean borrarBarco(int idBarco) {
		boolean result = false;
		
		if(this.barcoRepository.findById(idBarco).isPresent()) {
			this.barcoRepository.deleteById(idBarco);
			result = true;
		}
		
		return result;
	}

}
