package br.com.desafioi4.exposicao.dto;

import br.com.desafioi4.exposicao.config.Mapper;
import br.com.desafioi4.exposicao.model.Exhibition;

public record ExhibitionDto(
		Long id,
		String title,
		String vehicle,
		String description) {
		
	public Exhibition toEntity() {
		return Mapper.getMapper().convertValue(this, Exhibition.class);
	}
	
	public static ExhibitionDto toDto(Exhibition vehicle) {
		return Mapper.getMapper().convertValue(vehicle, ExhibitionDto.class);
	}
}
