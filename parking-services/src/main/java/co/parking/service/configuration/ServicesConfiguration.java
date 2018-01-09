package co.parking.service.configuration;

import co.parking.dao.IParkingDao;
import co.parking.service.IvigilantService;
import co.parking.service.impl.VigilantServiceImpl;
import co.parking.utilities.configuration.UtilitiesConfiguration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EntityScan(basePackages="co.parking.model")
@EnableJpaRepositories(basePackages = {"co.parking.dao"})
@Import({UtilitiesConfiguration.class})
public class ServicesConfiguration {
  
  @Autowired
  private UtilitiesConfiguration utilitiesConfiguration;
  
  @Autowired
  private IParkingDao parkingDao;
  
  @Bean
  public IvigilantService vigilantServiceBean() {
    
    VigilantServiceImpl vigilanService = new VigilantServiceImpl();
  
    vigilanService.setCalculatePayment(utilitiesConfiguration.calculatorPaymentBean());
    vigilanService.setManageTime(utilitiesConfiguration.manageTimeBean());
    vigilanService.setValidateRules(utilitiesConfiguration.validatorRulesBean());
    vigilanService.setParkingDao(parkingDao);
    
    return vigilanService;
  }

}
