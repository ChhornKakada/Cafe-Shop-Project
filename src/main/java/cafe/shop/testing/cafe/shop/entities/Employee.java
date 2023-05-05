package cafe.shop.testing.cafe.shop.entities;

import java.sql.Date;
import java.sql.Timestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "employee")
public class Employee {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(nullable = false)
  private String name;

  @Column(nullable = false, unique = true)
  private String username;

  private Date dob;

  @Column(nullable = false)
  private String password;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "role_id")
  private Role role;
  
  @Column(name = "hired_date")
  private Date hiredDate;

  private String sex;

  @Column(name = "last_login")
  private Timestamp lastLogin;

  @Lob
  @Column(nullable = false, length = 4096)
  private String img;


  // constructor

  public Employee() {}

  public Employee(String name, String username, Date dob, String password, Role role, Date hiredDate, String sex,
      Timestamp lastLogin, String img) {
    this.name = name;
    this.username = username;
    this.dob = dob;
    this.password = password;
    this.role = role;
    this.hiredDate = hiredDate;
    this.sex = sex;
    this.lastLogin = lastLogin;
    this.img = img;
  }

  // getter and setter

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

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public Date getDob() {
    return dob;
  }

  public void setDob(Date dob) {
    this.dob = dob;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public Role getRole() {
    return role;
  }

  public void setRole(Role role) {
    this.role = role;
  }

  public Date getHiredDate() {
    return hiredDate;
  }

  public void setHiredDate(Date hiredDate) {
    this.hiredDate = hiredDate;
  }

  public String getSex() {
    return sex;
  }

  public void setSex(String sex) {
    this.sex = sex;
  }

  public Timestamp getLastLogin() {
    return lastLogin;
  }

  public void setLastLogin(Timestamp lastLogin) {
    this.lastLogin = lastLogin;
  }

  public String getImg() {
    return img;
  }

  public void setImg(String img) {
    this.img = img;
  }

  
  

}
