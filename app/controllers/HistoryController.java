package controllers;

import is.ru.honn.ruber.domain.Driver;
import is.ru.honn.ruber.domain.Trip;
import is.ru.honn.ruber.domain.User;
import is.ru.honn.ruber.trips.service.TripService;
import is.ru.honn.ruber.users.service.UserService;
import play.mvc.Result;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


/**
 * Created by arnif on 10/25/14.
 */
public class HistoryController extends UserController {


    /**
     * get list of all trips for a user
     * @param userName of the user
     * @return list of trips
     */
    public static Result main(String userName) {
        UserService service = (UserService) ctx.getBean("userService");
        TripService tripService = (TripService) ctx.getBean("tripService");
        User user = service.getUser(userName);

        List<Trip> trips = tripService.getTrips(user.getId());

        //return ok(Json.toJson(trips));

        return ok(views.html.history.render(trips));
    }

    /**
     * get details for one trip
     * @param tripID the id of the rip
     * @return the trip requested
     */
    public static Result getTripDetails(long tripID) {
        TripService tripService = (TripService) ctx.getBean("tripService");

        Trip t = tripService.getTripByID(new BigDecimal(tripID).intValueExact());
        return ok(views.html.trip.render(t));
    }

    /**
     * get driver of a product
     * @param productID id of the product (car)
     * @return firstname and lastname of the driver as a string
     */
    public static String getDriver(int productID) {
        TripService tripService = (TripService) ctx.getBean("tripService");

        Driver driverForProduct = tripService.getDriverForProduct(productID);

        return driverForProduct.getFirstName() + " " + driverForProduct.getLastName();

    }

    /**
     * get time for unix timestamp to render in the view
     * @param timestamp unix representation of the time
     * @return a beautiful string containing the date
     */
    public static String getTimeFromUnix(long timestamp) {
        SimpleDateFormat inFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        Date d = new Date(timestamp * 1000);
        return inFormat.format(d).toString();
    }

    /**
     * get the time in either hours or minutes
     * @param time unix representation of the time
     * @return string containing the correct format of the time
     */
    public static String getTime(long time) {
        long t = time / 60;

        if (t > 60) {
            return t / 60 + " hours";
        } else {
            return t + " minutes";
        }
    }

}
