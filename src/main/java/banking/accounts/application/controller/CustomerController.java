package banking.accounts.application.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import banking.accounts.application.dao.CustomerApplicationService;
import banking.accounts.application.model.Customer;

@RestController
@RequestMapping("api/customers/")
public class CustomerController {
	@Autowired
	CustomerApplicationService customerApplicationService;	
	
	@PostMapping("/create")
	public Customer createEmployee(@Valid @RequestBody Customer customer) {
		return customerApplicationService.save(customer);
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/getcustomer")
	public List<Customer> getAllCustomer(){
		return customerApplicationService.findAll();
	}	
	
	@GetMapping("/customerget/{id}")
	public ResponseEntity<Customer> getEmployeeById(@PathVariable(value="id") Long customerid){
		
		Customer customer=customerApplicationService.findOne(customerid);
		
		if(customer==null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().body(customer);
		
	}
	
	
	@PutMapping("/customerup/{id}")
	public ResponseEntity<Customer> updateCustomer(@PathVariable(value="id") Long empid,@Valid @RequestBody Customer customerDAOx){
		
		Customer customer=customerApplicationService.findOne(empid);
		if(customerDAOx==null) {
			return ResponseEntity.notFound().build();
		}		
		customerDAOx.setFirstName(customerDAOx.getFirstName());
		customerDAOx.setLastName(customerDAOx.getLastName());
		
		Customer updateEmployee=customerApplicationService.save(customer);
		return ResponseEntity.ok().body(updateEmployee);
		
	}	
	
	@DeleteMapping("/customerdel/{id}")
	public ResponseEntity<Customer> deleteEmployee(@PathVariable(value="id") Long empid){
		
		Customer customer=customerApplicationService.findOne(empid);
		if(customer==null) {
			return ResponseEntity.notFound().build();
		}
		customerApplicationService.delete(customer);
		
		return ResponseEntity.ok().build();			
	}	
}
