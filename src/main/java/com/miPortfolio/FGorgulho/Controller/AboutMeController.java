package com.miPortfolio.FGorgulho.Controller;

import com.miPortfolio.FGorgulho.Dto.dtoAboutMe;
import com.miPortfolio.FGorgulho.Entity.AboutMe;
import com.miPortfolio.FGorgulho.Security.Controller.Mensaje;
import com.miPortfolio.FGorgulho.Service.ImpAboutMeService;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/about")
@CrossOrigin(origins = "https://frontedfg.web.app")
public class AboutMeController {
    @Autowired
    ImpAboutMeService impAboutMeService;
    
    
    @GetMapping("/lista")
    public ResponseEntity<List<AboutMe>> list(){
        List<AboutMe> list = impAboutMeService.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
    @GetMapping("/detail/{id}")
    public ResponseEntity<AboutMe> getById(@PathVariable("id") int id){
        if(!impAboutMeService.existsById(id))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        AboutMe aboutMe = impAboutMeService.getOne(id).get();
        return new ResponseEntity(aboutMe, HttpStatus.OK);
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        if (!impAboutMeService.existsById(id)) {
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        }
        impAboutMeService.delete(id);
        return new ResponseEntity(new Mensaje("descripcion eliminada"), HttpStatus.OK);
    }

    
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody dtoAboutMe dtoabout){      
        if(StringUtils.isBlank(dtoabout.getNombreA()))
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        if(impAboutMeService.existsByNombreA(dtoabout.getNombreA()))
            return new ResponseEntity(new Mensaje("Esa descripción existe"), HttpStatus.BAD_REQUEST);
        
        AboutMe aboutMe = new AboutMe(
                dtoabout.getNombreA(), 
                dtoabout.getDescripcionA(), 
                dtoabout.getImgA());
        impAboutMeService.save(aboutMe);
        
        return new ResponseEntity(new Mensaje("Descripción agregada"), HttpStatus.OK);
    }
    
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody dtoAboutMe dtoabout){
        //Validamos si existe el ID
        if(!impAboutMeService.existsById(id))
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.BAD_REQUEST);
        //Compara nombre de experiencias
        if(impAboutMeService.existsByNombreA(dtoabout.getNombreA()) && impAboutMeService.getByNombreA(dtoabout.getNombreA()).get().getId() != id)
            return new ResponseEntity(new Mensaje("Esa descripción ya existe"), HttpStatus.BAD_REQUEST);
        //No puede estar vacio
        if(StringUtils.isBlank(dtoabout.getNombreA()))
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        
        AboutMe aboutMe = impAboutMeService.getOne(id).get();
        aboutMe.setNombreA(dtoabout.getNombreA());
        aboutMe.setDescripcionA((dtoabout.getDescripcionA()));
        aboutMe.setImgA((dtoabout.getImgA()));
                
        impAboutMeService.save(aboutMe);
        return new ResponseEntity(new Mensaje("Experiencia actualizada"), HttpStatus.OK);
             
    }
}
