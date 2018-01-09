package co.parking.model;

public class ParkingTime {

  private int days;
  private int hours;
  private int minutes;

  public ParkingTime(int days, int hours, int minutes) {

    this.days = days;
    this.hours = hours;
    this.minutes = minutes;
  }

  public int getDays() {
    return days;
  }

  public void setDays(int days) {
    this.days = days;
  }

  public int getHours() {
    return hours;
  }

  public void setHours(int hours) {
    this.hours = hours;
  }

  public int getMinutes() {
    return minutes;
  }

  public void setMinutes(int minutes) {
    this.minutes = minutes;
  }

  @Override
  public boolean equals(Object obj) {

    if (obj == null) { 
      return false;
    }

    if (this.getClass() != obj.getClass()) {
      return false;
    }

    ParkingTime parkingTime = (ParkingTime) obj;

    return (this.days == parkingTime.days && this.hours == parkingTime.hours
        && this.minutes == parkingTime.minutes);
  }

  @Override
  public int hashCode() {
    int hash = 1;
    hash = hash * 3 + this.days;
    hash = hash * 5 + this.hours;
    hash = hash * 7 + this.minutes;
    return hash;
  }
}
