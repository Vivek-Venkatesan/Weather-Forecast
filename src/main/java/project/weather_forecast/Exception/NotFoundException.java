package project.weather_forecast.Exception;

public class NotFoundException extends Exception{
    public NotFoundException() {
        super("The Weather is not found");
    }
}
