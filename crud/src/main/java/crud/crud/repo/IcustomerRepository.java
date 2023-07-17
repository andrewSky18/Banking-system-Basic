package crud.crud.repo;

import crud.crud.domain.Customer;
import crud.crud.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IcustomerRepository extends JpaRepository<Customer, Long> {
    List<Customer> findAllByName(String name);
}
