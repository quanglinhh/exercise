package jdbcapp.weatherApp;

import java.util.Arrays;

public class WeatherRoot {
    Coord coord;
    Weather[] weather;//Mang objects
    Wind wind;
    Main main;
    Clouds clouds;
    Sys sys;
    String base;
    int visibility;
    int dt;
    int timezone;
    int id;
    String name;
    int cod;

    public WeatherRoot(Coord coord, Weather[] weather, Wind wind, Main main, Clouds clouds, Sys sys, String base, int visibility, int dt, int timezone, int id, String name, int cod) {
        this.coord = coord;
        this.weather = weather;
        this.wind = wind;
        this.main = main;
        this.clouds = clouds;
        this.sys = sys;
        this.base = base;
        this.visibility = visibility;
        this.dt = dt;
        this.timezone = timezone;
        this.id = id;
        this.name = name;
        this.cod = cod;
    }

    public void setWeather(Weather[] weather) {
        this.weather = weather;
    }

    public String getBase() {
        return base;
    }

    public void setBase(String base) {
        this.base = base;
    }

    public int getVisibility() {
        return visibility;
    }

    public void setVisibility(int visibility) {
        this.visibility = visibility;
    }

    public int getDt() {
        return dt;
    }

    public void setDt(int dt) {
        this.dt = dt;
    }

    public int getTimezone() {
        return timezone;
    }

    public void setTimezone(int timezone) {
        this.timezone = timezone;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCod() {
        return cod;
    }

    public void setCod(int cod) {
        this.cod = cod;
    }



    public jdbcapp.weatherApp.Sys getSys() {
        return sys;
    }

    public void setSys(jdbcapp.weatherApp.Sys sys) {
        this.sys = sys;
    }

    public Clouds getClouds() {
        return clouds;
    }

    public void setClouds(jdbcapp.weatherApp.Clouds clouds) {
        this.clouds = clouds;
    }

    public Main getMain() {
        return main;
    }

    public void setMain(jdbcapp.weatherApp.Main main) {
        this.main = main;
    }

    public jdbcapp.weatherApp.Wind getWind() {
        return wind;
    }

    public void setWind(jdbcapp.weatherApp.Wind wind) {
        this.wind = wind;
    }

    public Coord getCoord() {
        return coord;
    }

    public void setCoord(Coord coord) {
        this.coord = coord;
    }

    public jdbcapp.weatherApp.Weather[] getWeather() {
        return weather;
    }



    @Override
    public String toString() {
        return "WeatherRoot{" +
                "coord=" + coord +
                ", weather=" + Arrays.toString(weather) +
                '}';
    }
}
