package cafe.shop.testing.cafe.shop.entities;

import java.math.BigDecimal;

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

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "invoice_id")
  private Invoice invoice;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "sustDetail_id")
  private SustenanceDetail sustDetail;

  @OneToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "addon_id")
  private Addon addon;

  private int qty;

  private BigDecimal totalPrice;

  public InvoiceDetail() {}

  public InvoiceDetail(Invoice invoice, SustenanceDetail sustDetail, Addon addon, int qty, BigDecimal totalPrice) {
    this.invoice = invoice;
    this.sustDetail = sustDetail;
    this.addon = addon;
    this.qty = qty;
    this.totalPrice = totalPrice;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Invoice getInvoice() {
    return invoice;
  }

  public void setInvoice(Invoice invoice) {
    this.invoice = invoice;
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

}
