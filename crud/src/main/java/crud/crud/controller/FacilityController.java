package crud.crud.controller;
import java.util.List;

import crud.crud.domain.*;

import crud.crud.exception.ResourceNotFoundException;
import crud.crud.service.CustomerService;
import crud.crud.service.FacilityService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;


@RestController
@RequiredArgsConstructor
public class FacilityController {

    private final FacilityService facilityService;

    @GetMapping("/viewAllFacility")
    public List<Facility> viewAllFacility() {
        List<Facility> facilities= this.facilityService.getAllFacility();
        return facilities;
    }

    @GetMapping("/viewFacilityById/{id}")
    public Facility viewFacilityById(@PathVariable("id") Long id) {
        if (facilityService.findFacilityById(id) == null) {
            throw new ResourceNotFoundException("Facility with id " + id + " not found");
        }

        return facilityService.findFacilityById(id);
    }

    @PostMapping("/addFacility")
    public void addFacility(@Valid @RequestBody FacilityDTO facilityDTO) {

        facilityService.createFacility(facilityDTO);
    }

    @DeleteMapping("/deleteFacility")
    public void deleteFacility(@RequestParam Long id) {
        facilityService.deleteFacility(id);

    }

    @PutMapping("/updateFacilityName")
    public void updateFacilityName(@RequestBody FacilityDTO facilityDTO, @RequestParam Long id){
        facilityService.updateFacilityName(id,facilityDTO);
    }

    @PutMapping("/updateFacilityAddress")
    public void updateFacilityAddress(@RequestBody FacilityDTO facilityDTO, @RequestParam Long id){
        facilityService.updateFacilityAddress(id,facilityDTO);
    }
}
