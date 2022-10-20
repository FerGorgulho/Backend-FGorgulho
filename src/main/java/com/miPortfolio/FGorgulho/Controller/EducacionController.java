package com.miPortfolio.FGorgulho.Controller;

import com.miPortfolio.FGorgulho.Dto.dtoEducacion;
import com.miPortfolio.FGorgulho.Entity.Educacion;
import com.miPortfolio.FGorgulho.Security.Controller.Mensaje;
import com.miPortfolio.FGorgulho.Service.ImpEducacionService;
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
@RequestMapping("/educacion")
@CrossOrigin(origins = "https://frontedfg.web.app")
public class EducacionController {
    @Autowired
    ImpEducacionService impEducacionService;
    
        @GetMapping("/lista")
    public ResponseEntity<List<Educacion>> list(){
        List<Educacion> list = impEducacionService.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
    @GetMapping("/detail/{id}")
    public ResponseEntity<Educacion> getById(@PathVariable("id") int id){
        if(!impEducacionService.existsById(id))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        Educacion educacion = impEducacionService.getOne(id).get();
        return new ResponseEntity(educacion, HttpStatus.OK);
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        if (!impEducacionService.existsById(id)) {
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        }
        impEducacionService.delete(id);
        return new ResponseEntity(new Mensaje("educacion eliminada"), HttpStatus.OK);
    }

    
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody dtoEducacion dtoeduc){      
        if(StringUtils.isBlank(dtoeduc.getNombreEc()))
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        if(impEducacionService.existsByNombreE(dtoeduc.getNombreEc())) //********************************************************
             return new ResponseEntity(new Mensaje("Esa educación existe"), HttpStatus.BAD_REQUEST);
        
       Educacion educacion = new Educacion(
                dtoeduc.getNombreEc(), 
                dtoeduc.getInstitucionEc(), 
                dtoeduc.getPeriodoEc(),
                dtoeduc.getDescripcionEc(), 
                dtoeduc.getLogoEc());
        impEducacionService.save(educacion);
        
        return new ResponseEntity(new Mensaje("Educacion agregada"), HttpStatus.OK);
    }
    
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody dtoEducacion dtoeduc){
        //Validamos si existe el ID
        if(!impEducacionService.existsById(id))
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.BAD_REQUEST);
        //Compara nombre de experiencias
        if(impEducacionService.existsByNombreE(dtoeduc.getNombreEc()) && impEducacionService.getByNombreEc(dtoeduc.getNombreEc()).get().getId() != id)    //********************************************************
            return new ResponseEntity(new Mensaje("Esa Educacion ya existe"), HttpStatus.BAD_REQUEST);
        //No puede estar vacio
        if(StringUtils.isBlank(dtoeduc.getNombreEc()))
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        
        Educacion educacion = impEducacionService.getOne(id).get();
        educacion.setNombreEc(dtoeduc.getNombreEc());
        educacion.setInstitucionEc((dtoeduc.getInstitucionEc()));
        educacion.setPeriodoEc((dtoeduc.getPeriodoEc()));
        educacion.setDescripcionEc((dtoeduc.getDescripcionEc()));
        educacion.setLogoEc((dtoeduc.getLogoEc()));
        
        impEducacionService.save(educacion);
        return new ResponseEntity(new Mensaje("Educacion actualizada"), HttpStatus.OK);
             
    }
}