import java.io.IOException;

public class WeatherApplication {
    public static void main(String[] args) throws IOException {
        WeatherData weatherData = new WeatherData();
        System.out.println(weatherData.weatherRootData().get(1).getTemperature().UnitType);
        System.out.println(weatherData.weatherRootData().get(0).getDateTime());
    }
}
