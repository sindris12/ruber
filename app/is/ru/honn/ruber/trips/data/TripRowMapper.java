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
                rs.getLong(3),   // request time
                rs.getInt(4),   // product id
                TripStatus.valueOf(rs.getString(8).toUpperCase()),   // status
                rs.getDouble(5),   // distance
                rs.getLong(6),   // start time
                rs.getLong(7),      // end time
                rs.getString(10),
                rs.getString(9)
        );
    }
}
