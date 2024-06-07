package com.club.club.services.dto;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.club.club.persistence.entities.Socio;
import com.club.club.persistence.repository.SocioRepository;

@Service
public class SocioService {
	
	@Autowired
    private SocioRepository socioRepository;
	
	public List<Socio> getSocio(){
		return this.socioRepository.findAll();
	}
	
	public Optional<Socio> getSocio(int idSocio){
		return this.socioRepository.findById(idSocio);
	}
	
	public Socio crearSocio(Socio socio) {
		
		return this.socioRepository.save(socio);
	}
	
	public Socio actualizarSocio(Socio socio) {
		return this.socioRepository.save(socio);
	}

	public boolean borrarSocio(int idSocio) {
		boolean result = false;
		
		if(this.socioRepository.findById(idSocio).isPresent()) {
			this.socioRepository.deleteById(idSocio);
			result = true;
		}
		
		return result;
	}
	
}
