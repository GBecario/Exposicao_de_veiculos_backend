package br.com.desafioi4.exposicao.dto;

import br.com.desafioi4.exposicao.config.Mapper;
import br.com.desafioi4.exposicao.model.Vehicle;

public record VehicleDto(
		Long id,
		String title,
		String carName,
		String description) {
		
	public Vehicle toEntity() {
		return Mapper.getMapper().convertValue(this, Vehicle.class);
	}
	
	public static VehicleDto toDto(Vehicle vehicle) {
		return Mapper.getMapper().convertValue(vehicle, VehicleDto.class);
	}
}
