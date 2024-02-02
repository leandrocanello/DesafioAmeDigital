package com.Ame.DesafioAmeDigital.Domain.Planet;

import com.Ame.DesafioAmeDigital.dtos.PlanetDTO;
import com.Ame.DesafioAmeDigital.services.PlanetService;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class Planet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String climate;
    private String ground;
    private Integer apparition;

    public Planet(PlanetDTO planet){
        this.name = planet.name();
        this.climate = planet.climate();
        this.ground = planet.ground();
    }
}
