package cafe.shop.testing.cafe.shop.ServiceImplementation;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import cafe.shop.testing.cafe.shop.entities.Tables;
import cafe.shop.testing.cafe.shop.entities.Status;
import cafe.shop.testing.cafe.shop.repositories.TableRepository;
import cafe.shop.testing.cafe.shop.services.TableService;

@Service
public class TableServiceImpl implements TableService {

  private TableRepository tableRepo;

  public TableServiceImpl(TableRepository tableRepo) {
    super();
    this.tableRepo = tableRepo;
  }

  @Override
  public Tables getVeiId(Long id) {
    return tableRepo.findById(id).orElse(null);
  }

  @Override
  public List<Tables> getAvailables() {
    List <Tables> tables = new ArrayList<>();
    for (var table : tableRepo.findAll()) {
      if (table.getStatus().equals(Status.available)) {
        tables.add(table);
      }
    }
    return tables;
  }

  @Override
  public void triggerStatus(Long id) {
    Tables table = new Tables();
    table = tableRepo.findById(id).orElse(null);
    if (table != null) {
      if (table.getStatus().equals(Status.available)) {
        table.setStatus(Status.unavailable);
      } else table.setStatus(Status.available);
      tableRepo.save(table);
    }
  }
  
}
