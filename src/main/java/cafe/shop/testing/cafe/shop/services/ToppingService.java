package cafe.shop.testing.cafe.shop.services;

import java.util.List;

import cafe.shop.testing.cafe.shop.entities.Topping;

public interface ToppingService {
  List <Topping> getAll();
  Topping getVieId(Long id);
  Topping getByName(String toppingName);
}
