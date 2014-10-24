package is.ru.honn.ruber.trips.data;

import is.ru.honn.ruber.domain.Trip;
import is.ru.honn.ruber.domain.TripStatus;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by arnif on 10/24/14.
 */
public class TripRowMapper implements RowMapper<Trip> {

    public Trip mapRow(ResultSet rs, int rowNum) throws SQLException
    {
        return  new Trip(rs.getInt(1),      // id
                rs.getLong(2),   // request time
                rs.getInt(3),   // product id
                TripStatus.COMPLETED,   // status
                rs.getDouble(5),   // distance
                rs.getLong(6),   // start time
                rs.getLong(7)      // end time
        );
    }
}
