package br.com.desafioi4.exposicao.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.desafioi4.exposicao.dto.ExhibitionDto;
import br.com.desafioi4.exposicao.model.Exhibition;
import br.com.desafioi4.exposicao.repository.ExhibitionRepository;

@Service
public class ExhibitionService {

	@Autowired
	private ExhibitionRepository repository;
	
	@Transactional(readOnly = true)
	public Page<ExhibitionDto> getAllExhibition(Pageable pageable) {
		return repository.findAll(pageable).map(e -> ExhibitionDto.toDto(e));
	}
	
	@Transactional
	public ExhibitionDto registerExhibition(ExhibitionDto exhibition) {
		Exhibition exhibitionEntity = repository.save(exhibition.toEntity());
		return ExhibitionDto.toDto(exhibitionEntity);
	}
}
