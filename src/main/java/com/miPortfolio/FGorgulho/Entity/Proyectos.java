package com.miPortfolio.FGorgulho.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity

public class Proyectos {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nombreP;
    private String periodoP;
    private String descripcionP;
    private String projImaP;
    private String projLinkP;

    public Proyectos() {
    }

    public Proyectos(String nombreP, String periodoP, String descripcionP, String projImaP, String projLinkP) {
        this.nombreP = nombreP;
        this.periodoP = periodoP;
        this.descripcionP = descripcionP;
        this.projImaP = projImaP;
        this.projLinkP = projLinkP;
    }

 


    
    
}
