package cafe.shop.testing.cafe.shop.services;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import cafe.shop.testing.cafe.shop.entities.Sustenance;
import cafe.shop.testing.cafe.shop.entities.SustenanceDetail;

public interface SustenanceDetailService {
  SustenanceDetail getVieId(Long id);

  List <SustenanceDetail> getSusVieId(Long susID);
  void addNewFood(Sustenance sus, Float price, MultipartFile file);
  void deleteVieId(Long id);
  void deleteSustenanceVieId(long susId);
  SustenanceDetail updateFoodVieSusId(Long susId, SustenanceDetail susDetail, MultipartFile file);
}
