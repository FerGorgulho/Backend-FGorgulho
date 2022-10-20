package com.miPortfolio.FGorgulho.Dto;

import javax.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class dtoProyectos {
    
    @NotBlank
    private String nombreP;
    @NotBlank
    private String periodoP;
    @NotBlank
    private String descripcionP;
    @NotBlank
    private String projImaP;
    @NotBlank
    private String projLinkP;

    public dtoProyectos() {
    }

    public dtoProyectos(String nombreP, String periodoP, String descripcionP, String projImaP, String projLinkP) {
        this.nombreP = nombreP;
        this.periodoP = periodoP;
        this.descripcionP = descripcionP;
        this.projImaP = projImaP;
        this.projLinkP = projLinkP;
    }
    
    
    
}