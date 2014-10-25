package is.ru.honn.ruber.trips.service;

import is.ru.honn.ruber.domain.Trip;
import is.ru.honn.ruber.domain.TripStatus;

import java.util.List;

/**
 * Created by arnif on 10/24/14.
 */
public interface TripService {

    public Trip tripSignup(int uuid, long requestTime, int productID, double distance, long startTime,
                           long endTime, TripStatus status)
            throws TripExistsException;

    public List<Trip> getTrips(int uuid);
}
