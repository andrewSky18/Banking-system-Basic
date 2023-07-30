package crud.crud.controller;

import java.util.ArrayList;
import java.util.List;

import crud.crud.domain.*;

import crud.crud.exception.GlobalCustomException;
import crud.crud.exception.ResourceNotFoundException;
import crud.crud.service.CustomerService;
import crud.crud.service.LoanRequestTrackerService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@Validated
public class LoanRequestTrackerController {

    private final LoanRequestTrackerService loanRequestTrackerService;

    @PostMapping("/firstApprove")
    public void firstApprove(@RequestBody @Valid LoanRequestTrackerDTO loanRequestTrackerDTO){
        loanRequestTrackerService.firstApprove(loanRequestTrackerDTO);
    }

    @PostMapping("/secondApprove")
    public void secondApprove(@RequestBody @Valid LoanRequestTrackerDTO loanRequestTrackerDTO){
        loanRequestTrackerService.secondApprove(loanRequestTrackerDTO);
    }

    @PostMapping("/thirdApprove")
    public void thirdApprove(@RequestBody @Valid LoanRequestTrackerDTO loanRequestTrackerDTO){
        loanRequestTrackerService.thirdApprove(loanRequestTrackerDTO);
    }

    @PostMapping("/issuance")
    public ArrayList<PaymentSchedule> issuance(@RequestParam Long loadId){

        return loanRequestTrackerService.issuance(loadId);
    }

}
