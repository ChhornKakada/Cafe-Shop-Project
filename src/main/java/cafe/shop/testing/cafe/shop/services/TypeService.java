package cafe.shop.testing.cafe.shop.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cafe.shop.testing.cafe.shop.entities.Type;
import cafe.shop.testing.cafe.shop.repositories.TypeRepository;

@Service
public class TypeService {

    @Autowired
    TypeRepository typeRepository; 

    public TypeService(TypeRepository typeRepository) {
        this.typeRepository = typeRepository;
    }

    public List<Type> getAllTypes(){
        return typeRepository.findAll(); 
    }
}
