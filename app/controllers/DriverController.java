package controllers;

import is.ru.honn.ruber.domain.Driver;
import is.ru.honn.ruber.drivers.service.DriverService;
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

        driverService.getRatingForDriver(drivername);
        return null;
    }
}
