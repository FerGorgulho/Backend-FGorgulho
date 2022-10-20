package com.miPortfolio.FGorgulho.Service;

import com.miPortfolio.FGorgulho.Entity.Experiencia;
import com.miPortfolio.FGorgulho.Repository.IExperienciaRepository;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
@Transactional
public class ImpExperienciaService {
     @Autowired
     IExperienciaRepository iExperienciaRepository;
          
     public List<Experiencia> list(){
         return iExperienciaRepository.findAll();
     }
     
     public Optional<Experiencia> getOne(int id){
         return iExperienciaRepository.findById(id);
     }
     
     public Optional<Experiencia> getByNombreE(String nombreE){
         return iExperienciaRepository.findByNombreE(nombreE);
     }
     
     public void save(Experiencia expe){
         iExperienciaRepository.save(expe);
     }
     
     public void delete(int id){
         iExperienciaRepository.deleteById(id);
     }
     
     public boolean existsById(int id){
         return iExperienciaRepository.existsById(id);
     }
     
     public boolean existsByNombreE(String nombreE){
         return iExperienciaRepository.existsByNombreE(nombreE);
     }
}