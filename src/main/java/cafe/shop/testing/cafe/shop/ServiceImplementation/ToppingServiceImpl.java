package cafe.shop.testing.cafe.shop.ServiceImplementation;

import java.util.List;

import org.springframework.stereotype.Service;

import cafe.shop.testing.cafe.shop.entities.Topping;
import cafe.shop.testing.cafe.shop.repositories.ToppingRepository;
import cafe.shop.testing.cafe.shop.services.ToppingService;

@Service
public class ToppingServiceImpl implements ToppingService {

  private ToppingRepository toppingRepo;

  public ToppingServiceImpl(ToppingRepository toppingRepo) {
    super();
    this.toppingRepo = toppingRepo;
  }

  @Override
  public List<Topping> getAll() {
    return toppingRepo.findAll();
  }

  @Override
  public Topping getVieId(Long id) {
    return toppingRepo.findById(id).get();
  }

  @Override
  public Topping getByName(String toppingName) {
    for (var topping : toppingRepo.findAll()) {
      if (topping.getName().equals(toppingName)) {
        return topping;
      }
    }
    return null;
  }
  
}
