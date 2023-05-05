package cafe.shop.testing.cafe.shop.entities;

import java.sql.Timestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "invoice")
public class Invoice {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private Double totalPrice;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "table_id")
  private Table table;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "emp_id")
  private Employee emp;

  private Timestamp orderedAt;

  private Double cashReceived;

  private Double changed;
  
  private Double exchangedRate;
}
