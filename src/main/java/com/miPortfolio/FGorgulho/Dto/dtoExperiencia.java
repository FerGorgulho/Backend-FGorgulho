package com.miPortfolio.FGorgulho.Dto;

import javax.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class dtoExperiencia {
    
    @NotBlank
    private String nombreE;
    @NotBlank
    private String dondeE;
    @NotBlank
    private String periodoE;
    @NotBlank
    private String descripcionE;
    @NotBlank
    private String logoE;

    public dtoExperiencia() {
    }

    public dtoExperiencia(String dondeE, String periodoE, String descripcionE, String logoE) {
        this.dondeE = dondeE;
        this.periodoE = periodoE;
        this.descripcionE = descripcionE;
        this.logoE = logoE;
    }
    
    
    
}