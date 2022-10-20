package com.miPortfolio.FGorgulho.Dto;

import javax.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class dtoEducacion {
    
    @NotBlank
    private String nombreEc;
    @NotBlank
    private String institucionEc;
    @NotBlank
    private String periodoEc;
    @NotBlank
    private String descripcionEc;
    @NotBlank
    private String logoEc;

    public dtoEducacion() {
    }

    public dtoEducacion(String nombreEc, String institucionEc, String periodoEc, String descripcionEc, String logoEc) {
        this.nombreEc = nombreEc;
        this.institucionEc = institucionEc;
        this.periodoEc = periodoEc;
        this.descripcionEc = descripcionEc;
        this.logoEc = logoEc;
    }
    
}
