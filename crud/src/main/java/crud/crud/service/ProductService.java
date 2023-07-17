package crud.crud.service;


import crud.crud.domain.*;
import crud.crud.exception.ResourceNotFoundException;
import crud.crud.repo.IproductRepository;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
@AllArgsConstructor
@Validated
public class ProductService {
    final IproductRepository productRepo;

    public List<Product> getAllProduct(){
        if( productRepo.findAll().isEmpty() ){
            throw new ResourceNotFoundException("There are no available products to view");
        }
        return productRepo.findAll();
    }
    public Product getProductById(Long id){
        return productRepo.findById(id).orElseThrow(()->
                new ResourceNotFoundException("There is no available Product with such ID"));
    }
    public Product createProduct(@Valid ProductDTO bridge) {
        Product newProduct=Product.CreateProduct(bridge) ;
        return productRepo.save(newProduct);
    }
    public List<Product> getProductByName(@Valid  String targtName){
        if(productRepo.findAllByName(targtName).isEmpty()){
            throw new ResourceNotFoundException("This Product Name is not available");
        }
       return productRepo.findAllByName(targtName);

    }

    //updateProduct
    public Product updatingProduct(Long id,@Valid ProductDTO updatedProduct) {
        Product product = productRepo.findById(id).orElseThrow(()->
                new ResourceNotFoundException("There is no available Product with such ID"));
        Product productUpdatedValue=Product.updateProduct(updatedProduct,product);
        productRepo.save(productUpdatedValue);
        return product;
    }

    public Product updateProductName(Long id,String name) {
        if(name.isEmpty()){
            throw new ResourceNotFoundException("There is no Name given to use in updating");
        }
        Product product = productRepo.findById(id).orElseThrow(()->
                new ResourceNotFoundException("There is no available Product with such ID"));
        product.setName(name);
        productRepo.save(product);
        return product;
    }

    // done by updateNoRepaymentMin
    public Product updateNoRepaymentMin(Long id,Short num) {
        if(num==null){
            throw new ResourceNotFoundException("There is no Value given to use in updating");
        }
        Product product = productRepo.findById(id).orElseThrow(()->
                new ResourceNotFoundException("There is no available Product with such ID"));
        product.setNoRepaymentMin(num);
        productRepo.save(product);
        return product;
    }
    public Product updateNoRepaymentMax(Long id,Short num) {
        if(num==null){
            throw new ResourceNotFoundException("There is no Value given to use in updating");
        }
        Product product = productRepo.findById(id).orElseThrow(()->
                new ResourceNotFoundException("There is no available Product with such ID"));
        product.setNoRepaymentMax(num);
        productRepo.save(product);
        return product;
    }
    public Product updatePrincipalMin(Long id,Long newPrincipalMin) {
        if(newPrincipalMin==null){
            throw new ResourceNotFoundException("There is no Value given to use in updating");
        }
        Product product = productRepo.findById(id).orElseThrow(()->
                new ResourceNotFoundException("There is no available Product with such ID"));
        product.setPrincipalMin(newPrincipalMin);
        productRepo.save(product);
        return product;
    }
    public Product updatePrincipalMax(Long id,Long newPrincipalMin) {
        if(newPrincipalMin==null){
            throw new ResourceNotFoundException("There is no Value given to use in updating");
        }
        Product product = productRepo.findById(id).orElseThrow(()->
                new ResourceNotFoundException("There is no available Product with such ID"));
        product.setPrincipalMax(newPrincipalMin);
        productRepo.save(product);
        return product;
    }
    public Product updateCommission(Long id,Long newCommission) {
        if(newCommission==null){
            throw new ResourceNotFoundException("There is no Value given to use in updating");
        }
        Product product = productRepo.findById(id).orElseThrow(()->
                new ResourceNotFoundException("There is no available Product with such ID"));
        product.setCommission(newCommission);
        productRepo.save(product);
        return product;
    }
    public Product updateFees(Long id,Long newFees) {
        if(newFees==null){
            throw new ResourceNotFoundException("There is no Value given to use in updating");
        }
        Product product = productRepo.findById(id).orElseThrow(()->
                new ResourceNotFoundException("There is no available Product with such ID"));
        product.setFees(newFees);
        productRepo.save(product);
        return product;
    }
    public String deleteProduct(Long id){
        Product product=productRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("There is no available product with such ID"));
        productRepo.deleteById(id);
        String st="The Product was Successfully deleted.";

        return st;

    }
}