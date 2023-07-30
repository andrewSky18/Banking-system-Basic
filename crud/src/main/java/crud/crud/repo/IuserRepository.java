package crud.crud.repo;
import java.util.Optional;
import crud.crud.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IuserRepository extends JpaRepository<User, Long> {
    Optional<User>  findByEmail(String email);
}