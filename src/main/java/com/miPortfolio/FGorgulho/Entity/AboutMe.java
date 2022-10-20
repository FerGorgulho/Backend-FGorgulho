package com.miPortfolio.FGorgulho.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class AboutMe {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nombreA;
    private String descripcionA;
    private String imgA;

    public AboutMe() {
    }

    public AboutMe(String nombreA, String descripcionA, String imgA) {
        this.nombreA = nombreA;
        this.descripcionA = descripcionA;
        this.imgA = imgA;
    }
   
}

