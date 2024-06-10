package project.weather_forecast.Model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
public class WeatherForecast {
    private String city;
    private String country;
    private Long zipCode;
    private String description;
    private Double temperature;
    private int id;
    private String name;
    private int timezone;
    private long sunset;
    private long sunrise;
}
