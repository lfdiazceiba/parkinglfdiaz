package co.parking.api.exceptionmapper;

import co.parking.exception.ParkingException;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class ParkingExceptionMapper implements ExceptionMapper<ParkingException> {

  @Override
  public Response toResponse(ParkingException exception) {
  
    return Response.status(400).entity(exception.getMessage())
        .type("text/plain").build();
  }
}
