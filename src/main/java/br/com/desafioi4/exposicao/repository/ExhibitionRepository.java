package br.com.desafioi4.exposicao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.desafioi4.exposicao.model.Exhibition;

@Repository
public interface ExhibitionRepository extends JpaRepository< Exhibition, Long >{

}
