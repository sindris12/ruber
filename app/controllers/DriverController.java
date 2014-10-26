package controllers;

import com.fasterxml.jackson.databind.JsonNode;
import is.ru.honn.ruber.domain.Driver;
import is.ru.honn.ruber.domain.Rating;
import is.ru.honn.ruber.domain.User;
import is.ru.honn.ruber.drivers.service.DriverService;
import is.ru.honn.ruber.users.service.UserService;
import play.libs.Json;
import play.mvc.BodyParser;
import play.mvc.Result;

import java.util.List;

/**
 * Created by arnif on 10/25/14.
 */
public class DriverController extends UserController {

    public static Result getAllDrivers() {
        DriverService driverService = (DriverService) ctx.getBean("driverService");

        List<Driver> drivers = driverService.getDrivers();
        return ok(views.html.drivers.render(drivers));
    }

    public static Result getDriver(String username) {
        DriverService driverService = (DriverService) ctx.getBean("driverService");

        Driver d = driverService.getDriver(username);
        return ok(views.html.driver.render(d));
    }

    public static Result getComments(String drivername) {
        DriverService driverService = (DriverService) ctx.getBean("driverService");

        List<Rating> ratingForDriver = driverService.getRatingForDriver(drivername);
        return ok(Json.toJson(ratingForDriver));
    }

    @BodyParser.Of(BodyParser.Json.class)
    public static Result submitComment() {
        JsonNode json = request().body().asJson();
        String driverusername = json.findPath("driver").textValue();
        String comment = json.findPath("comment").textValue();
        String rating = json.findPath("rating").textValue();
        String username = session().get("username");

        if (comment == null) {
            return badRequest("Missing comment");
        }

        DriverService driverService = (DriverService) ctx.getBean("driverService");
        Driver d = driverService.getDriver(driverusername);
        UserService userService = (UserService) ctx.getBean("userService");
        User user = userService.getUser(username);

        Rating rating1 = driverService.addComment(user.getId(), d.getId(), Integer.parseInt(rating), comment);

        if (rating1 == null) {
            return badRequest("Something went wrong");
        }

        return status(200, "OK");
    }
}
