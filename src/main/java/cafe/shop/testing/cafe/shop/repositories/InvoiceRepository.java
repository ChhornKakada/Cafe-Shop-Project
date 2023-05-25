package cafe.shop.testing.cafe.shop.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import cafe.shop.testing.cafe.shop.entities.Invoice;

public interface InvoiceRepository extends JpaRepository <Invoice, Long> {
  
}
