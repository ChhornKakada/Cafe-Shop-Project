package cafe.shop.testing.cafe.shop.entities;

import java.math.BigDecimal;
import java.sql.Timestamp;

import jakarta.persistence.Column;
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

  @Column(precision = 10, scale = 2)
  private BigDecimal totalPrice;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "table_id")
  private Tables table;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "emp_id")
  private Employee emp;

  private Timestamp orderedAt;

  @Column(precision = 10, scale = 2)
  private BigDecimal cashReceived;

  @Column(precision = 10, scale = 2)
  private BigDecimal changed;
  
  @Column(precision = 10, scale = 2)
  private BigDecimal exchangedRate;

  public Invoice() {}

  public Invoice(BigDecimal totalPrice, Tables table, Employee emp, Timestamp orderedAt, BigDecimal cashReceived,
      BigDecimal changed, BigDecimal exchangedRate) {
    this.totalPrice = totalPrice;
    this.table = table;
    this.emp = emp;
    this.orderedAt = orderedAt;
    this.cashReceived = cashReceived;
    this.changed = changed;
    this.exchangedRate = exchangedRate;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public BigDecimal getTotalPrice() {
    return totalPrice;
  }

  public void setTotalPrice(BigDecimal totalPrice) {
    this.totalPrice = totalPrice;
  }

  public Tables getTable() {
    return table;
  }

  public void setTable(Tables table) {
    this.table = table;
  }

  public Employee getEmp() {
    return emp;
  }

  public void setEmp(Employee emp) {
    this.emp = emp;
  }

  public Timestamp getOrderedAt() {
    return orderedAt;
  }

  public void setOrderedAt(Timestamp orderedAt) {
    this.orderedAt = orderedAt;
  }

  public BigDecimal getCashReceived() {
    return cashReceived;
  }

  public void setCashReceived(BigDecimal cashReceived) {
    this.cashReceived = cashReceived;
  }

  public BigDecimal getChanged() {
    return changed;
  }

  public void setChanged(BigDecimal changed) {
    this.changed = changed;
  }

  public BigDecimal getExchangedRate() {
    return exchangedRate;
  }

  public void setExchangedRate(BigDecimal exchangedRate) {
    this.exchangedRate = exchangedRate;
  }

  
}
