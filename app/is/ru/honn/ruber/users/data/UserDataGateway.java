package is.ru.honn.ruber.users.data;

import is.ru.honn.ruber.domain.Trip;
import is.ru.honn.ruber.domain.User;
import is.ruframework.data.RuDataAccess;

import java.util.ArrayList;

public interface UserDataGateway extends RuDataAccess
{
    public int addUser(User user);
    public User getUserByUsername(String username);
    public ArrayList<Trip> getAllTripsByUserID(int userID);
}