package is.ru.honn.ruber.trips.service;

import is.ru.honn.ruber.domain.Driver;
import is.ru.honn.ruber.domain.Trip;
import is.ru.honn.ruber.domain.TripStatus;

import java.util.List;

/**
 * Created by arnif on 10/24/14.
 */
public interface TripService {

    /**
     * add trip to the database (see TripImportProcess for implementation and usage)
     * @param uuid id of the trip
     * @param requestTime when the trip was requested
     * @param productID id of the product (car)
     * @param distance how far the trip was
     * @param startTime when the trip started
     * @param endTime when the trip ended
     * @param status of the trip
     * @param latitude starting latitude
     * @param longitude starting longitude
     * @param endLatitude end latitude
     * @param endLongitude end longitude
     * @return the trip to be added to the database
     * @throws TripExistsException if trip does exists
     */
    public Trip tripSignup(int uuid, long requestTime, int productID, double distance, long startTime,
                           long endTime, TripStatus status, String latitude, String longitude, String endLatitude, String endLongitude)
            throws TripExistsException;

    /**
     * get list of all trips for a user
     * @param uuid id of the user
     * @return list of trips
     */
    public List<Trip> getTrips(int uuid);

    /**
     * get a trip for a user
     * @param tripID id of the trip
     * @return the trip requested
     */
    public Trip getTripByID(int tripID);

    /**
     * get a driver of a product
     * @param productID id of the product (car)
     * @return the driver of the product
     */
    public Driver getDriverForProduct(int productID);
}
