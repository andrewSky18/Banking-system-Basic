package crud.crud.controller;

import crud.crud.domain.Office;
import crud.crud.domain.OfficeDTO;
import crud.crud.service.OfficeService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@RestController
@AllArgsConstructor
@Validated
public class OfficeController {

    @Autowired
    OfficeService officeService;


    //Done retrieve all
    @GetMapping({"/", "/viewOfficeList"})
    public List<Office> viewOfficeList() {
        List<Office> offices= this.officeService.getAllOffice();
        return offices;
    }

    //not yet: retrieve one office by ID
    @GetMapping("/viewOfficeById/{id}")
    public Office viewOfficeById(@PathVariable("id") Long id) {
        return officeService.getOfficeById(id);
    }

    //Done create or add new
    @PostMapping("/addOffice")
    public void addOffice(@Valid @RequestBody OfficeDTO officeName) {
       officeService.createOffice(officeName);

    }
    //not yet
    @DeleteMapping("/deleteOffice")
    public String deleteOffice(@RequestParam Long id) {
        officeService.deleteOffice(id);
        String ret = "Deleted Successfully";
        return ret;
    }

    //not yet
    @PutMapping("/updateOfficeName")
    public void updateOfficeName(@RequestBody OfficeDTO officeName, @RequestParam Long id){
        officeService.updateOfficeName(id,officeName);
    }

}
