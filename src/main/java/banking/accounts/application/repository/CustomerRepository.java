package banking.accounts.application.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import banking.accounts.application.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

}
