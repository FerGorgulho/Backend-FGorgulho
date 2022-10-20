package com.miPortfolio.FGorgulho.Repository;

import com.miPortfolio.FGorgulho.Entity.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPersonaRepository extends JpaRepository<Persona,Long> {
    
}