package ch.keepcalm.web.ops.repository;

import ch.keepcalm.web.ops.domain.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

	List<Customer> findByName(String name);

}
