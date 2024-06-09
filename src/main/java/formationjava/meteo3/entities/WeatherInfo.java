package formationjava.meteo3.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor

@ToString
public class WeatherInfo {
    @JsonProperty("temperature")
    private double temperature;

    @JsonProperty("description")
    private String description;

    @JsonProperty("windSpeed")
    private double windSpeed;

    @JsonProperty("cloudiness")
    private int cloudiness;

    @JsonProperty("sunrise")
    private long sunrise;

    @JsonProperty("sunset")
    private long sunset;
    //constructor
    public WeatherInfo(double temperature, String description, double windSpeed, int cloudiness, long sunrise, long sunset) {
        this.temperature = temperature;
        this.description = description;
        this.windSpeed = windSpeed;
        this.cloudiness = cloudiness;
        this.sunrise = sunrise;
        this.sunset = sunset;}

    // Getters and setters
    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getWindSpeed() {
        return windSpeed;
    }

    public void setWindSpeed(double windSpeed) {
        this.windSpeed = windSpeed;
    }

    public int getCloudiness() {
        return cloudiness;
    }

    public void setCloudiness(int cloudiness) {
        this.cloudiness = cloudiness;
    }

    public long getSunrise() {
        return sunrise;
    }

    public void setSunrise(long sunrise) {
        this.sunrise = sunrise;
    }

    public long getSunset() {
        return sunset;
    }

    public void setSunset(long sunset) {
        this.sunset = sunset;

    }
}
