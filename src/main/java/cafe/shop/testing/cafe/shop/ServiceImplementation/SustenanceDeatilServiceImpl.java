package cafe.shop.testing.cafe.shop.ServiceImplementation;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import cafe.shop.testing.cafe.shop.entities.Category;
import cafe.shop.testing.cafe.shop.entities.Size;
import cafe.shop.testing.cafe.shop.entities.Sustenance;
import cafe.shop.testing.cafe.shop.entities.SustenanceDetail;
import cafe.shop.testing.cafe.shop.models.DrinkDetail;
import cafe.shop.testing.cafe.shop.models.Price;
import cafe.shop.testing.cafe.shop.repositories.CategoryRepository;
import cafe.shop.testing.cafe.shop.repositories.SizeRepository;
import cafe.shop.testing.cafe.shop.repositories.SustenanceDetailRepository;
import cafe.shop.testing.cafe.shop.repositories.SustenanceRepository;
import cafe.shop.testing.cafe.shop.services.SustenanceDetailService;
import cafe.shop.testing.cafe.shop.services.SustenanceService;

@Service
public class SustenanceDeatilServiceImpl implements SustenanceDetailService {

  private SustenanceDetailRepository susDatailRepo;
  private SustenanceRepository susRepo;
  private SustenanceService susService;
  private CategoryRepository ctgRepo;
  private SizeRepository sizeRepo;



