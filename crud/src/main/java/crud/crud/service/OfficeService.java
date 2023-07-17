package crud.crud.service;

import crud.crud.domain.Office;
import crud.crud.domain.OfficeDTO;
import crud.crud.exception.ResourceNotFoundException;
import crud.crud.repo.IofficeRepository;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.ArrayList;
import java.util.List;


@Service
@AllArgsConstructor
public class OfficeService {

 final IofficeRepository officeRepo;

    public List<Office> getAllOffice() {
        List<Office> offices = officeRepo.findAll();
        if (offices.isEmpty()) {
            throw new ResourceNotFoundException("There are no available Offices to Retrieve");
        } else {
            return offices;
        }
    }

    public Office createOffice(@Valid OfficeDTO name) {
        Office office=new Office();
        office.setName(name.getName());
        return officeRepo.save(office);
    }

    public Office getOfficeById(Long id) {
         officeRepo.findById(id);
        if (officeRepo.findById(id).isEmpty()) {
            throw new ResourceNotFoundException("There is No Available Office With Such ID");
        } else {
            return officeRepo.findById(id).get();
        }
    }

    public Office updateOfficeName(Long id, OfficeDTO newName) {
        Office office = officeRepo.findById(id).orElseThrow(null);

        // Update the office name.
        office.setName(newName.getName());

        // Save the office.
        officeRepo.save(office);

        // Return the office.
        return office;
    }


    public void deleteOffice(Long id){
        if(officeRepo.findById(id).isEmpty()){
            throw new ResourceNotFoundException("There is no Available Office with such ID to be deleted");
        }
        officeRepo.deleteById(id);
        System.out.println("Office deleted successfully");
    }
}
