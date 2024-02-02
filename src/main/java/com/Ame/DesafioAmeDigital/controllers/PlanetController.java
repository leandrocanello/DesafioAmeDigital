package com.Ame.DesafioAmeDigital.controllers;

import com.Ame.DesafioAmeDigital.Domain.Planet.Planet;
import com.Ame.DesafioAmeDigital.dtos.PlanetDTO;
import com.Ame.DesafioAmeDigital.repositories.TransactionPlanet;
import com.Ame.DesafioAmeDigital.services.PlanetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(name = "/planet")
public class PlanetController {
    @Autowired
    TransactionPlanet transactionPlanet;
    @Autowired
    PlanetService planetService;

    @PostMapping("/planet")
    public ResponseEntity<Planet> createPlanet(@RequestBody PlanetDTO planet){
        Planet newplanet = new Planet(planet);
        newplanet.setApparition(planetService.qtdApparition(planet.name()));
        transactionPlanet.save(newplanet);
        return new ResponseEntity<>(newplanet, HttpStatus.CREATED);
    }

    @GetMapping("/planet")
    public ResponseEntity<List<Planet>> listPlanet(){
        List<Planet> planets = transactionPlanet.findAll();
        return new ResponseEntity<>(planets, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Planet> listPlanetById(@PathVariable("id") Long id) throws Exception {
        Optional<Planet> planet = transactionPlanet.findById(id);
        if(!planet.isPresent()){
            throw new Exception("planet no found");
        }
        return new ResponseEntity<>(planet.get(), HttpStatus.OK);
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<Planet> listPlanetByName(@PathVariable("name") String name) throws Exception {
        Optional<Planet> planet = transactionPlanet.findByName(name);
        if(!planet.isPresent()){
            throw new Exception("planet no found");
        }
        return new ResponseEntity<>(planet.get(), HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteTodo(@PathVariable("id") Long id) throws Exception {
        Optional<Planet> planet = transactionPlanet.findById(id);
        if(!planet.isPresent())
            throw new Exception("Informa um id");
        transactionPlanet.delete(planet.get());
        return ResponseEntity.ok("Todo deleted successfully!.");
    }
}
