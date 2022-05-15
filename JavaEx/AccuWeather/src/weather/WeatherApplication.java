package weather;

import weather.Controller.Controller;

import java.io.IOException;
import java.sql.SQLException;

public class WeatherApplication {
    public static void main(String[] args) throws IOException, SQLException, ClassNotFoundException {
        Controller controller = new Controller();
        controller.addData();

    }


}
