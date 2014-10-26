package is.ru.honn.ruber.drivers.data;

import is.ru.honn.ruber.domain.Driver;
import is.ru.honn.ruber.domain.Rating;
import is.ru.honn.ruber.drivers.service.DriverNotFoundException;
import is.ruframework.data.RuData;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by arnif on 10/25/14.
 */
public class DriverData extends RuData implements DriverDataGateway {

    @Override
    public List<Driver> getDrivers() {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(getDataSource());

        String queryString = "SELECT u.id, u.username, u.firstname, u.lastname, p.description, p.displayName, p.capacity, p.image, pr.currencyCode, pr.lowEstimate, pr.highEstimate, pr.surgeMultiplier, pr.displayName, d.id\n" +
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

        String queryString = "SELECT u.id, u.username, u.firstname, u.lastname, p.description, p.displayName, p.capacity, p.image, pr.currencyCode, pr.lowEstimate, pr.highEstimate, pr.surgeMultiplier, pr.displayName, d.id\n" +
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
        String queryString = "SELECT u.username, r.comment, r.rating, ur.username FROM ru_users u\n" +
                "JOIN ru_drivers d \n" +
                "  ON u.id = d.uuid\n" +
                "JOIN ru_ratings r\n" +
                "  ON r.driverID = d.id\n" +
                "  JOIN ru_users ur\n" +
                "  ON ur.id = r.uuid\n" +
                "WHERE u.username = '" + drivername +"'";

        try
        {
            List<Rating> r = jdbcTemplate.query(queryString, new RatingRowMapper());
            return r;
        }
        catch (EmptyResultDataAccessException erdaex)
        {
            throw new DriverNotFoundException("No comments found");
        }

    }

    @Override
    public int addRating(Rating rating) {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(getDataSource());
        //String statement = "INSERT INTO ru_ratings(uuid, driverID, rating, comment) VALUES (" + userId + ", " + driverID + ", " + rating + ",'" + comment  + "')";

        SimpleJdbcInsert insert =
                new SimpleJdbcInsert(getDataSource())
                        .withTableName("ru_ratings")
                        .usingGeneratedKeyColumns("id");

        Map<String, Object> parameters = new HashMap<String, Object>(6);
        parameters.put("uuid", rating.getUserID());
        parameters.put("driverID", rating.getDriverID());
        parameters.put("rating", rating.getRating());
        parameters.put("comment", rating.getComment());

        int returnKey;

        try
        {
            returnKey = insert.executeAndReturnKey(parameters).intValue();
        }
        catch(DataIntegrityViolationException divex)
        {
            throw new DriverNotFoundException("Comment already exists", divex);
        }

        return returnKey;
    }
}
