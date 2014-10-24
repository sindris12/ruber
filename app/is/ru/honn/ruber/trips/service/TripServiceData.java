package is.ru.honn.ruber.trips.service;

import is.ru.honn.ruber.domain.Trip;
import is.ru.honn.ruber.domain.TripStatus;
import is.ru.honn.ruber.trips.data.TripDataGateway;

import java.util.ArrayList;

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
    public Trip tripSignup(int uuid, long requestTime, int productID, double distance, long startTime, long endTime, TripStatus status) throws TripExistsException {

        Trip trip = new Trip(uuid, requestTime, productID, status, distance, startTime, endTime);
        int id = tripDataGateway.addTrip(trip);
        return trip;
    }

    @Override
    public ArrayList<Trip> getTrips(int uuid) {
        ArrayList<Trip> trips = tripDataGateway.getTripsByUserID(uuid);
        if (trips == null)
        {
            throw new TripNotFoundException("Trips not found for user: " + uuid);
        }
        return trips;
    }
}
