package project.weather_forecast.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import project.weather_forecast.Dto.WeatherForecastDto;
import project.weather_forecast.Exception.NotFoundException;
import project.weather_forecast.Service.WeatherForecastService;

@RestController
//@RequestMapping("/weather")
public class WeatherForecast {
    private final WeatherForecastService weatherForecastService;

    public WeatherForecast(WeatherForecastService weatherForecastService) {
        this.weatherForecastService = weatherForecastService;
    }

    @GetMapping("/city/{cityName}")
    public  WeatherForecastDto getWeatherByCity(@PathVariable("cityName") String cityName) throws NotFoundException {
        return weatherForecastService.getWeatherForecast(cityName);
    }
}
