package cafe.shop.testing.cafe.shop.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cafe.shop.testing.cafe.shop.entities.Sustenance;
import cafe.shop.testing.cafe.shop.services.SustenanceService;



@RestController
@RequestMapping
public class SustenanceController {
    
    @Autowired
    SustenanceService sustenanceService; 

    @PostMapping("/addNewSustenance")
    public Sustenance addSustenance(@RequestBody Sustenance sustenance){
        return sustenanceService.addSustenance(sustenance); 
    }

    @GetMapping("/sustenances")
    public List<Sustenance> getAllSustenances(){
        return sustenanceService.getAllSustenances();
    }

    @GetMapping("/getSustenanceById/{id}")
    public Sustenance getSustenanceById(@PathVariable("id") Long id) {
        return sustenanceService.getSustenanceById(id); 
    }

    @PutMapping("/updateSustenanceById/{id}")
    public Sustenance updateSustenanceById(@PathVariable("id") Long id) {
        Sustenance sustenance = new Sustenance(); 
        sustenance = getSustenanceById(id); 

        sustenance.setImg("9090");

        return sustenanceService.updateSustenanceById(sustenance); 
    }

    @DeleteMapping("/deleteSustenanceById/{id}")
    public void deleteSustenanceById(@PathVariable("id") Long id) {
        sustenanceService.deleteSustenanceById(id); 
    }

    
}
