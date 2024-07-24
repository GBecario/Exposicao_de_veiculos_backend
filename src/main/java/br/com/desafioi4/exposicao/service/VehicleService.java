package br.com.desafioi4.exposicao.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.desafioi4.exposicao.dto.VehicleDto;
import br.com.desafioi4.exposicao.model.Vehicle;
import br.com.desafioi4.exposicao.repository.VehicleRepository;

@Service
public class VehicleService {

	@Autowired
	private VehicleRepository repository;
	
	@Transactional(readOnly = true)
	public List<VehicleDto> getAllVehicles() {
		return repository.findAll().stream().map(v -> VehicleDto.toDto(v)).toList();
	}
	
	@Transactional
	public VehicleDto registerVehicle(VehicleDto vehicle) {
		Vehicle vehicleEntity = repository.save(vehicle.toEntity());
		return VehicleDto.toDto(vehicleEntity);
	}
}
