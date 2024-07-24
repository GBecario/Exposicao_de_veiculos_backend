package br.com.desafioi4.exposicao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.desafioi4.exposicao.model.Vehicle;

@Repository
public interface VehicleRepository extends JpaRepository< Vehicle, Long >{

}
