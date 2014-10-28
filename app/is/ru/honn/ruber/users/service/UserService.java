package is.ru.honn.ruber.users.service;

import is.ru.honn.ruber.domain.User;

import java.util.Date;

public interface UserService
{
    /**
     * add user to the database
     * @param username of the user
     * @param firstName of the user
     * @param lastName of the user
     * @param password for the user
     * @param email from the user
     * @param registered current date
     * @return the user to be added
     * @throws UsernameExistsException if the user exsits
     */
  public User userSignup(String username, String firstName, String lastName,
                         String password, String email, Date registered)
      throws UsernameExistsException;

    /**
     * get user
     * @param username of the user requested
     * @return user requested
     * @throws UserNotFoundException if user isnt found
     */
  public User getUser(String username) throws UserNotFoundException;

}
