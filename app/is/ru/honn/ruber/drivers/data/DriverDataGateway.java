package is.ru.honn.ruber.drivers.data;

import is.ru.honn.ruber.domain.Driver;
import is.ru.honn.ruber.domain.Rating;

import java.util.List;

/**
 * Created by arnif on 10/25/14.
 */
public interface DriverDataGateway {

    /**
     * get list of all drivers
     * @return list of all drivers
     */
    public List<Driver> getDrivers();

    /**
     * get one driver
     * @param username of the driver
     * @return the driver requested
     */
    public Driver getDriver(String username);

    /**
     * get a list of ratings for a driver
     * @param drivername username of the driver
     * @return list of ratings
     */
    public List<Rating> getRatingForDriver(String drivername);

    /**
     * add rating to a driver
     * @param rating object
     * @return id of the rating added to the database
     */
    public int addRating(Rating rating);
}
