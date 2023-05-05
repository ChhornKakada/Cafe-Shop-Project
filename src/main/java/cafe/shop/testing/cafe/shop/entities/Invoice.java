package cafe.shop.testing.cafe.shop.entities;

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
@Table(name = "Invoices")
public class Invoice {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(nullable = false)
  private Double total_price;

  @Column(nullable = false)
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "table_id")
  private Tables table;

  @Column(nullable = false)
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "employee_id")
  private Employee employee;

  private Timestamp orderDate;

  public Invoice() {}

  public Invoice(Double total_price, Tables table, Employee employee, Timestamp orderDate) {
    this.total_price = total_price;
    this.table = table;
    this.employee = employee;
    this.orderDate = orderDate;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Double getTotal_price() {
    return total_price;
  }

  public void setTotal_price(Double total_price) {
    this.total_price = total_price;
  }

  public Tables getTable() {
    return table;
  }

  public void setTable(Tables table) {
    this.table = table;
  }

  public Employee getEmployee() {
    return employee;
  }

  public void setEmployee(Employee employee) {
    this.employee = employee;
  }

  public Timestamp getOrderDate() {
    return orderDate;
  }

  public void setOrderDate(Timestamp orderDate) {
    this.orderDate = orderDate;
  }

  
  
}
