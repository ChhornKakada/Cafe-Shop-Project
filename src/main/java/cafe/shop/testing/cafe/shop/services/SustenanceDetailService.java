package cafe.shop.testing.cafe.shop.services;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import cafe.shop.testing.cafe.shop.entities.Sustenance;
import cafe.shop.testing.cafe.shop.entities.SustenanceDetail;
import cafe.shop.testing.cafe.shop.models.DrinkDetail;

public interface SustenanceDetailService {
  SustenanceDetail getVieId(Long id);

  List<SustenanceDetail> getSusVieId(Long susID);

  void addNewFood(Sustenance sus, Float price, MultipartFile file);

  void deleteVieId(Long id);

  // delete in susDetail and sus in db, they related to each other
  void deleteSustenanceVieId(long susId);

  // update food by food id not susDetailId
  SustenanceDetail updateFoodVieSusId(Long susId, SustenanceDetail susDetail, MultipartFile file);

  DrinkDetail getDrinkDetail(Long drinkId);

  void addNewDrink(DrinkDetail newDrink, MultipartFile file);

  DrinkDetail updateDrinkVieSusId(Long drinkId, DrinkDetail newDrink, MultipartFile file);

  List<SustenanceDetail> getAll();

  SustenanceDetail getFoodDeteailVieFoodId(long foodId);

}
