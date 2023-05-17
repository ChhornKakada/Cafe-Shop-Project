package cafe.shop.testing.cafe.shop.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cafe.shop.testing.cafe.shop.controllers.TableController;
import cafe.shop.testing.cafe.shop.repositories.TableRepository;
import ch.qos.logback.classic.pattern.TargetLengthBasedClassNameAbbreviator;
import cafe.shop.testing.cafe.shop.entities.Tables;

import java.util.List;

@Service
public class TableService {
    
    @Autowired
    TableRepository tableRepository; 

    public List<Tables> getTables(){
        return tableRepository.findAll();
    }

    public Tables getTableById(Long id){
        return tableRepository.getTableById(id); 
    }

    public Tables updateTable(Tables table){
        return tableRepository.save(table); 

    }
    public Tables addNewTable(Tables table){
        return tableRepository.save(table); 
    }
}
