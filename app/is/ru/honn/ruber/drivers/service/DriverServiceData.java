package is.ru.honn.ruber.drivers.service;

import is.ru.honn.ruber.domain.Driver;
import is.ru.honn.ruber.domain.Rating;
import is.ru.honn.ruber.drivers.data.DriverDataGateway;

import java.util.List;

/**
 * Created by arnif on 10/25/14.
 */
public class DriverServiceData implements DriverService {

    private DriverDataGateway driverDataGateway;

    public DriverServiceData(DriverDataGateway driverDataGateway) {
        this.driverDataGateway = driverDataGateway;
    }

    @Override
    public List<Driver> getDrivers() {
        List<Driver> drivers = driverDataGateway.getDrivers();

        if (drivers == null) {
            throw new DriverNotFoundException("No drivers found");
        }
        return drivers;
    }

    @Override
    public Driver getDriver(String username) {
        Driver driver = driverDataGateway.getDriver(username);

        if (driver == null) {
            throw new DriverNotFoundException("No drivers with username " + username);
        }
        return driver;
    }

    @Override
    public List<Rating> getRatingForDriver(String drivername) {
        List<Rating> ratings = driverDataGateway.getRatingForDriver(drivername);

        if (ratings == null) {
            throw new DriverNotFoundException("No ratings found for driver " + drivername);
        }
        return ratings;
    }

    @Override
    public Rating addComment(int userId, int driverID, int rating, String comment) {
        Rating r = new Rating(userId, driverID, rating, comment);
        driverDataGateway.addRating(r);
        return r;
    }
}
