package cafe.shop.testing.cafe.shop.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cafe.shop.testing.cafe.shop.entities.Sustenance;
import cafe.shop.testing.cafe.shop.repositories.SustenanceRepository;

@Service
public class SustenanceService {
    
    private final SustenanceRepository sustenanceRepository;

    @Autowired
    public SustenanceService(SustenanceRepository sustenanceRepository){
        this.sustenanceRepository = sustenanceRepository;
    }

    public Sustenance addSustenance(Sustenance sustenance){
        return sustenanceRepository.save(sustenance); 
    }

    public List<Sustenance> getAllSustenances(){
        return sustenanceRepository.findAll();
    }

    public Sustenance getSustenanceById(Long id){
        return sustenanceRepository.getSustenanceById(id); 
    }

    public Sustenance updateSustenanceById(Sustenance sustenance){
        return sustenanceRepository.save(sustenance); 
    }

    public void deleteSustenanceById(Long id){
        sustenanceRepository.deleteById(id);
    }

}
