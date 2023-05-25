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
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "invoice_detail")
public class InvoiceDetail {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "sustDetail_id")
  private SustenanceDetail sustDetail;

  @OneToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "addon_id", referencedColumnName = "id")
  private Addon addon;

  private int qty;

  @Column(precision = 10, scale = 2)
  private BigDecimal totalPrice;

  private String note;

  public InvoiceDetail() {}

  public InvoiceDetail(SustenanceDetail sustDetail, Addon addon, int qty, BigDecimal totalPrice, String note) {
    this.sustDetail = sustDetail;
    this.addon = addon;
    this.qty = qty;
    this.totalPrice = totalPrice;
    this.note = note;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public SustenanceDetail getSustDetail() {
    return sustDetail;
  }

  public void setSustDetail(SustenanceDetail sustDetail) {
    this.sustDetail = sustDetail;
  }

  public Addon getAddon() {
    return addon;
  }

  public void setAddon(Addon addon) {
    this.addon = addon;
  }

  public int getQty() {
    return qty;
  }

  public void setQty(int qty) {
    this.qty = qty;
  }

  public BigDecimal getTotalPrice() {
    return totalPrice;
  }

  public void setTotalPrice(BigDecimal totalPrice) {
    this.totalPrice = totalPrice;
  }

  public String getNote() {
    return note;
  }

  public void setNote(String note) {
    this.note = note;
  }

  

}
