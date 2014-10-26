package is.ru.honn.ruber.trips.service;

import is.ru.honn.ruber.domain.Driver;
import is.ru.honn.ruber.domain.Trip;
import is.ru.honn.ruber.domain.TripStatus;
import is.ru.honn.ruber.trips.data.TripDataGateway;

import java.util.List;


/**
 * Created by arnif on 10/24/14.
 */
public class TripServiceData implements TripService {

    private TripDataGateway tripDataGateway;

    public TripServiceData(TripDataGateway tripDataGateway)
    {
        this.tripDataGateway = tripDataGateway;
    }

    @Override
    public Trip tripSignup(int uuid, long requestTime, int productID, double distance, long startTime, long endTime, TripStatus status, String latitude, String longitude, String endLatitude, String endLongitude) throws TripExistsException {

        Trip trip = new Trip(uuid, requestTime, productID, status, distance, startTime, endTime, latitude, longitude, endLatitude, endLongitude);
        int id = tripDataGateway.addTrip(trip);
        return trip;
    }

    @Override
    public List<Trip> getTrips(int uuid) {
        List<Trip> trips = tripDataGateway.getTripsByUserID(uuid);
        if (trips == null)
        {
            throw new TripNotFoundException("Trips not found for user: " + uuid);
        }
        return trips;
    }

    @Override
    public Trip getTripByID(int tripID) {
        Trip trip = tripDataGateway.getTripByID(tripID);

        if (trip == null) {
            throw new TripNotFoundException("Trip not found with id " + tripID);
        }
        return trip;
    }

    @Override
    public Driver getDriverForProduct(int productID) {
        Driver driverOfProduct = tripDataGateway.getDriverOfProduct(productID);

        if (driverOfProduct == null) {
            throw new TripNotFoundException("No driver found for product " + productID);
        }

        return driverOfProduct;
    }
}
