package crud.crud.service;
import crud.crud.domain.*;
import crud.crud.exception.GlobalCustomException;
import crud.crud.exception.ResourceNotFoundException;
import crud.crud.repo.*;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import static crud.crud.domain.PaymentSchedule.CreatePaymentSchedule;


@Service
@AllArgsConstructor
public class LoanRequestTrackerService {

    final IloanRepository loanRepo;
    final IloanRequestTrackerRepository loanRequestTrackerRepositoryRepo;
    final IpaymentSchedule paymentScheduleRepo;

    @Transactional
    public void firstApprove(LoanRequestTrackerDTO loanRequestTrackerDTO) {
        Loan loan = loanRepo.findById(loanRequestTrackerDTO.getLoanId()).orElseThrow(() ->
                new ResourceNotFoundException("Loan Not Found"));
        if (LoanStatus.CREATED.getCode() != loan.getStatusId()) {
            throw new GlobalCustomException("The Loan Not Eligible for Status Update");
        } else {
            loanRepo.updateLoanStatus(loan.getId(),  LoanStatus.REVISION_APPROVAL.getCode());
            LoanRequestTracker loanRequestTracker =
                    LoanRequestTracker.CreateLoanRequestTracker(loanRequestTrackerDTO, loan);
            loanRequestTrackerRepositoryRepo.save(loanRequestTracker);
        }
    }

    @Transactional
    public void secondApprove(LoanRequestTrackerDTO loanRequestTrackerDTO) {
        Loan loan = loanRepo.findById(loanRequestTrackerDTO.getLoanId()).orElseThrow(() ->
                new ResourceNotFoundException("Loan Not Found"));
        if (LoanStatus.REVISION_APPROVAL.getCode() != loan.getStatusId() ) {
            throw new GlobalCustomException("The Loan Not Eligible for Status Update");
        } else {
            loanRepo.updateLoanStatus(loan.getId(), LoanStatus.CENTRAL_REVISION_APPROVAL.getCode());
            LoanRequestTracker loanRequestTracker =
                    LoanRequestTracker.CreateLoanRequestTracker(loanRequestTrackerDTO, loan);
            loanRequestTrackerRepositoryRepo.save(loanRequestTracker);
        }
    }

    @Transactional
    public void thirdApprove(LoanRequestTrackerDTO loanRequestTrackerDTO) {
        Loan loan = loanRepo.findById(loanRequestTrackerDTO.getLoanId()).orElseThrow(() ->
                new ResourceNotFoundException("Loan Not Found"));
        if (LoanStatus.CENTRAL_REVISION_APPROVAL.getCode() != loan.getStatusId()) {
            throw new GlobalCustomException("The Loan Not Eligible for Status Update");
        }
        else{
            loanRepo.updateLoanStatus(loan.getId(),LoanStatus.OFFICE_BRANCH_MANAGER_APPROVAL.getCode());
            LoanRequestTracker loanRequestTracker =
                    LoanRequestTracker.CreateLoanRequestTracker(loanRequestTrackerDTO, loan);
            loanRequestTrackerRepositoryRepo.save(loanRequestTracker);
        }
    }

    @Transactional
    public void secondRejection(LoanRequestTrackerDTO loanRequestTrackerDTO) {
        Loan loan = loanRepo.findById(loanRequestTrackerDTO.getLoanId()).orElseThrow(() ->
                new ResourceNotFoundException("Loan Not Found"));
        if (LoanStatus.CENTRAL_REVISION_APPROVAL.getCode() != loan.getStatusId()) {
            throw new GlobalCustomException("The Loan Not Eligible for Status Update");
        }
        else{
            loanRepo.updateLoanStatus(loan.getId(), LoanStatus.REVISION_APPROVAL.getCode());
            LoanRequestTracker loanRequestTracker =
                    LoanRequestTracker.CreateLoanRequestTracker(loanRequestTrackerDTO, loan);
            loanRequestTrackerRepositoryRepo.save(loanRequestTracker);
        }
    }

    @Transactional
    public void thirdRejection(LoanRequestTrackerDTO loanRequestTrackerDTO) {
        Loan loan = loanRepo.findById(loanRequestTrackerDTO.getLoanId()).orElseThrow(() ->
                new ResourceNotFoundException("Loan Not Found"));
        if (LoanStatus.OFFICE_BRANCH_MANAGER_APPROVAL.getCode() != loan.getStatusId()) {
            throw new GlobalCustomException("The Loan Not Eligible for Status Update");
        }
        else{
            loanRepo.updateLoanStatus(loan.getId(), LoanStatus.CENTRAL_REVISION_APPROVAL.getCode());
            LoanRequestTracker loanRequestTracker =
                    LoanRequestTracker.CreateLoanRequestTracker(loanRequestTrackerDTO, loan);
            loanRequestTrackerRepositoryRepo.save(loanRequestTracker);
        }
    }


    @Transactional
    public ArrayList<PaymentSchedule>  issuance(Long LoadId) {
        Loan loan = loanRepo.findById(LoadId).orElseThrow(() ->
                new ResourceNotFoundException("Loan Not Found"));


        // Check if it has reached the third approval and is assigned to the 'required' status
        if (LoanStatus.OFFICE_BRANCH_MANAGER_APPROVAL.getCode() == loan.getStatusId()) {
            loanRepo.updateLoanStatus(loan.getId(), LoanStatus.ISSUANCE.getCode());

            Double installmentAmount= (double) (loan.getAmount()/loan.getNoOfLoanRepayment());
            LocalDate createDate = LocalDate.now();

            ArrayList<PaymentSchedule> listOfCreatedPaymentSchedule = new ArrayList<PaymentSchedule>();
            for(int i=0 ; i<loan.getNoOfLoanRepayment();i++){
                listOfCreatedPaymentSchedule.add(CreatePaymentSchedule(installmentAmount,i,
                        createDate.plusMonths(i+1)));
            }
            paymentScheduleRepo.saveAll(listOfCreatedPaymentSchedule);
            return listOfCreatedPaymentSchedule;

        } else {
            throw new GlobalCustomException("The Loan is not eligible for issuance.");
        }
    }
}