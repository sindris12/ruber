package is.ru.honn.ruber.trips.data;

import is.ru.honn.ruber.domain.Driver;
import is.ru.honn.ruber.domain.Trip;
import is.ruframework.data.RuDataAccess;

import java.util.List;

/**
 * Created by arnif on 10/24/14.
 */
public interface TripDataGateway extends RuDataAccess {

    /**
     * add a trip
     * @param trip trip to be added
     * @return id of the trip added to the database
     */
    public int addTrip(Trip trip);

    /**
     * get list of trips from a user
     * @param userID id of the user
     * @return list of trips
     */
    public List<Trip> getTripsByUserID(int userID);

    /**
     * get a single trip
     * @param tripID id of the trip
     * @return the trip requested
     */
    public Trip getTripByID(int tripID);

    /**
     * get a driver of a product
     * @param productID id of the product (car)
     * @return the driver
     */
    public Driver getDriverOfProduct(int productID);
}
