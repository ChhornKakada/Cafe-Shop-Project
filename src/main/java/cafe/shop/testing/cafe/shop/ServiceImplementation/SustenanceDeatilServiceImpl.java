package cafe.shop.testing.cafe.shop.ServiceImplementation;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import cafe.shop.testing.cafe.shop.entities.Sustenance;
import cafe.shop.testing.cafe.shop.entities.SustenanceDetail;
import cafe.shop.testing.cafe.shop.repositories.SustenanceDetailRepository;
import cafe.shop.testing.cafe.shop.repositories.SustenanceRepository;
import cafe.shop.testing.cafe.shop.services.SustenanceDetailService;
import cafe.shop.testing.cafe.shop.services.SustenanceService;

@Service
public class SustenanceDeatilServiceImpl implements SustenanceDetailService {

  private SustenanceDetailRepository susDatailRepo;
  private SustenanceRepository susRepo;
  private SustenanceService susService;



  public SustenanceDeatilServiceImpl(SustenanceDetailRepository susDatailRepo, SustenanceRepository susRepo,
      SustenanceService susService) {
    super();
    this.susDatailRepo = susDatailRepo;
    this.susRepo = susRepo;
    this.susService = susService;
  }

  @Override
  public SustenanceDetail getVieId(Long id) {
    return susDatailRepo.findById(id).get();
  }

  // get a sustanance by susID
  @Override
  public List<SustenanceDetail> getSusVieId(Long susID) {
    List <SustenanceDetail> susList = new ArrayList<>();
    for (var sus : susDatailRepo.findAll()) {
      if (sus.getSust().getId() == susID) {
        susList.add(sus);
      }
    }
    return susList;
  }

  @Override
  public void addNewFood(Sustenance food, Float price, MultipartFile file) {
    SustenanceDetail foodDetail = new SustenanceDetail();
    susService.addNewFood(food, file);
    Sustenance tmpFood = new Sustenance();
    tmpFood = susRepo.findByName(food.getName());
    foodDetail.setSust(tmpFood);
    foodDetail.setPrice(BigDecimal.valueOf(price));
    susDatailRepo.save(foodDetail);
  }

  @Override
  public void deleteVieId(Long id) {
    susDatailRepo.deleteById(id);
  }

  @Override
  public void deleteSustenanceVieId(long susId) {
    for (var susDetail : susDatailRepo.findAll()) {
      if (susDetail.getSust().getId() == susId) {
        susDatailRepo.deleteById(susDetail.getId());
      }
    }
  }

  @Override
  public SustenanceDetail updateFoodVieSusId(Long susId, SustenanceDetail susDetail, MultipartFile file) {
    SustenanceDetail oldSusDetail = new SustenanceDetail();
    Sustenance oldSus = new Sustenance();
    oldSus = susDetail.getSust();
    susService.updateVieID(susId, oldSus, file);
    for (var food : susDatailRepo.findAll()) {
      if (food.getSust().getId().equals(susId)) {
        oldSusDetail = food;
        break;
      }
    }
    oldSusDetail.setPrice(susDetail.getPrice());
    return susDatailRepo.save(oldSusDetail);
  }

  
}
