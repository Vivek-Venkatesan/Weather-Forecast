package project.weather_forecast.Dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
public class WeatherResponse {
    private double temperature;
    private double temperature_min;
    private  double temperature_max;
    private int humidity;
    private int pressure;
}
