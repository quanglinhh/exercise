package jdbcapp.weatherApp;

public class Weather {
     int id;
     String description;
     String main;

    public Weather(int id, String description, String main) {
        this.id = id;
        this.description = description;
        this.main = main;
    }
    public Weather(){}
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getMain() {
        return main;
    }

    public void setMain(String main) {
        this.main = main;
    }

    @Override
    public String toString() {
        return "Weather: {" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", main='" + main + '\'' +
                '}';
    }
}
