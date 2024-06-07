package com.club.club.web.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.club.club.persistence.entities.Barco;
import com.club.club.persistence.entities.Socio;
import com.club.club.services.dto.BarcoService;
import com.club.club.services.dto.SocioService;

@RestController
@RequestMapping("/barcos")
public class BarcoController {
	
	@Autowired
    private BarcoService barcoService;
	
	@GetMapping
	public ResponseEntity<List<Barco>> listAll(){
		return ResponseEntity.ok(this.barcoService.getBarco());
	}
	
	@GetMapping("/{idBarco}")
	public ResponseEntity<Barco> findOne(@PathVariable int idBarco){
		Optional<Barco> barco = this.barcoService.getBarco(idBarco);
		
		if(barco.isPresent()) {
			return ResponseEntity.ok(barco.get());
		}
		else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@PostMapping
	public ResponseEntity<Barco> create(@RequestBody Barco barco){
		return new ResponseEntity<Barco>(this.barcoService.crearBarco(barco), HttpStatus.CREATED);
	}
	
	@PutMapping("/{idBarco}")
	public ResponseEntity<Barco> update(@PathVariable int idBarco , @RequestBody Barco barco){
		if(idBarco == barco.getId()) {
			if(this.barcoService.getBarco(idBarco).isPresent()) {
				return ResponseEntity.ok(this.barcoService.actualizarBarco(barco));
			}
			else {
				return ResponseEntity.notFound().build();
			}
		}
		else {
			return ResponseEntity.badRequest().build();
		}
	}
	
	@DeleteMapping("/{idBarco}")
	public ResponseEntity<Barco> delete(@PathVariable int idBarco){
		if(this.barcoService.borrarBarco(idBarco)) {
			return ResponseEntity.ok().build();
		}
		else {
			return ResponseEntity.notFound().build();
		}
	}

}
