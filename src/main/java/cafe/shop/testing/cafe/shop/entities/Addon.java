package cafe.shop.testing.cafe.shop.entities;

import java.math.BigDecimal;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "addon")
public class Addon {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @OneToMany(cascade = CascadeType.ALL)
  @JoinColumn(name = "addon_id", referencedColumnName = "id")
  private List <AddonDetail> addonDetails;

  @Column(precision = 10, scale = 2)
  private BigDecimal totalPrice;

  // Constructors

  public Addon() {}

  public Addon(List<AddonDetail> addonDetails, BigDecimal totalPrice) {
    this.addonDetails = addonDetails;
    this.totalPrice = totalPrice;
  }

  // getter and setter

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public List<AddonDetail> getAddonDetails() {
    return addonDetails;
  }

  public void setAddonDetails(List<AddonDetail> addonDetails) {
    this.addonDetails = addonDetails;
  }

  public BigDecimal getTotalPrice() {
    return totalPrice;
  }

  public void setTotalPrice(BigDecimal totalPrice) {
    this.totalPrice = totalPrice;
  }

  public void addAnAddonDetail(AddonDetail addonDetail) {
    this.totalPrice = this.totalPrice.add(addonDetail.getTopping().getPrice());
    this.addonDetails.add(addonDetail);
  }
  

}
