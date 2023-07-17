package crud.crud.service;

import crud.crud.domain.*;
import crud.crud.exception.ResourceNotFoundException;
import crud.crud.repo.IcustomerRepository;
import crud.crud.repo.IloanRepository;
import crud.crud.repo.IofficeRepository;
import crud.crud.repo.IproductRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


@Service
@AllArgsConstructor
public class LoanService {
    final IloanRepository loanRepo;
    final IcustomerRepository customerRepo;
    final IproductRepository productRepo;

    public List<Loan> getAllLoan(){
        return  loanRepo.findAll();
    }

    public Loan getLoanById(Long id){
        return loanRepo.findById(id).orElse(null);
    }

    public void deleteLoan(Long id){
        loanRepo.deleteById(id);
        System.out.println("Loan deleted successfully");
    }

    public Loan updateLoanAmount(Long id, LoanDTO newAmount) {
        Loan loan = loanRepo.findById(id).orElse(null);
        loan.setAmount(newAmount.getAmount());
        loanRepo.save(loan);
        return loan;
    }

    public Loan updateLoanNoOfRepayment(Long id, LoanDTO newNoOfRepayment) {
        Loan loan = loanRepo.findById(id).orElse(null);
        Product product = productRepo.findById(newNoOfRepayment.getProductId()).orElseThrow(null);
        Customer customer = customerRepo.findById(newNoOfRepayment.getCustomerId()).orElseThrow(null);
        if((newNoOfRepayment.getNoOfLoanRepayment()>= product.getNoRepaymentMin()) &&
                (newNoOfRepayment.getNoOfLoanRepayment()<= product.getNoRepaymentMax() ))
        {
            loan.setNoOfLoanRepayment(newNoOfRepayment.getNoOfLoanRepayment());
            loanRepo.save(loan);
        }
        return loan;
    }

    public Loan createLoan(LoanDTO bridge) {
        Product product = productRepo.findById(bridge.getProductId()).orElseThrow(null);
        Customer customer = customerRepo.findById(bridge.getCustomerId()).orElseThrow(null);
        if ((bridge.getNoOfLoanRepayment() >= product.getNoRepaymentMin()) &&
                (bridge.getNoOfLoanRepayment() <= product.getNoRepaymentMax())) {
            Loan newLoan = Loan.CreateLoan(bridge, customer, product);
            return loanRepo.save(newLoan);
        }
        // rewrite with the exceptions
        return null ;
    }

}



