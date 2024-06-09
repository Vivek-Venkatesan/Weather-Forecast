package project.weather_forecast;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

@SpringBootApplication
@Component
public class WeatherForecastApplication {

	public static void main(String[] args) {
		SpringApplication.run(WeatherForecastApplication.class, args);
	}

}
