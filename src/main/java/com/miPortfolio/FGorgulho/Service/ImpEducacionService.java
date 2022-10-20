package com.miPortfolio.FGorgulho.Service;

import com.miPortfolio.FGorgulho.Entity.Educacion;
import com.miPortfolio.FGorgulho.Repository.IEducationRepository;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
@Transactional
public class ImpEducacionService {
     @Autowired
     IEducationRepository iEducacionRepository;
          
     public List<Educacion> list(){
         return iEducacionRepository.findAll();
     }
     
     public Optional<Educacion> getOne(int id){
         return iEducacionRepository.findById(id);
     }
     
     public Optional<Educacion> getByNombreEc(String nombreEc){
         return iEducacionRepository.findByNombreEc(nombreEc);
     }
     
     public void save(Educacion educ){
         iEducacionRepository.save(educ);
     }
     
     public void delete(int id){
         iEducacionRepository.deleteById(id);
     }
     
     public boolean existsById(int id){
         return iEducacionRepository.existsById(id);
     }
     
     public boolean existsByNombreE(String nombreEc){
         return iEducacionRepository.existsByNombreEc(nombreEc);
     }
}
