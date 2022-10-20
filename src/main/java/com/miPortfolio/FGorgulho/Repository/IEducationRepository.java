package com.miPortfolio.FGorgulho.Repository;

import com.miPortfolio.FGorgulho.Entity.Educacion;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface IEducationRepository extends JpaRepository<Educacion, Integer>{
    public Optional<Educacion> findByNombreEc(String nombreEc);
    public boolean existsByNombreEc(String nombreEc);
}
