package crud.crud.repo;

import crud.crud.domain.Office;
import crud.crud.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface IproductRepository extends JpaRepository<Product, Long> {

    List<Product> findAllByName(String name);


}
