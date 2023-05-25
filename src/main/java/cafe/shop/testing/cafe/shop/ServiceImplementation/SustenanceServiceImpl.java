package cafe.shop.testing.cafe.shop.ServiceImplementation;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import cafe.shop.testing.cafe.shop.entities.Sustenance;
import cafe.shop.testing.cafe.shop.repositories.SustenanceRepository;
import cafe.shop.testing.cafe.shop.repositories.TypeRepository;
import cafe.shop.testing.cafe.shop.services.SustenanceService;

@Service
public class SustenanceServiceImpl implements SustenanceService{

  @Autowired
  private SustenanceRepository susRepo;

  @Autowired
  private TypeRepository typeRepo;

  public SustenanceServiceImpl(SustenanceRepository susRepo) {
    super();
    this.susRepo = susRepo;
  }

  // get all food
  @Override
  public List<Sustenance> getAllFoods() {
    List <Sustenance> foods = new ArrayList<>();
    for (var sus : susRepo.findAll()) {
      if (sus.getType().getName().equals("Food")) {
        foods.add(sus);
      }
        
    }
    return foods;
  }

  // get sustenance by id
  @Override
  public Sustenance getVieId(Long id) {
    return susRepo.findById(id).orElse(null);
  }

  @Override
  public List<Sustenance> getAllDrinks() {
    List <Sustenance> drinks = new ArrayList<>();
    for (var sus : susRepo.findAll()) {
      if (sus.getType().getName().equals("Drink"))
        drinks.add(sus);
    }
    return drinks;
  }

  @Override
  public void addNewFood(Sustenance sus, MultipartFile file) {
    sus.setLastUpdated(new Timestamp(System.currentTimeMillis()));
    String fileName = StringUtils.cleanPath(file.getOriginalFilename());
    if (fileName.contains("..")) {
      System.out.println("not a valid file");
    }
    try { 
      sus.setImg(Base64.getEncoder().encodeToString(file.getBytes()));
    } catch(IOException e) {
      e.printStackTrace();
    }
    sus.setType(typeRepo.findById(2L).get());
    susRepo.save(sus);
  }

  @Override
  public void addNewDrink(Sustenance sus, MultipartFile file) {
    sus.setLastUpdated(new Timestamp(System.currentTimeMillis()));
    String fileName = StringUtils.cleanPath(file.getOriginalFilename());
    if (fileName.contains("..")) {
      System.out.println("not a valid file");
    }
    try { 
      sus.setImg(Base64.getEncoder().encodeToString(file.getBytes()));
    } catch(IOException e) {
      e.printStackTrace();
    }
    sus.setType(typeRepo.findById(1L).get());
    susRepo.save(sus);
  }

  // find sustance by name
  @Override
  public Sustenance findByName(String name) {
    return susRepo.findByName(name);
  }

  @Override
  public void deleteVieId(Long id) {
    susRepo.deleteById(id);
  }

  @Override
  public Sustenance updateVieID(Long id, Sustenance newSus, MultipartFile file) {
    Sustenance oldSus = new Sustenance();
    oldSus = susRepo.findById(id).get();
    oldSus.setDesc(newSus.getDesc());
    oldSus.setName(newSus.getName());
    oldSus.setLastUpdated(new Timestamp(System.currentTimeMillis()));
    if (!file.isEmpty()) {
      String fileName = StringUtils.cleanPath(file.getOriginalFilename());
      if (fileName.contains("..")) {
        System.out.println("not a valid file");
      }
      try { 
        oldSus.setImg(Base64.getEncoder().encodeToString(file.getBytes()));
      } catch(IOException e) {
        e.printStackTrace();
      }
    }
    return susRepo.save(oldSus);
  }

  
}
