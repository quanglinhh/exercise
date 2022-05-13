package weather;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

public class WeatherData {
    private String city;
    private String country;
    Gson gson = new Gson();


    public WeatherData(String city, String country) {
        this.city = city;
        this.country = country;
    }
    public WeatherData(){}
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
    public WeatherRoot weatherRootData() throws IOException {
        WeatherRoot weatherRootData = gson.fromJson(getAPIJson(getLink()),WeatherRoot.class);
        return weatherRootData;

    }

   /* public static void main(String[] args) throws IOException {
        String lineTest = getAPIJson(getLink());
        System.out.println(lineTest);
    }*/


    public  String getAPIJson(String link) throws IOException {
        StringBuilder data = new StringBuilder();
        URL url = new URL(link);

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(url.openStream()));
        String line;
        while ((line = bufferedReader.readLine())!=null){//doc den dong cuoi cung
            data.append(line);//sau moi ving lap noi line thanh mot chuoi

        }

        return  data.toString();//tra ve 1 json string

    }
    public  String getLink(){
//        String link = "http://api.openweathermap.org/data/2.5/weather?q=" +city+","+country+
//                "&appid=96381a872b1b405c5bf83b2ed63d9561&units=metric\n";
        String link = "https://api.openweathermap.org/data/2.5/weather?q=hanoi,vietnam&appid=96381a872b1b405c5bf83b2ed63d9561&units=metric";
        return link;

    }

    public static void main(String[] args) throws IOException {
        WeatherData weatherData = new WeatherData();

        weatherData.weatherRootData();

    }
}
