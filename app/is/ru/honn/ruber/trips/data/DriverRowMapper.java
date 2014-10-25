package is.ru.honn.ruber.trips.data;

import is.ru.honn.ruber.domain.Driver;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by arnif on 10/25/14.
 */
public class DriverRowMapper implements RowMapper<Driver> {
    @Override
    public Driver mapRow(ResultSet rs, int i) throws SQLException {
        return new Driver(
                rs.getString(1),
                rs.getString(2),
                rs.getString(3),
                rs.getString(4),
                rs.getString(5),
                rs.getInt(6),
                rs.getString(7));
    }
}
