package is.ru.honn.ruber.trips.data;

import is.ru.honn.ruber.domain.Driver;
import is.ru.honn.ruber.domain.Trip;
import is.ruframework.data.RuDataAccess;

/**
 * Created by arnif on 10/24/14.
 */
public interface TripDataGateway extends RuDataAccess {

    public int addTrip(Trip trip);
    public java.util.List<Trip> getTripsByUserID(int userID);
    public Driver getDriverOfProduct(int productID);
}
