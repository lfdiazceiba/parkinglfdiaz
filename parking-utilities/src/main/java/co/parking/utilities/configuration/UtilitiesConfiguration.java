package co.parking.utilities.configuration;

import co.parking.utilities.ICalculatorPayment;
import co.parking.utilities.IManagerTime;
import co.parking.utilities.IValidatorRules;
import co.parking.utilities.impl.CalculatorPaymentImpl;
import co.parking.utilities.impl.ManagerTimeImpl;
import co.parking.utilities.impl.ValidatorRulesImpl;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UtilitiesConfiguration {

  @Bean
  public ICalculatorPayment calculatorPaymentBean() {
    return  new CalculatorPaymentImpl();
  }
  
  @Bean
  public IManagerTime manageTimeBean() {
    return new ManagerTimeImpl();
  }
  
  @Bean
  public IValidatorRules validatorRulesBean() {
    return new ValidatorRulesImpl();
  }

}
