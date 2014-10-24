package is.ru.honn.ruber.trips.data;

import is.ru.honn.ruber.domain.Trip;
import is.ru.honn.ruber.trips.service.TripExistsException;
import is.ru.honn.ruber.trips.service.TripNotFoundException;
import is.ruframework.data.RuData;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by arnif on 10/24/14.
 */
public class TripData extends RuData implements TripDataGateway {

    @Override
    public int addTrip(Trip trip) {

        SimpleJdbcInsert insert =
                new SimpleJdbcInsert(getDataSource())
                        .withTableName("ru_trips")
                        .usingGeneratedKeyColumns("id");


        Map<String, Object> parameters = new HashMap<String, Object>(6);
        parameters.put("uuid", trip.getId());
        parameters.put("requestTime", trip.getRequestTime());
        parameters.put("productID", trip.getProductId());
        parameters.put("distance", trip.getDistance());
        parameters.put("startTime", trip.getStartTime());
        parameters.put("endTime", trip.getEndTime());
        parameters.put("status", trip.getStatus().toString());

        int returnKey;

        try
        {
            returnKey = insert.executeAndReturnKey(parameters).intValue();
        }
        catch(DataIntegrityViolationException divex)
        {
            throw new TripExistsException("User " + trip.getId() + " already exits", divex);
        }

        return returnKey;
    }

    @Override
     public ArrayList<Trip> getTripsByUserID(int userID) {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(getDataSource());

        try
        {
            ArrayList<Trip> t = jdbcTemplate.query(
                    "select * from ru_trips where productID = '" + userID + "'", new TripRowMapper());
            return t;
        }
        catch (EmptyResultDataAccessException erdaex)
        {
            throw new TripNotFoundException("No trip found for user with userid: " + userID);
        }

        return null;
    }
}
