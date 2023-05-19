package cafe.shop.testing.cafe.shop.services;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import cafe.shop.testing.cafe.shop.entities.Sustenance;

public interface SustenanceService {
    
    // for food
    List <Sustenance> getAllFoods();
    Sustenance getVieId(Long id);
    List <Sustenance> getAllDrinks();
    void addNewFood(Sustenance sus, MultipartFile file);
    void addNewDrink(Sustenance sus, MultipartFile file);
    Sustenance findByName(String name);
    void deleteVieId(Long id);
    Sustenance updateVieID(Long id, Sustenance newSus, MultipartFile file);

}
