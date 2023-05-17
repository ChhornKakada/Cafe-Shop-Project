package cafe.shop.testing.cafe.shop.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cafe.shop.testing.cafe.shop.entities.Tables;
import cafe.shop.testing.cafe.shop.repositories.TableRepository;

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
