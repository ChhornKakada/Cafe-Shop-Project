package cafe.shop.testing.cafe.shop.models;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import cafe.shop.testing.cafe.shop.entities.Status;
import cafe.shop.testing.cafe.shop.entities.Tables;
import cafe.shop.testing.cafe.shop.repositories.TableRepository;

@Component
public class TableResetScheduler {

    private final TableRepository tableRepository;
    private boolean isFirstRunOfDay;

    @Autowired
    public TableResetScheduler(TableRepository tableRepository) {
        this.tableRepository = tableRepository;
        this.isFirstRunOfDay = false;
    }

    @Scheduled(fixedRate = 60000) // Run every minute
    public void checkAndResetTableAvailability() {
        LocalDate currentDate = LocalDate.now();
        if (!isFirstRunOfDay) {
            isFirstRunOfDay = true;
            System.out.println("Table availability reset task executed.");
            // Perform table reset logic here
            // For example, update the tables in the database to be available
            List<Tables> tables = tableRepository.findAll();
            for (Tables table : tables) {
                table.setStatus(Status.available);
                table.setInvoice_current_id(null);
                tableRepository.save(table);
            }
        }
    }
}
