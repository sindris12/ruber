package is.ru.honn.ruber.drivers.data;

import is.ru.honn.ruber.domain.Driver;
import is.ru.honn.ruber.domain.Rating;
import is.ru.honn.ruber.drivers.service.DriverNotFoundException;
import is.ruframework.data.RuData;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

/**
 * Created by arnif on 10/25/14.
 */
public class DriverData extends RuData implements DriverDataGateway {

    @Override
    public List<Driver> getDrivers() {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(getDataSource());

        String queryString = "SELECT u.id, u.username, u.firstname, u.lastname, p.description, p.displayName, p.capacity, p.image, pr.currencyCode, pr.lowEstimate, pr.highEstimate, pr.surgeMultiplier, pr.displayName\n" +
                "FROM ru_users u\n" +
                "  JOIN ru_drivers d\n" +
                "    ON d.uuid = u.id\n" +
                "  JOIN ru_products p\n" +
                "    ON p.id = d.productID\n" +
                "JOIN ru_prices pr\n" +
                "    ON pr.id = d.priceID\n";

        try
        {
            List<Driver> d = jdbcTemplate.query(queryString, new AllDriversRowMapper());
            return d;
        }
        catch (EmptyResultDataAccessException erdaex)
        {
            throw new DriverNotFoundException("No drivers found");
        }
    }

    @Override
    public Driver getDriver(String username) {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(getDataSource());

        String queryString = "SELECT u.id, u.username, u.firstname, u.lastname, p.description, p.displayName, p.capacity, p.image, pr.currencyCode, pr.lowEstimate, pr.highEstimate, pr.surgeMultiplier, pr.displayName\n" +
                "FROM ru_users u\n" +
                "  JOIN ru_drivers d\n" +
                "    ON d.uuid = u.id\n" +
                "  JOIN ru_products p\n" +
                "    ON p.id = d.productID\n" +
                "JOIN ru_prices pr\n" +
                "    ON pr.id = d.priceID\n" +
                "  WHERE u.username = '" + username +"';\n";
        try
        {
            Driver d = jdbcTemplate.queryForObject(queryString, new AllDriversRowMapper());
            return d;
        }
        catch (EmptyResultDataAccessException erdaex)
        {
            throw new DriverNotFoundException("No drivers found");
        }

    }

    @Override
    public List<Rating> getRatingForDriver(String drivername) {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(getDataSource());



        return null;
    }
}
