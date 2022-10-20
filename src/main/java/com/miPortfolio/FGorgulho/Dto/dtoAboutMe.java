package com.miPortfolio.FGorgulho.Dto;

import javax.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class dtoAboutMe {
    
    @NotBlank
    private String nombreA;
    @NotBlank
    private String descripcionA;
    @NotBlank
    private String imgA;

    public dtoAboutMe() {
    }

    public dtoAboutMe(String nombreA, String descripcionA, String imgA) {
        this.nombreA = nombreA;
        this.descripcionA = descripcionA;
        this.imgA = imgA;
    }
 
    
}
