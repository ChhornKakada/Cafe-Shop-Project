package cafe.shop.testing.cafe.shop.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "addon_detail")
public class AddonDetail {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "addon_id")
  private Addon addon;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "toping_id")
  private Toping toping;

  public AddonDetail() {}

  public AddonDetail(Addon addon, Toping toping) {
    this.addon = addon;
    this.toping = toping;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Addon getAddon() {
    return addon;
  }

  public void setAddon(Addon addon) {
    this.addon = addon;
  }

  public Toping getToping() {
    return toping;
  }

  public void setToping(Toping toping) {
    this.toping = toping;
  }

  

}
