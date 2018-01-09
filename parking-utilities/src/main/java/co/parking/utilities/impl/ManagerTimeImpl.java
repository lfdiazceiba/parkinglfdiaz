package co.parking.utilities.impl;

import co.parking.model.ParkingTime;
import co.parking.utilities.IManagerTime;

import java.util.Calendar;
import java.util.Date;

public class ManagerTimeImpl implements IManagerTime {

  @Override
  public Date currentDate() {

    return Calendar.getInstance().getTime();
  }

  @Override
  public ParkingTime calcRangeTime(Date initialDate, Date finalDate) {

    long dif =  finalDate.getTime() - initialDate.getTime();

    int difMinutes = (int) (dif / (60 * 1000)) % 60;
    int difHours =  (int)  (dif / (60 * 60 * 1000)) % 24;
    int difDays   = (int)  (dif / (24 * 60 * 60 * 1000));

    return new ParkingTime(difDays, difHours, difMinutes);
  }
}
