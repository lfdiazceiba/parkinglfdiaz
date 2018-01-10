package co.parking.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import co.parking.enumeration.TypeVehicle;

@Entity
public class Parking implements Serializable {

  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy=GenerationType.AUTO)
  private long      id;
  private Date      entryDate;
  private Date      exitDate;
  private int       payment;
  private String    licensePlateVehicle;
  private int       displacementVehicle;
  private TypeVehicle typeVehicle;

  public Parking(Date entryDate, String licensePlateVehicle, int displacementVehicle,
      TypeVehicle typeVehicle) {

    this.entryDate           = entryDate;
    this.licensePlateVehicle = licensePlateVehicle;
    this.displacementVehicle = displacementVehicle;
    this.typeVehicle         = typeVehicle;
  }
  
  public Parking() {

  }

  public String getLicensePlateVehicle() {
    return licensePlateVehicle;
  }

  public void setLicensePlateVehicle(String licensePlateVehicle) {
    this.licensePlateVehicle = licensePlateVehicle;
  }

  public int getDisplacementVehicle() {
    return displacementVehicle;
  }

  public void setDisplacementVehicle(int displacementVehicle) {
    this.displacementVehicle = displacementVehicle;
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public Date getEntryDate() {
    return entryDate;
  }

  public void setEntryDate(Date entryDate) {
    this.entryDate = entryDate;
  }

  public Date getExitDate() {
    return exitDate;
  }

  public void setExitDate(Date exitDate) {
    this.exitDate = exitDate;
  }

  public int getPayment() {
    return payment;
  }

  public void setPayment(int payment) {
    this.payment = payment;
  }

  public TypeVehicle getTypeVehicle() {
    return typeVehicle;
  }

  public void setTypeVehicle(TypeVehicle typeVehicle) {
    this.typeVehicle = typeVehicle;
  }

  @Override
  public boolean equals(Object obj) {
    if (obj == null) { 
      return false;
    }

    if (this.getClass() != obj.getClass()) {
      return false;
    }

    Parking parking = (Parking) obj;

    return (this.entryDate == parking.entryDate
        && this.displacementVehicle == parking.displacementVehicle
        && this.licensePlateVehicle == parking.licensePlateVehicle
        && this.typeVehicle == parking.typeVehicle);
  }
  
  @Override
  public int hashCode() {
    return Objects.hash(this.id, this.displacementVehicle, this.entryDate, this.licensePlateVehicle,
        this.typeVehicle, this.exitDate, this.payment);
  }
}
