package crud.crud.controller;

import java.util.List;
import crud.crud.domain.Customer;
import crud.crud.domain.CustomerDTO;

import crud.crud.domain.ProductDTO;
import crud.crud.exception.GlobalCustomException;
import crud.crud.exception.ResourceNotFoundException;
import crud.crud.service.CustomerService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@Validated
public class CustomerController {
    private final CustomerService customerService;

    @GetMapping("/viewAllCustomer")
    public List<Customer> viewAllCustomer() {
        List<Customer> customer= this.customerService.getAllCustomer();
        return customer;
    }

    @GetMapping("/viewCustomerById/{id}")
    public Customer viewCustomerById(@PathVariable("id") Long id) {
        if (customerService.findCustomerById(id) == null) {
            throw new ResourceNotFoundException("Customer with id " + id + " not found");
        }

        return customerService.findCustomerById(id);
    }

    @GetMapping("/viewCustomerByName/{targtName}")
    public List<Customer> viewCustomerByName(@PathVariable("targtName") String targtName) {
        return customerService.getCustomerByName(targtName);
    }

    @PostMapping("/addCustomer")
    public void addCustomer(@Valid @RequestBody CustomerDTO customer) {

        customerService.createCustomer(customer);
    }


    @DeleteMapping("/deleteCustomer")
    public void deleteCustomer(@RequestParam Long id) {
        customerService.deleteCustomer(id);

    }

    @PutMapping("/updateCustomer")
    public void updateCustomerName(@Valid @RequestBody CustomerDTO customerName, @RequestParam Long id){
        customerService.updateCustomer(id,customerName);
    }

    @PatchMapping("/updateCustomerAge")
    public void updateCustomerAge(@RequestParam Short customerAge, @RequestParam Long id){
        if(customerAge<18){
            throw new GlobalCustomException("This Age is illegal ");
        }
        customerService.updateCustomerAge(id,customerAge);
    }
}
