package jdbcapp.weatherApp;

import java.io.IOException;


public class WeatherApplication {
    public static void main(String[] args) throws IOException {
        WeatherData weatherData = new WeatherData("hanoi","vietnam");
        System.out.println(weatherData.weatherRootData().getCoord());
        System.out.println(weatherData.weatherRootData().getCoord().lat);


        System.out.println(weatherData.weatherRootData().getWeather()[0].getMain());
        System.out.println(weatherData.weatherRootData().getWind().speed);
        System.out.println(weatherData.weatherRootData().getMain().temp);
        System.out.println(weatherData.weatherRootData().getClouds().all);
        System.out.println(weatherData.weatherRootData().getSys().country);
        System.out.println(weatherData.weatherRootData().getTimezone());
    }
}
