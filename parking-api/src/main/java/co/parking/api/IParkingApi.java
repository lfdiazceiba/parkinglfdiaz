package co.parking.api;

import co.parking.model.Parking;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@Path("/parking")
public interface IParkingApi {

  @GET
  @Produces("application/json")
  @Path("/all")
  public List<Parking> getParkings();

  @POST
  @Consumes("application/json")
  @Path("/register")
  public void registerParking(Parking parking);

  @PUT
  @Produces("application/json")
  @Path("/bill")
  public Parking billParking(String licensePlate);
}
