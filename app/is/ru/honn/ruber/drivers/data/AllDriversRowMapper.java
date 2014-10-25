package is.ru.honn.ruber.drivers.data;

import is.ru.honn.ruber.domain.Driver;
import is.ru.honn.ruber.domain.Price;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by arnif on 10/25/14.
 */
public class AllDriversRowMapper implements RowMapper<Driver> {
    @Override
    public Driver mapRow(ResultSet rs, int i) throws SQLException {
        //String userName, String firstName, String lastName, String description, String displayName, int capacity, String image, Price

        //String currencyCode, String displayName, int lowEstimate, int highEstimate, double surgeMultiplier)

        return new Driver(rs.getString(2),
                rs.getString(3),
                rs.getString(4),
                rs.getString(5),
                rs.getString(6),
                rs.getInt(7),
                rs.getString(8),
                new Price(rs.getString(9),
                        rs.getString(13),
                        rs.getInt(10),
                        rs.getInt(11),
                        rs.getDouble(12)));
    }
}
