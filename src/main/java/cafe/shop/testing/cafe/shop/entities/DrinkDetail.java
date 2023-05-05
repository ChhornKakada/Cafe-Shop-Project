package cafe.shop.testing.cafe.shop.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "drink_details")
public class DrinkDetail {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @OneToOne(fetch = FetchType.LAZY)
  @Column(nullable = false)
  @JoinColumn(name = "category_id")
  private Category category;

  @OneToOne(fetch = FetchType.LAZY)
  @Column(nullable = false)
  @JoinColumn(name = "size_id")
  private Size size;

  @OneToOne(fetch = FetchType.LAZY)
  @Column(nullable = false)
  @JoinColumn(name = "drink_id")
  private Drink name;

  @Column(nullable = false)
  private Double price;

  private String description;

  public DrinkDetail(){}

  public DrinkDetail(Category category, Size size, Drink name, Double price, String description) {
    this.category = category;
    this.size = size;
    this.name = name;
    this.price = price;
    this.description = description;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Category getCategory() {
    return category;
  }

  public void setCategory(Category category) {
    this.category = category;
  }

  public Size getSize() {
    return size;
  }

  public void setSize(Size size) {
    this.size = size;
  }

  public Drink getName() {
    return name;
  }

  public void setName(Drink name) {
    this.name = name;
  }

  public Double getPrice() {
    return price;
  }

  public void setPrice(Double price) {
    this.price = price;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  
  
}
