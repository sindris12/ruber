package is.ru.honn.ruber.drivers.data;

import is.ru.honn.ruber.domain.Driver;
import is.ru.honn.ruber.domain.Rating;

import java.util.List;

/**
 * Created by arnif on 10/25/14.
 */
public interface DriverDataGateway {

    public List<Driver> getDrivers();
    public Driver getDriver(String username);
    public List<Rating> getRatingForDriver(String drivername);
}
