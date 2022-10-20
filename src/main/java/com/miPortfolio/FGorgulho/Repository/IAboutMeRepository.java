package com.miPortfolio.FGorgulho.Repository;

import com.miPortfolio.FGorgulho.Entity.AboutMe;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAboutMeRepository extends JpaRepository<AboutMe, Integer>{
    public Optional<AboutMe> findByNombreA(String nombreA);
    public boolean existsByNombreA(String nombreA);
}
