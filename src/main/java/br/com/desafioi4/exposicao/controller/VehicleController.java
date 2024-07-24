package br.com.desafioi4.exposicao.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.desafioi4.exposicao.dto.VehicleDto;
import br.com.desafioi4.exposicao.service.VehicleService;
import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/vehicle")
public class VehicleController {
	
	@Autowired
	private VehicleService service;
	
	@GetMapping
	@Operation(summary = "Buscar todos os veiculos", description = "Buscar todos os veiculos")
	public ResponseEntity<List<VehicleDto>> getAllVehicle() {
		return ResponseEntity.ok(service.getAllVehicles());
	}
	
	@Operation(summary = "Cadastrar veiculo", description = "Cadastrar um veiculo")
	@PostMapping
	public ResponseEntity<VehicleDto> registerVehicle(@RequestBody VehicleDto vehicle) {
		return ResponseEntity.ok(service.registerVehicle(vehicle));
	}
}
