package crud.crud.service;


import crud.crud.domain.Customer;
import crud.crud.domain.CustomerDTO;
import crud.crud.domain.Facility;
import crud.crud.domain.FacilityDTO;
import crud.crud.repo.IcustomerRepository;
import crud.crud.repo.IfacilityRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class FacilityService {
    final IfacilityRepository facilityRepository;


    public List<Facility>  getAllFacility(){

        return facilityRepository.findAll();
    }

    public Facility findFacilityById(Long id){

        return facilityRepository.findById(id).orElse(null);
    }


    public Facility createFacility(FacilityDTO bridge) {

        Facility newFacility=Facility.CreateFacility(bridge) ;
        return facilityRepository.save(newFacility);
    }

    public Facility updateFacilityName(Long id, FacilityDTO newName) {
        Facility facility = facilityRepository.findById(id).orElse(null);
        facility.setName(newName.getName());
        facilityRepository.save(facility);
        return facility;
    }

    public Facility updateFacilityAddress(Long id, FacilityDTO newAdd) {
        Facility facility = facilityRepository.findById(id).orElse(null);
        facility.setAddress(newAdd.getAddress());
        facilityRepository.save(facility);
        return facility;
    }

    public void deleteFacility(Long id){
        facilityRepository.deleteById(id);
        System.out.println("Customer deleted successfully");
    }
}
