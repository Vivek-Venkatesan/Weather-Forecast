package project.weather_forecast.Service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import project.weather_forecast.Dto.WeatherForecastDto;
import project.weather_forecast.Exception.NotFoundException;

@Service
public class WeatherForecastService {
    private final String baseUrl;
    private final String apiKey;
    private final RestTemplate restTemplate;

    public WeatherForecastService(@Value("${openWeather.baseUrl}") String baseUrl,
                                  @Value("${openWeather.apiKey}") String apiKey,
                                  RestTemplate restTemplate) {
        this.baseUrl = baseUrl;
        this.apiKey = apiKey;
        this.restTemplate = restTemplate;
    }

    public WeatherForecastDto getWeatherForecast(String city) throws NotFoundException {
        String url = baseUrl + "?q=" + city + "&appid=" + apiKey;
        WeatherForecastDto weather = restTemplate.getForObject(url, WeatherForecastDto.class);
        if (weather == null) {
            throw new NotFoundException();
        }
        return weather;

    }
}
