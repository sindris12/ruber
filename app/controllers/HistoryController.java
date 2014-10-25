package controllers;

import is.ru.honn.ruber.domain.Driver;
import is.ru.honn.ruber.domain.Trip;
import is.ru.honn.ruber.domain.User;
import is.ru.honn.ruber.trips.service.TripService;
import is.ru.honn.ruber.users.service.UserService;
import play.mvc.Result;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


/**
 * Created by arnif on 10/25/14.
 */
public class HistoryController extends UserController {


    public static Result main(String userName) {
        UserService service = (UserService) ctx.getBean("userService");
        TripService tripService = (TripService) ctx.getBean("tripService");
        User user = service.getUser(userName);

        List<Trip> trips = tripService.getTrips(user.getId());

        //return ok(Json.toJson(trips));

        return ok(views.html.history.render(trips));
    }

    public static String getDriver(int productID) {
        TripService tripService = (TripService) ctx.getBean("tripService");

        Driver driverForProduct = tripService.getDriverForProduct(productID);

        return driverForProduct.getFirstName() + " " + driverForProduct.getLastName();

    }

    public static String getTimeFromUnix(long timestamp) {
        SimpleDateFormat inFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        Date d = new Date(timestamp * 1000);
        return inFormat.format(d).toString();
    }

    public static String getTime(long time) {
        long t = time / 60;

        if (t > 60) {
            return t / 60 + " hours";
        } else {
            return t + " minutes";
        }
    }

}
