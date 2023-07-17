package crud.crud.controller;


import crud.crud.domain.CustomerDTO;
import crud.crud.domain.Loan;
import crud.crud.domain.LoanDTO;
import crud.crud.exception.ResourceNotFoundException;
import crud.crud.service.LoanService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class LoanController {
    private final LoanService loanService;

    @GetMapping("/viewAllLoans")
    public List<Loan> viewAllLoans() {
        List<Loan> loans= this.loanService.getAllLoan();
        if (loans.isEmpty()){
            throw new ResourceNotFoundException("No Loans Available to View");
        }
        return loans;
    }

    @GetMapping("/viewLoanById/{id}")
    public Loan viewLoanById(@PathVariable("id") Long id) {
        Loan loan= this.loanService.getLoanById(id);
        if (loan==null){
            throw new ResourceNotFoundException("No loan available to View with such ID");
        }
        return loan;
    }

    @PostMapping("/addLoan")
    public Loan addLoan(@Valid @RequestBody LoanDTO loanDTO) {
       return loanService.createLoan(loanDTO);
    }

    @DeleteMapping("/deleteLoan")
    public void deleteLoan(@RequestParam Long id) {
        loanService.deleteLoan(id);

    }

    @PutMapping("/updateLoanAmount")
    public void updateLoanAmount(@RequestBody LoanDTO loanDTO, @RequestParam Long id){
        loanService.updateLoanAmount(id,loanDTO);
    }

    @PutMapping("/updateNoOfRepayment")
    public void updateNoOfRepayment(@RequestBody LoanDTO loanDTO, @RequestParam Long id){
        loanService.updateLoanNoOfRepayment(id,loanDTO);
    }



}
