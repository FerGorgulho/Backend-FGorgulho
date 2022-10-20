package com.miPortfolio.FGorgulho.Controller;

import com.miPortfolio.FGorgulho.Dto.dtoProyectos;
import com.miPortfolio.FGorgulho.Entity.Proyectos;
import com.miPortfolio.FGorgulho.Security.Controller.Mensaje;
import com.miPortfolio.FGorgulho.Service.ImpProyectosService;
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
@RequestMapping("/proyectos")
@CrossOrigin(origins = "https://frontedfg.web.app")
public class ProyectosController  {
    @Autowired
    ImpProyectosService impProyectosService;
    
    @GetMapping("/lista")
    public ResponseEntity<List<Proyectos>> list(){
        List<Proyectos> list = impProyectosService.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
    @GetMapping("/detail/{id}")
    public ResponseEntity<Proyectos> getById(@PathVariable("id") int id){
        if(!impProyectosService.existsById(id))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        Proyectos proyectos = impProyectosService.getOne(id).get();
        return new ResponseEntity(proyectos, HttpStatus.OK);
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        if (!impProyectosService.existsById(id)) {
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        }
        impProyectosService.delete(id);
        return new ResponseEntity(new Mensaje("proyecto eliminado"), HttpStatus.OK);
    }

    
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody dtoProyectos dtoproj){      
        if(StringUtils.isBlank(dtoproj.getNombreP()))
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        if(impProyectosService.existsByNombreP(dtoproj.getNombreP()))
            return new ResponseEntity(new Mensaje("Ese proyecto existe"), HttpStatus.BAD_REQUEST);
        
        Proyectos proyectos = new Proyectos(
                dtoproj.getNombreP(), 
                dtoproj.getPeriodoP(),
                dtoproj.getDescripcionP(), 
                dtoproj.getProjImaP(),
                dtoproj.getProjLinkP());
        impProyectosService.save(proyectos);
        
        return new ResponseEntity(new Mensaje("Proyecto agregado"), HttpStatus.OK);
    }
    
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody dtoProyectos dtoproj){
        //Validamos si existe el ID
        if(!impProyectosService.existsById(id))
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.BAD_REQUEST);
        //Compara nombre de experiencias
        if(impProyectosService.existsByNombreP(dtoproj.getNombreP()) && impProyectosService.getByNombreP(dtoproj.getNombreP()).get().getId() != id)
            return new ResponseEntity(new Mensaje("Ese proyecto ya existe"), HttpStatus.BAD_REQUEST);
        //No puede estar vacio
        if(StringUtils.isBlank(dtoproj.getNombreP()))
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        
        Proyectos proyectos = impProyectosService.getOne(id).get();
        proyectos.setNombreP(dtoproj.getNombreP());
        proyectos.setPeriodoP((dtoproj.getPeriodoP()));
        proyectos.setDescripcionP((dtoproj.getDescripcionP()));
         proyectos.setProjImaP((dtoproj.getProjImaP()));
        proyectos.setProjLinkP((dtoproj.getProjLinkP()));
        
        impProyectosService.save(proyectos);
        return new ResponseEntity(new Mensaje("Proyecto actualizada"), HttpStatus.OK);
             
    }
}

