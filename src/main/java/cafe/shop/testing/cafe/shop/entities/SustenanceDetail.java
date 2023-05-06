package cafe.shop.testing.cafe.shop.entities;

import java.math.BigDecimal;

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
@Table(name = "sustenance_detail")
public class SustenanceDetail {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "sustenance_id")
  private Sustenance sust;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "size_id")
  private Size size;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "category_id")
  private Category ctg;

  @Column(precision = 10, scale = 2, nullable = false)
  private BigDecimal price;


  // Constuctors

  public SustenanceDetail() {}


  public SustenanceDetail(Sustenance sust, Size size, Category ctg, BigDecimal price) {
    this.sust = sust;
    this.size = size;
    this.ctg = ctg;
    this.price = price;
  }


  public Long getId() {
    return id;
  }


  public void setId(Long id) {
    this.id = id;
  }


  public Sustenance getSust() {
    return sust;
  }


  public void setSust(Sustenance sust) {
    this.sust = sust;
  }


  public Size getSize() {
    return size;
  }


  public void setSize(Size size) {
    this.size = size;
  }


  public Category getCtg() {
    return ctg;
  }


  public void setCtg(Category ctg) {
    this.ctg = ctg;
  }


  public BigDecimal getPrice() {
    return price;
  }


  public void setPrice(BigDecimal price) {
    this.price = price;
  }



}
