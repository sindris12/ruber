package is.ru.honn.ruber.drivers.service;

import is.ru.honn.ruber.domain.Driver;
import is.ru.honn.ruber.domain.Rating;

import java.util.List;

/**
 * Created by arnif on 10/25/14.
 */
public interface DriverService {

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
     * @return the rating to be added to the databse
     */
    public Rating addComment(int userId, int driverID, int rating, String comment);
}
