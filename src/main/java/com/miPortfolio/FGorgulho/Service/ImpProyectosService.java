package com.miPortfolio.FGorgulho.Service;

import com.miPortfolio.FGorgulho.Entity.Proyectos;
import com.miPortfolio.FGorgulho.Repository.IProyectosRepository;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
@Transactional
public class ImpProyectosService {
     @Autowired
     IProyectosRepository iProyectosRepository;
          
     public List<Proyectos> list(){
         return iProyectosRepository.findAll();
     }
     
     public Optional<Proyectos> getOne(int id){
         return iProyectosRepository.findById(id);
     }
     
     public Optional<Proyectos> getByNombreP(String nombreP){
         return iProyectosRepository.findByNombreP(nombreP);
     }
     
     public void save(Proyectos proj){
         iProyectosRepository.save(proj);
     }
     
     public void delete(int id){
         iProyectosRepository.deleteById(id);
     }
     
     public boolean existsById(int id){
         return iProyectosRepository.existsById(id);
     }
     
     public boolean existsByNombreP(String nombreP){
         return iProyectosRepository.existsByNombreP(nombreP);
     }
}

