package co.parking;

import co.parking.api.exceptionmapper.ParkingExceptionMapper;
import co.parking.api.impl.ParkingApiImpl;

import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

@Component
@ApplicationPath("/")
public class ServerConfiguration extends ResourceConfig {

  public ServerConfiguration() {
    register(ParkingApiImpl.class);
    register(ParkingExceptionMapper.class);
  }

}
