package com.miPortfolio.FGorgulho.Service;

import com.miPortfolio.FGorgulho.Entity.AboutMe;
import com.miPortfolio.FGorgulho.Repository.IAboutMeRepository;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
@Transactional
public class ImpAboutMeService {
     @Autowired
     IAboutMeRepository iAboutMeRepository;
          
     public List<AboutMe> list(){
         return iAboutMeRepository.findAll();
     }
     
     public Optional<AboutMe> getOne(int id){
         return iAboutMeRepository.findById(id);
     }
     
     public Optional<AboutMe> getByNombreA(String nombreA){
         return iAboutMeRepository.findByNombreA(nombreA);
     }
     
     public void save(AboutMe about){
         iAboutMeRepository.save(about);
     }
     
     public void delete(int id){
         iAboutMeRepository.deleteById(id);
     }
     
     public boolean existsById(int id){
         return iAboutMeRepository.existsById(id);
     }
     
     public boolean existsByNombreA(String nombreA){
         return iAboutMeRepository.existsByNombreA(nombreA);
     }
}

