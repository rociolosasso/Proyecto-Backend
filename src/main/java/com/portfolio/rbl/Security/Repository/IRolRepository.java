
package com.portfolio.rbl.Security.Repository;

import com.portfolio.rbl.Security.Entity.Rol;
import com.portfolio.rbl.Security.Enums.RolNombre;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRolRepository extends JpaRepository<Rol, Integer> {
    Optional<Rol> findByRolNombre(RolNombre rolNombre);
}
