package crud.crud.controller;

import crud.crud.domain.CustomerDTO;
import crud.crud.domain.OfficeDTO;
import crud.crud.domain.Product;
import crud.crud.domain.ProductDTO;
import crud.crud.service.ProductService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Validated
public class ProductController {

    private final ProductService productService;

    //Done retrieve all
    @GetMapping("/viewProductList")
    public List<Product> viewProductList() {
        List<Product> products= this.productService.getAllProduct();
        return products;
    }

    @GetMapping("/viewproductById/{id}")
    public Product viewproductByid(@PathVariable("id") Long id) {
        return productService.getProductById(id);
    }

    @GetMapping("/viewProductByName/{targtName}")
    public List<Product> viewProductByName(@PathVariable("targtName") String targtName) {
        return productService.getProductByName(targtName);
    }

    @PostMapping("/addProduct")
    public String addProduct(@Valid @RequestBody ProductDTO product) {
        String st= "Added successfully";
        productService.createProduct(product);
        return st;
    }

    @DeleteMapping("/deleteProduct")
    public String deleteProduct(@RequestParam Long id) {
        String st= "The product is Deleted Successfully";
        productService.deleteProduct(id);
        return st;
    }
    @PutMapping("/updateProduct")
    public void updateProduct(@Valid @RequestBody ProductDTO productDTO, @RequestParam Long id){
        productService.updatingProduct(id,productDTO);
    }

    @PatchMapping("/updateProductName")
    public void updateProductName(@RequestParam String name, @RequestParam Long id){

        productService.updateProductName(id,name);
    }

    @PatchMapping("/updateNoRepaymentMin")
    public void updateNoRepaymentMin(@RequestParam Short newNoRepaymentMin, @RequestParam Long id){
        productService.updateNoRepaymentMin(id,newNoRepaymentMin);
    }

    @PatchMapping("/updateNoRepaymentMax")
    public void updateNoRepaymentMax(@RequestParam Short newNoRepaymentMax, @RequestParam Long id){
        productService.updateNoRepaymentMax(id,newNoRepaymentMax);
    }

    @PatchMapping("/updatePrincipalMin")
    public void updatePrincipalMin(@RequestParam Long newPrincipalMin, @RequestParam Long id){
        productService.updatePrincipalMin(id,newPrincipalMin);
    }

    @PatchMapping("/updatePrincipalMax")
    public void updatePrincipalMax(@RequestParam Long newPrincipalMax, @RequestParam Long id){
        productService.updatePrincipalMax(id,newPrincipalMax);
    }

    @PatchMapping("/updateCommission")
    public void updateCommission(@RequestParam Long newCommission, @RequestParam Long id){
        productService.updateCommission(id,newCommission);
    }

    @PatchMapping("/updateFees")
    public void updateFees(@RequestParam Long newFees, @RequestParam Long id){
        productService.updateFees(id,newFees);
    }



}
