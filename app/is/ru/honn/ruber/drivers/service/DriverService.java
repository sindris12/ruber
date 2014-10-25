package is.ru.honn.ruber.drivers.service;

import is.ru.honn.ruber.domain.Driver;
import is.ru.honn.ruber.domain.Rating;

import java.util.List;

/**
 * Created by arnif on 10/25/14.
 */
public interface DriverService {

    public List<Driver> getDrivers();
    public Driver getDriver(String username);
    public List<Rating> getRatingForDriver(String drivername);
}
