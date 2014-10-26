package is.ru.honn.ruber.domain;

/**
 * Created by arnif on 10/25/14.
 */
public class Rating {

    private int userID;
    private String username;
    private String drivername;
    private int driverID;
    private double rating;
    private String comment;

    public Rating(String username, String drivername, double rating, String comment) {
        this.username = username;
        this.drivername = drivername;
        this.rating = rating;
        this.comment = comment;
    }

    public Rating(int userID, int driverID, double rating, String comment) {
        this.userID = userID;
        this.driverID = driverID;
        this.rating = rating;
        this.comment = comment;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getDrivername() {
        return drivername;
    }

    public void setDrivername(String drivername) {
        this.drivername = drivername;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public int getDriverID() {
        return driverID;
    }

    public void setDriverID(int driverID) {
        this.driverID = driverID;
    }
}
