package jdbcapp.weatherApp;

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

    public WeatherData() {
    }

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

    public String getAPIJson(String link) throws IOException {
        StringBuilder data = new StringBuilder();
        URL url = new URL(link);
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(url.openStream()));
        String line;
        while ((line = bufferedReader.readLine()) != null) {//Đọc đến dòng cuối cùng,Gán cho line
            data.append(line);//Sau mỗi vòng lặp nối line thành 1 chuỗi
        }
        return data.toString();//Trả về 1 jsonString

    }

    public String getLink() {
        String link = "https://api.openweathermap.org/data/2.5/weather?q=" + city + "," + country +
                "&appid=96381a872b1b405c5bf83b2ed63d9561&units=metric";
//        String link = "https://api.openweathermap.org/data/2.5/weather?q=hanoi,vietnam&appid=96381a872b1b405c5bf83b2ed63d9561&units=metric";
        return link;
    }


    public WeatherRoot weatherRootData() throws IOException {
        WeatherRoot weatherRootData = gson.fromJson(getAPIJson(getLink()), WeatherRoot.class);
        return weatherRootData;
    }

//    public static void main(String[] args) throws IOException {
//        WeatherData weatherData = new WeatherData("hanoi","vietnam");
//        System.out.println(weatherData.weatherRootData().getCrood().lat);
//        WeatherData weatherData = new WeatherData();
//        weatherData.weatherRootData();
//    }


}
