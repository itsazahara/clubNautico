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

import com.club.club.persistence.entities.Salida;
import com.club.club.services.dto.SalidaService;

@RestController
@RequestMapping("/salidas")
public class SalidaController {
	
	@Autowired
    private SalidaService salidaService;
	
	@GetMapping
	public ResponseEntity<List<Salida>> listAll(){
		return ResponseEntity.ok(this.salidaService.getSalida());
	}
	
	@GetMapping("/{idSalida}")
	public ResponseEntity<Salida> findOne(@PathVariable int idSalida){
		Optional<Salida> salida = this.salidaService.getSalida(idSalida);
		
		if(salida.isPresent()) {
			return ResponseEntity.ok(salida.get());
		}
		else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@PostMapping
	public ResponseEntity<Salida> create(@RequestBody Salida salida){
		return new ResponseEntity<Salida>(this.salidaService.crearSalida(salida), HttpStatus.CREATED);
	}
	
	@PutMapping("/{idSalida}")
	public ResponseEntity<Salida> update(@PathVariable int idSalida , @RequestBody Salida salida){
		if(idSalida == salida.getId()) {
			if(this.salidaService.getSalida(idSalida).isPresent()) {
				return ResponseEntity.ok(this.salidaService.actualizarSalida(salida));
			}
			else {
				return ResponseEntity.notFound().build();
			}
		}
		else {
			return ResponseEntity.badRequest().build();
		}
	}
	
	@DeleteMapping("/{idSalida}")
	public ResponseEntity<Salida> delete(@PathVariable int idSalida){
		if(this.salidaService.borrarSalida(idSalida)) {
			return ResponseEntity.ok().build();
		}
		else {
			return ResponseEntity.notFound().build();
		}
	}

}
