package fi.vamk.e1800950.northwind;

import java.sql.*;
import javax.persistence.*;
import lombok.Data;

@Data
@Entity(name = "fi.vamk.e1800950.northwind.OrdersTaxStatus")
@Table(name = "orders_tax_status")
public class OrdersTaxStatus {

  @Id
  @Column(name = "\"id\"", nullable = false)
  private Byte id;
  @Column(name = "\"tax_status_name\"", nullable = false)
  private String taxStatusName;
}