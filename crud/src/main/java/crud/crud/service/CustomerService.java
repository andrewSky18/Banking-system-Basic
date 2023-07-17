package crud.crud.service;

import crud.crud.domain.Customer;
import crud.crud.domain.CustomerDTO;
import crud.crud.domain.Facility;
import crud.crud.exception.ResourceNotFoundException;
import crud.crud.repo.IcustomerRepository;
import crud.crud.repo.IfacilityRepository;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;

@Service
@AllArgsConstructor
@Validated
public class CustomerService {

    final IcustomerRepository customerRepo;
    final IfacilityRepository ifacilityRepository;
    public List<Customer>  getAllCustomer(){
        if(customerRepo.findAll().isEmpty()){
            throw new ResourceNotFoundException("There are no available products to view");
        }
        return customerRepo.findAll();
    }

    public Customer findCustomerById(Long id){
        return customerRepo.findById(id).orElseThrow(()->
                new ResourceNotFoundException("There is no available Customer with such ID"));
    }

    public Customer createCustomer(@Valid CustomerDTO bridge) {
        Facility facility= ifacilityRepository.findById(bridge.getFacilityId()).orElseThrow(()->
                new ResourceNotFoundException("No available facility with such ID"));
        Customer newCustomer=Customer.CreateCustomer(bridge,facility) ;
        return customerRepo.save(newCustomer);
    }

    public List<Customer> getCustomerByName(String targtName){
        if(customerRepo.findAllByName(targtName).isEmpty()){
            throw new ResourceNotFoundException("This name is not available ");
        }
        return customerRepo.findAllByName(targtName);
    }

    public Customer updateCustomer(Long id, CustomerDTO UpdatedCustomer) {
        Customer customer = customerRepo.findById(id).orElseThrow(()->
                new ResourceNotFoundException("There is no available Customer with such ID"));
        Customer customerUpdatedValue=Customer.updateCustomer(UpdatedCustomer,customer);
        customerRepo.save(customerUpdatedValue);
        return customer;
    }


    public Customer updateCustomerAge(Long id, Short newAge) {
        Customer customer = customerRepo.findById(id).orElseThrow(()->
                new ResourceNotFoundException("There is no available Customer with such ID"));
        customer.setAge(newAge);
        customerRepo.save(customer);
        return customer;
    }

    public void deleteCustomer(Long id){
        customerRepo.deleteById(id);
        System.out.println("Customer deleted successfully");
    }

}
