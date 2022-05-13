package weather;

import java.util.Arrays;

public class WeatherRoot {
    private Coord coord;
    private Weather[] weathers;

    public WeatherRoot(Coord coord, Weather[] weathers) {
        this.coord = coord;
        this.weathers = weathers;
    }

    public Coord getCoord() {
        return coord;
    }

    public void setCoord(Coord coord) {
        this.coord = coord;
    }

    public Weather[] getWeathers() {

        for(int i = 0; i < weathers.length; i++){
            var weather = weathers.get(i);
            return weather;
        }
    }

    public void setWeathers(Weather[] weathers) {
        this.weathers = weathers;
    }

    @Override
    public String toString() {
        return "WeatherRoot{" +
                "coord=" + coord +
                ", weathers=" + Arrays.toString(weathers) +
                '}';
    }
}
