package com.club.club.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.club.club.persistence.entities.Barco;
import com.club.club.persistence.entities.Salida;
import com.club.club.persistence.entities.Socio;
import com.club.club.services.dto.ClubService;

import jakarta.validation.Valid;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/club")

public class ClubController {
	
	@Autowired
    private ClubService clubService;

    @GetMapping("/socio")
    public List<Socio> getAllSocio() {
        return clubService.findAllSocio();
    }

    @GetMapping("/socio/{id}")
    public Optional<Socio> getSocioById(@PathVariable Long id) {
        return clubService.findSocioById(id);
    }

    @PostMapping("/socio")
    public Socio createSocio(@Valid @RequestBody Socio socio) {
        return clubService.saveSocio(socio);
    }

    @DeleteMapping("/socio/{id}")
    public void deleteSocio(@PathVariable Long id) {
        clubService.deleteSocio(id);
    }

    @GetMapping("/barco")
    public List<Barco> getAllBarco() {
        return clubService.findAllBarcos();
    }

    @GetMapping("/barco/{id}")
    public Optional<Barco> getBarcoById(@PathVariable Long id) {
        return clubService.findBarcoById(id);
    }

    @PostMapping("/barco")
    public Barco createBarco(@Valid @RequestBody Barco barco) {
        return clubService.saveBarco(barco);
    }

    @DeleteMapping("/barco/{id}")
    public void deleteBarco(@PathVariable Long id) {
        clubService.deleteBarco(id);
    }

    @GetMapping("/salida")
    public List<Salida> getAllSalida() {
        return clubService.findAllSalida();
    }

    @GetMapping("/salida/{id}")
    public Optional<Salida> getSalidaById(@PathVariable Long id) {
        return clubService.findSalidaById(id);
    }

    @PostMapping("/salida")
    public Salida createSalida(@Valid @RequestBody Salida salida) {
        return clubService.saveSalida(salida);
    }

    @DeleteMapping("/salida/{id}")
    public void deleteSalida(@PathVariable Long id) {
        clubService.deleteSalida(id);
    }

}