  public SustenanceDeatilServiceImpl(SustenanceDetailRepository susDatailRepo, SustenanceRepository susRepo,
      SustenanceService susService, CategoryRepository ctgRepo, SizeRepository sizeRepo) {
    super();
    this.susDatailRepo = susDatailRepo;
    this.susRepo = susRepo;
    this.susService = susService;
    this.ctgRepo = ctgRepo;
    this.sizeRepo = sizeRepo;
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

  // Update food
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


  @Override
  public DrinkDetail getDrinkDetail(Long drinkId) {
    DrinkDetail drinkDetail = new DrinkDetail();
    List <SustenanceDetail> drinkDetailList = new ArrayList<>();
    drinkDetailList = this.getSusVieId(drinkId);
    Price price = new Price();
    for (var drink : drinkDetailList) {
      if (drink.getCtg().getName().equals("Hot")) {
        if (drink.getSize().getSize().equals("Small")) {
          price.setHotSmall(drink.getPrice().doubleValue());
        } else if (drink.getSize().getSize().equals("Medium")) {
          price.setHotMedium(drink.getPrice().doubleValue());
        } else price.setHotLarge(drink.getPrice().doubleValue());
      } 
      else if (drink.getCtg().getName().equals("Iced")) {
        if (drink.getSize().getSize().equals("Small")) {
          price.setIcedSmall(drink.getPrice().doubleValue());
        } else if (drink.getSize().getSize().equals("Medium")) {
          price.setIcedMedium(drink.getPrice().doubleValue());
        } else price.setIcedLarge(drink.getPrice().doubleValue());
      } 
      else {
        if (drink.getSize().getSize().equals("Small")) {
          price.setFreppeSmall(drink.getPrice().doubleValue());
        } else if (drink.getSize().getSize().equals("Medium")) {
          price.setFreppeMedium(drink.getPrice().doubleValue());
        } else price.setFreppeLarge(drink.getPrice().doubleValue());
      }
    }
    drinkDetail.setPrice(price);
    drinkDetail.setLastUpdate(drinkDetailList.get(0).getSust().getLastUpdated());
    drinkDetail.setName(drinkDetailList.get(0).getSust().getName());
    drinkDetail.setDesc(drinkDetailList.get(0).getSust().getDesc());
    drinkDetail.setImg(drinkDetailList.get(0).getSust().getImg());
    drinkDetail.setId(drinkDetailList.get(0).getSust().getId());
    return drinkDetail;
  }

  // Add new drink
  @Override
  public void addNewDrink(DrinkDetail newDrink, MultipartFile file) {
    Sustenance tmpDrink = new Sustenance();
    tmpDrink.setDesc(newDrink.getDesc());
    tmpDrink.setName(newDrink.getName());
    susService.addNewDrink(tmpDrink, file);
    // after add the drink, we replace it to get id to insert in susDetail table
    tmpDrink = susService.findByName(newDrink.getName());
    List <SustenanceDetail> drinkDetails = new ArrayList<>();
    // category: 0-hot 1-iced 2-freppe
    // size: 0-s 1-m 2-l

    // insert
    Size small = new Size();
    small = sizeRepo.findById(1L).get();
    Size medium = new Size();
    medium = sizeRepo.findById(2L).get();
    Size large = new Size();
    large = sizeRepo.findById(3L).get();

    Category hot = new Category();
    hot = ctgRepo.findById(1L).get();
    Category iced = new Category();
    iced = ctgRepo.findById(2L).get();
    Category freppe = new Category();
    freppe = ctgRepo.findById(3L).get();
    drinkDetails.add(new SustenanceDetail(tmpDrink, small, hot, new BigDecimal(newDrink.getPrice().getHotSmall())));
    drinkDetails.add(new SustenanceDetail(tmpDrink, small, iced, new BigDecimal(newDrink.getPrice().getIcedSmall())));
    drinkDetails.add(new SustenanceDetail(tmpDrink, small, freppe, new BigDecimal(newDrink.getPrice().getFreppeSmall())));
    drinkDetails.add(new SustenanceDetail(tmpDrink, medium, hot, new BigDecimal(newDrink.getPrice().getHotMedium())));
    drinkDetails.add(new SustenanceDetail(tmpDrink, medium, iced, new BigDecimal(newDrink.getPrice().getIcedMedium())));
    drinkDetails.add(new SustenanceDetail(tmpDrink, medium, freppe, new BigDecimal(newDrink.getPrice().getFreppeMedium())));
    drinkDetails.add(new SustenanceDetail(tmpDrink, large, hot, new BigDecimal(newDrink.getPrice().getHotLarge())));
    drinkDetails.add(new SustenanceDetail(tmpDrink, large, iced, new BigDecimal(newDrink.getPrice().getIcedLarge())));
    drinkDetails.add(new SustenanceDetail(tmpDrink, large, freppe, new BigDecimal(newDrink.getPrice().getFreppeLarge())));

    for (var drinkDe : drinkDetails) {
      susDatailRepo.save(drinkDe);
    }
  }


  // Update drink
  @Override
  public DrinkDetail updateDrinkVieSusId(Long drinkId, DrinkDetail newDrink, MultipartFile file) {
    Sustenance tmpDrink = new Sustenance();
    tmpDrink.setDesc(newDrink.getDesc());
    tmpDrink.setName(newDrink.getName());
    susService.updateVieID(drinkId, tmpDrink, file);
    List <SustenanceDetail> drinkDetails = new ArrayList<>();
    drinkDetails = this.getSusVieId(drinkId);

    for (var dd : drinkDetails) {
      if (dd.getCtg().getName().equals("Hot")) {
        if (dd.getSize().getSize().equals("Small")) {
          dd.setPrice(new BigDecimal(newDrink.getPrice().getHotSmall()));
        } else if (dd.getSize().getSize().equals("Medium")) {
          dd.setPrice(new BigDecimal(newDrink.getPrice().getHotMedium()));
        } else dd.setPrice(new BigDecimal(newDrink.getPrice().getHotLarge()));
      } else if (dd.getCtg().getName().equals("Iced")) {
        if (dd.getSize().getSize().equals("Small")) {
          dd.setPrice(new BigDecimal(newDrink.getPrice().getIcedSmall()));
        } else if (dd.getSize().getSize().equals("Medium")) {
          dd.setPrice(new BigDecimal(newDrink.getPrice().getIcedMedium()));
        } else dd.setPrice(new BigDecimal(newDrink.getPrice().getIcedLarge()));
      } else {
        if (dd.getSize().getSize().equals("Small")) {
          dd.setPrice(new BigDecimal(newDrink.getPrice().getFreppeSmall()));
        } else if (dd.getSize().getSize().equals("Medium")) {
          dd.setPrice(new BigDecimal(newDrink.getPrice().getFreppeMedium()));
        } else dd.setPrice(new BigDecimal(newDrink.getPrice().getFreppeLarge()));
      }
    }
    susDatailRepo.saveAll(drinkDetails);
    return newDrink;
  }
  
}
