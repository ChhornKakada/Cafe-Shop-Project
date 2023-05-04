package cafe.shop.testing.cafe.shop.entities;

import java.sql.Date;
import java.sql.Timestamp;

// import org.mindrot.jbcrypt.BCrypt;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity // This tells Hibernate to make a table out of this class
@Table(name = "users")
public class Employee {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String name;

  @Column(nullable = false, unique = true)
  private String username;

  private String password;

  private Date dob;

  private String sex;
  
  @OneToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "role_id")
  private Role role;

  @Lob
  @Column(nullable = false, length = 4096)
  private String image;

  private Date hired_date;
  private Timestamp last_login;

  public Employee() {}

  public Employee(String name, String username, String password, Date dob, String sex, Role role, String image,
      Date hired_date, Timestamp last_login) {
    this.name = name;
    this.username = username;
    this.password = password;
    this.dob = dob;
    this.sex = sex;
    this.role = role;
    this.image = image;
    this.hired_date = hired_date;
    this.last_login = last_login;
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

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public Date getDob() {
    return dob;
  }

  public void setDob(Date dob) {
    this.dob = dob;
  }

  public String getSex() {
    return sex;
  }

  public void setSex(String sex) {
    this.sex = sex;
  }

  public Role getRole() {
    return role;
  }

  public void setRole(Role role) {
    this.role = role;
  }

  public String getImage() {
    return image;
  }

  public void setImage(String image) {
    this.image = image;
  }

  public Date getHired_date() {
    return hired_date;
  }

  public void setHired_date(Date hired_date) {
    this.hired_date = hired_date;
  }

  public Timestamp getLast_login() {
    return last_login;
  }

  public void setLast_login(Timestamp last_login) {
    this.last_login = last_login;
  }

  

}