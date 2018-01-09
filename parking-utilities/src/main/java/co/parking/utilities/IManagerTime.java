package co.parking.utilities;

import co.parking.model.ParkingTime;

import java.util.Date;

public interface IManagerTime {

  public Date currentDate();

  public ParkingTime calcRangeTime(Date initialDate, Date finalDate);
}
