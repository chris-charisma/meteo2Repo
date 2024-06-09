package formationjava.meteo3;

import formationjava.meteo3.service.WeatherService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;

@SpringBootApplication
public class Meteo3Application {

    public static void main(String[] args) {

        SpringApplication.run(Meteo3Application.class, args);
        String city = "Paris"; // Remplacez par la ville de votre choix
        WeatherService weatherService = new WeatherService();
        try {
            ResponseEntity<Object> weather = weatherService.getWeather(city);
            System.out.println("Weather in " + city + ": " + weather);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
