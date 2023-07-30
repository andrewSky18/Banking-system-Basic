package crud.crud.repo;


import java.util.Optional;

import crud.crud.domain.ERole;
import crud.crud.domain.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface IroleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(ERole name);
}