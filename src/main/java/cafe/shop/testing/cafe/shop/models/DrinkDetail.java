package cafe.shop.testing.cafe.shop.models;

import java.sql.Timestamp;

public class DrinkDetail {
  private Long id;
  private String name;
  private String img;
  private String desc;
  private Price price;
  private Timestamp lastUpdate;

  public DrinkDetail(){}

  public DrinkDetail(Long id, String name, String img, String desc, Price price, Timestamp lastUpdate) {
    this.id = id;
    this.name = name;
    this.img = img;
    this.desc = desc;
    this.price = price;
    this.lastUpdate = lastUpdate;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getImg() {
    return img;
  }

  public void setImg(String img) {
    this.img = img;
  }

  public String getDesc() {
    return desc;
  }

  public void setDesc(String desc) {
    this.desc = desc;
  }

  public Price getPrice() {
    return price;
  }

  public void setPrice(Price price) {
    this.price = price;
  }

  public Timestamp getLastUpdate() {
    return lastUpdate;
  }

  public void setLastUpdate(Timestamp lastUpdate) {
    this.lastUpdate = lastUpdate;
  };

  

}
