package cafe.shop.testing.cafe.shop.models;

// this class is created only to use with drinkDetail class
public class Price {
  private Double hotSmall, hotMedium, hotLarge;
  private Double icedSmall, icedMedium, icedLarge;
  private Double freppeSmall, freppeMedium, freppeLarge;

  public Price(){};

  public Price(Double hotSmall, Double hotMedium, Double hotLarge, Double icedSmall, Double icedMedium,
      Double icedLarge, Double freppeSmall, Double freppeMedium, Double freppeLarge) {
    this.hotSmall = hotSmall;
    this.hotMedium = hotMedium;
    this.hotLarge = hotLarge;
    this.icedSmall = icedSmall;
    this.icedMedium = icedMedium;
    this.icedLarge = icedLarge;
    this.freppeSmall = freppeSmall;
    this.freppeMedium = freppeMedium;
    this.freppeLarge = freppeLarge;
  }

  public Double getHotSmall() {
    return hotSmall;
  }

  public void setHotSmall(Double hotSmall) {
    this.hotSmall = hotSmall;
  }

  public Double getHotMedium() {
    return hotMedium;
  }

  public void setHotMedium(Double hotMedium) {
    this.hotMedium = hotMedium;
  }

  public Double getHotLarge() {
    return hotLarge;
  }

  public void setHotLarge(Double hotLarge) {
    this.hotLarge = hotLarge;
  }

  public Double getIcedSmall() {
    return icedSmall;
  }

  public void setIcedSmall(Double icedSmall) {
    this.icedSmall = icedSmall;
  }

  public Double getIcedMedium() {
    return icedMedium;
  }

  public void setIcedMedium(Double icedMedium) {
    this.icedMedium = icedMedium;
  }

  public Double getIcedLarge() {
    return icedLarge;
  }

  public void setIcedLarge(Double icedLarge) {
    this.icedLarge = icedLarge;
  }

  public Double getFreppeSmall() {
    return freppeSmall;
  }

  public void setFreppeSmall(Double freppeSmall) {
    this.freppeSmall = freppeSmall;
  }

  public Double getFreppeMedium() {
    return freppeMedium;
  }

  public void setFreppeMedium(Double freppeMedium) {
    this.freppeMedium = freppeMedium;
  }

  public Double getFreppeLarge() {
    return freppeLarge;
  }

  public void setFreppeLarge(Double freppeLarge) {
    this.freppeLarge = freppeLarge;
  }

  
}
