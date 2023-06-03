package cafe.shop.testing.cafe.shop.services;

import java.util.List;

import cafe.shop.testing.cafe.shop.entities.Tables;

public interface TableService {
    
    Tables getVeiId(Long id);
    List <Tables> getAvailables();
    void triggerStatus(Long id);
    List <Tables> getAllTables();

    void changeToUnavalible(Long tableID, Long invoiceId);
}
