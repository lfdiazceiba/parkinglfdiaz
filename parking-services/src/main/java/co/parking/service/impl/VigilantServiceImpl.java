package co.parking.service.impl;

import co.parking.dao.IParkingDao;
import co.parking.model.Parking;
import co.parking.model.ParkingTime;
import co.parking.service.IvigilantService;
import co.parking.utilities.ICalculatorPayment;
import co.parking.utilities.IManagerTime;
import co.parking.utilities.IValidatorRules;

import java.util.List;

public class VigilantServiceImpl implements IvigilantService {

  private IParkingDao parkingDao;

  private ICalculatorPayment calculatePayment;

  private IManagerTime manageTime;

  private IValidatorRules validateRules;

  @Override
  public void lendParking(Parking parking) {

    validateRules.verifyParkingData(parking);
    
    boolean isParked =
        parkingDao.existsByLicensePlateVehicleAndExitDate(parking.getLicensePlateVehicle(), null);
    
    validateRules.verifyLicensePlate(parking.getLicensePlateVehicle(), manageTime.currentDate(),
        isParked);
    
    int numberParkedVehicle = (int) parkingDao.countByTypeVehicleAndExitDate(parking.getTypeVehicle(), null);
    validateRules.verifyParkingAvailable(parking.getTypeVehicle(), numberParkedVehicle);
    parkingDao.save(parking);
  }

  @Override
  public Parking billParkedVehicle(String licensePlate) {

    Parking parking = parkingDao.findFirstByLicensePlateVehicleAndExitDate(licensePlate, null);
    validateRules.verifyParkingData(parking);
    parking.setExitDate(manageTime.currentDate());
    
    ParkingTime parkingTime =
        manageTime.calcRangeTime(parking.getEntryDate(), parking.getExitDate());
    
    int payment = calculatePayment.calcPaymentVehicle(parking.getTypeVehicle(),
        parking.getDisplacementVehicle(), parkingTime);
    
    parking.setPayment(payment);
    parkingDao.save(parking);
    return parking;
  }

  @Override
  public List<Parking> checkParkedVehicle() {
    return parkingDao.findByExitDate(null);
  }

  public void setParkingDao(IParkingDao parkingDao) {
    this.parkingDao = parkingDao;
  }

  public void setCalculatePayment(ICalculatorPayment calculatePayment) {
    this.calculatePayment = calculatePayment;
  }

  public void setManageTime(IManagerTime manageTime) {
    this.manageTime = manageTime;
  }

  public void setValidateRules(IValidatorRules validateRules) {
    this.validateRules = validateRules;
  }
}
