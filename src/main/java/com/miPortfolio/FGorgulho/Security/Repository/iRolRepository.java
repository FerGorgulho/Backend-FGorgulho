package com.miPortfolio.FGorgulho.Security.Repository;

import com.miPortfolio.FGorgulho.Security.Entity.Rol;
import com.miPortfolio.FGorgulho.Security.Enums.RolNombre;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface iRolRepository extends JpaRepository<Rol, Integer>{
    Optional<Rol> findByRolNombre(RolNombre rolNombre);
}