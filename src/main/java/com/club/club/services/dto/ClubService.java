package com.club.club.services.dto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.club.club.persistence.entities.Barco;
import com.club.club.persistence.entities.Salida;
import com.club.club.persistence.entities.Socio;
import com.club.club.persistence.repository.BarcoRepository;
import com.club.club.persistence.repository.SalidaRepository;
import com.club.club.persistence.repository.SocioRepository;

import java.util.List;
import java.util.Optional;

@Service
@jakarta.transaction.Transactional
public class ClubService {
	
	@Autowired
    private SocioRepository socioRepository;

    @Autowired
    private BarcoRepository barcoRepository;

    @Autowired
    private SalidaRepository salidaRepository;

    public List<Socio> findAllSocio() {
        return socioRepository.findAll();
    }

    public Optional<Socio> findSocioById(Long id) {
        return socioRepository.findById(id);
    }

    public Socio saveSocio(Socio socio) {
        return socioRepository.save(socio);
    }

    public void deleteSocio(Long id) {
        socioRepository.deleteById(id);
    }

    public List<Barco> findAllBarcos() {
        return barcoRepository.findAll();
    }

    public Optional<Barco> findBarcoById(Long id) {
        return barcoRepository.findById(id);
    }

    public Barco saveBarco(Barco barco) {
        return barcoRepository.save(barco);
    }

    public void deleteBarco(Long id) {
        barcoRepository.deleteById(id);
    }

    public List<Salida> findAllSalida() {
        return salidaRepository.findAll();
    }

    public Optional<Salida> findSalidaById(Long id) {
        return salidaRepository.findById(id);
    }

    public Salida saveSalida(Salida salida) {
        return salidaRepository.save(salida);
    }

    public void deleteSalida(Long id) {
        salidaRepository.deleteById(id);
    }
    
}