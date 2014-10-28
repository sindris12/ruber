package is.ru.honn.ruber.users.data;

import is.ru.honn.ruber.domain.User;
import is.ruframework.data.RuDataAccess;

public interface UserDataGateway extends RuDataAccess
{
    /**
     * add user to the database
     * @param user to be added
     * @return id of the user added
     */
    public int addUser(User user);

    /**
     * get user by username
     * @param username of the user
     * @return user
     */
    public User getUserByUsername(String username);
}