package com.miPortfolio.FGorgulho.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class Experiencia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nombreE;
    private String dondeE;
    private String periodoE;
    private String descripcionE;
    private String logoE;

    public Experiencia() {
    }

    public Experiencia(String nombreE, String dondeE, String periodoE, String descripcionE, String logoE) {
        this.nombreE = nombreE;
        this.dondeE = dondeE;
        this.periodoE = periodoE;
        this.descripcionE = descripcionE;
        this.logoE = logoE;
    }


}
    


    
