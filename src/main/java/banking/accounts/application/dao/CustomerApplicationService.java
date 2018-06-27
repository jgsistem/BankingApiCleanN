package banking.accounts.application.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import banking.accounts.application.model.Customer;
import banking.accounts.application.repository.CustomerRepository;

@Service
public class CustomerApplicationService {
    
	@Autowired
	CustomerRepository customerRepository;
	
	public Customer save(Customer customer) {
		return customerRepository.save(customer);
	}
		
	
	public List<Customer> findAll(){
		return customerRepository.findAll();
	}
	
	
	public Customer findOne(Long empid) {
		return customerRepository.findOne(empid);
	}
	
	
	public void delete(Customer customer) {
		customerRepository.delete(customer);
	}
	
}
