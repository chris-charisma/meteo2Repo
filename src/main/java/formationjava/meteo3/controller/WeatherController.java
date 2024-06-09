package formationjava.meteo3.controller;


import formationjava.meteo3.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WeatherController {
    @Autowired
    private WeatherService weatherService;

    //appeler depuis le service Angular pour appeler la methode de couche metier java pour interroger api

    @GetMapping("/api/weather")
    @CrossOrigin(origins = "http://localhost:4200")/*confi locale sur ce endpoint, si je veux une config globale pour tous les controller il faut faire une class avec
    un header CORS*/
    public ResponseEntity<ResponseEntity<Object>> getWeather(@RequestParam String city) throws Exception {//appel service java qui appelera l'Api meteo
      ResponseEntity<Object> weatherData = weatherService.getWeather(city);
        return ResponseEntity.ok().body(weatherData);
    }
}
