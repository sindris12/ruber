package is.ru.honn.ruber.trips.data;

import is.ru.honn.ruber.domain.Trip;
import is.ruframework.data.RuDataAccess;

import java.util.ArrayList;

/**
 * Created by arnif on 10/24/14.
 */
public interface TripDataGateway extends RuDataAccess {

    public int addTrip(Trip trip);
    public ArrayList<Trip> getTripsByUserID(int userID);
}
