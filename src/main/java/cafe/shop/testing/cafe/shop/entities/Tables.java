package cafe.shop.testing.cafe.shop.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;



@Entity
public class Tables {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Enumerated(EnumType.STRING)
  private Status status;

  private Long invoice_current_id;

  // Constructor
  public Tables() {}

  public Tables(Status status, Long invoice_current_id) {
    this.status = status;
    this.invoice_current_id = invoice_current_id;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Status getStatus() {
    return status;
  }

  public void setStatus(Status status) {
    this.status = status;
  }

  public Long getInvoice_current_id() {
    return invoice_current_id;
  }

  public void setInvoice_current_id(Long invoice_current_id) {
    this.invoice_current_id = invoice_current_id;
  }

 
}
