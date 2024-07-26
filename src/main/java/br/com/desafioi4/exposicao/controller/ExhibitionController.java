package br.com.desafioi4.exposicao.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.desafioi4.exposicao.dto.ExhibitionDto;
import br.com.desafioi4.exposicao.service.ExhibitionService;
import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/exhibition")
public class ExhibitionController {
	
	@Autowired
	private ExhibitionService service;
	
	@GetMapping
	@Operation(summary = "Buscar exposições", description = "Buscar todas as exposições")
	public ResponseEntity<Page<ExhibitionDto>> getAllExhibition(
			@PageableDefault(size = 5, page = 0, sort = "title", direction = Sort.Direction.ASC) Pageable pageable) {
		return ResponseEntity.ok(service.getAllExhibition(pageable));
	}
	
	@Operation(summary = "Cadastrar exposição", description = "Cadastrar uma exposição")
	@PostMapping
	public ResponseEntity<ExhibitionDto> registerExhibition(@RequestBody ExhibitionDto exhibition) {
		return ResponseEntity.ok(service.registerExhibition(exhibition));
	}
}
