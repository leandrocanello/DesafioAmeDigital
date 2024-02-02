package com.Ame.DesafioAmeDigital.repositories;

import com.Ame.DesafioAmeDigital.Domain.Planet.Planet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

public interface TransactionPlanet extends JpaRepository<Planet, Long> {
    Optional<Planet> findByName(String name);
}
