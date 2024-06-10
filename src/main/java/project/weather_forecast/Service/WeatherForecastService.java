package project.weather_forecast.Service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import project.weather_forecast.Dto.WeatherForecastDto;
import project.weather_forecast.Exception.NotFoundException;

import java.io.IOException;

@Service
public class WeatherForecastService {
    private final String baseUrl;
    private final String apiKey;
    RestTemplate restTemplate = new RestTemplate();

    public WeatherForecastService(@Value("${openWeather.baseUrl}") String baseUrl, @Value("${openWeather.apiKey}") String apiKey) {
        this.baseUrl = baseUrl;
        this.apiKey = apiKey;
    }

    public WeatherForecastDto getWeatherForecast(String city) throws NotFoundException {
        String url = baseUrl + "?q=" + city + "&appid=" + apiKey;
        System.out.println("Value of Url = "+url);
        try {
            String weather = restTemplate.getForObject(url, String.class);
            if(weather == null) {
                throw new NotFoundException();
            }
            System.out.println("Inside try block = "+ weather);
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode root = objectMapper.readTree(weather);
            WeatherForecastDto weatherForecast = new WeatherForecastDto();
            weatherForecast.setTemp(root.path("main").path("temp").asDouble());
            weatherForecast.setFeelsLike(root.path("main").path("feels_like").asDouble());
            weatherForecast.setTempMin(root.path("main").path("temp_min").asDouble());
            weatherForecast.setTempMax(root.path("main").path("temp_max").asDouble());
            weatherForecast.setPressure(root.path("main").path("pressure").asInt());
            weatherForecast.setHumidity(root.path("main").path("humidity").asInt());
            weatherForecast.setDescription(root.path("weather").get(0).path("description").asText());
            weatherForecast.setIcon(root.path("weather").get(0).path("icon").asText());
            weatherForecast.setCityName(root.path("name").asText());

            return weatherForecast;
        } catch (RestClientException | IOException e) {
            throw  new NotFoundException();
        }

    }
}
