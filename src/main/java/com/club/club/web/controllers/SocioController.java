package com.club.club.web.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.club.club.persistence.entities.Socio;
import com.club.club.services.dto.SocioService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/socios")

public class SocioController {
	
	@Autowired
    private SocioService socioService;
	
	@GetMapping
	public ResponseEntity<List<Socio>> listAll(){
		return ResponseEntity.ok(this.socioService.getSocio());
	}
	
	@GetMapping("/{idSocio}")
	public ResponseEntity<Socio> findOne(@PathVariable int idSocio){
		Optional<Socio> socio = this.socioService.getSocio(idSocio);
		
		if(socio.isPresent()) {
			return ResponseEntity.ok(socio.get());
		}
		else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@PostMapping
	public ResponseEntity<Socio> create(@RequestBody Socio socio){
		return new ResponseEntity<Socio>(this.socioService.crearSocio(socio), HttpStatus.CREATED);
	}
	
	@PutMapping("/{idSocio}")
	public ResponseEntity<Socio> update(@PathVariable int idSocio , @RequestBody Socio socio){
		if(idSocio == socio.getId()) {
			if(this.socioService.getSocio(idSocio).isPresent()) {
				return ResponseEntity.ok(this.socioService.actualizarSocio(socio));
			}
			else {
				return ResponseEntity.notFound().build();
			}
		}
		else {
			return ResponseEntity.badRequest().build();
		}
	}
	
	@DeleteMapping("/{idSocio}")
	public ResponseEntity<Socio> delete(@PathVariable int idSocio){
		if(this.socioService.borrarSocio(idSocio)) {
			return ResponseEntity.ok().build();
		}
		else {
			return ResponseEntity.notFound().build();
		}
	}
}
