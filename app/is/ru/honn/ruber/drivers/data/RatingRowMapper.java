package is.ru.honn.ruber.drivers.data;

import is.ru.honn.ruber.domain.Rating;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by arnif on 10/26/14.
 */
public class RatingRowMapper implements RowMapper<Rating> {
    @Override
    public Rating mapRow(ResultSet rs, int i) throws SQLException {
        return new Rating(rs.getString(4), rs.getString(1), rs.getDouble(3), rs.getString(2));
    }
}
