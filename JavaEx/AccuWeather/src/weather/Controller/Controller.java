package weather.Controller;

import weather.WeatherData;
import weather.repository.SQLServerConnection;


import java.io.IOException;

import java.sql.*;

public class Controller {

    public void addData() throws SQLException, ClassNotFoundException, IOException {
        WeatherData weatherData = new WeatherData();
        for(int i = 0; i<weatherData.weatherRootData().size();i++){
            String dateTime = weatherData.weatherRootData().get(i).getDateTime();
            int epochDateTime = weatherData.weatherRootData().get(i).getEpochDateTime();
            int weatherIcon = weatherData.weatherRootData().get(i).getWeatherIcon();
            String iconPhrase = weatherData.weatherRootData().get(i).getIconPhrase();
            String precipitationType = weatherData.weatherRootData().get(i).getPrecipitationType();
            float value = weatherData.weatherRootData().get(i).getTemperature().getValue();
            String unit =weatherData.weatherRootData().get(i).getTemperature().getUnit();
            int unitType =weatherData.weatherRootData().get(i).getTemperature().getUnitType();
            Connection connection = SQLServerConnection.getSQLServerConnection();
            //Nhập dữ liệu vào bảng Temperature
            String insertTemp = "INSERT INTO Temperature VALUES(?,?,?)";
            PreparedStatement psTemp = connection.prepareStatement(insertTemp,Statement.RETURN_GENERATED_KEYS);
            psTemp.setFloat(1,value);
            psTemp.setString(2,unit);
            psTemp.setInt(3,unitType);
            psTemp.executeUpdate();

            ResultSet temp =psTemp.getGeneratedKeys();
            int tempId = temp.getInt(0);

            //Nhập dữ liệu vào bảng Weather
            String insertWeather = "INSERT INTO weather VALUES(?,?,?,?,?,?)";
            PreparedStatement psWeather = connection.prepareStatement(insertWeather,Statement.RETURN_GENERATED_KEYS);
            psWeather.setString(1,dateTime);
            psWeather.setInt(2,epochDateTime);
            psWeather.setInt(3,weatherIcon);
            psWeather.setString(4,iconPhrase);
            psWeather.setString(5,precipitationType);
            psWeather.setInt(6,tempId);
            psWeather.executeUpdate();
        }
        System.out.println("Nhập dữ liệu từ API vào SQL thành công!");
    }
}
