package cafe.shop.testing.cafe.shop.services;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import cafe.shop.testing.cafe.shop.entities.Sustenance;

public interface SustenanceService {
    
    // for food
    List <Sustenance> getAllFoods();

    // get sus whethea if drink or food 
    Sustenance getVieId(Long id);

    // get all drinks
    List <Sustenance> getAllDrinks();

    // add new food
    void addNewFood(Sustenance sus, MultipartFile file);

    // add new drink
    void addNewDrink(Sustenance sus, MultipartFile file);

    // find by name even if it's food or drink
    Sustenance findByName(String name);

    // delete it even food or drink
    void deleteVieId(Long id);

    // update even if it food or drink
    Sustenance updateVieID(Long id, Sustenance newSus, MultipartFile file);

}
