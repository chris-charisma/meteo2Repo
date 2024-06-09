package formationjava.meteo3.service;




import formationjava.meteo3.entities.WeatherInfo;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

@Service
public class WeatherService {
    private static final String API_KEY = "53d7d93f684be33aed4df2b8258cb9c6"; // Remplacez par votre clé API OpenWeatherMap
    private static final String BASE_URL = "http://api.openweathermap.org/data/2.5/weather?q=";

    public ResponseEntity<Object> getWeather(String city) throws Exception {
        try {
            String urlString = BASE_URL + city + "&appid=" + API_KEY + "&units=metric"; // Utilisation de l'unité métrique
            URL url = new URL(urlString);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.connect();

            int responseCode = conn.getResponseCode();
            if (responseCode != 200) {
                // Si le code de réponse n'est pas 200, renvoyer une erreur avec le code d'état approprié
                return ResponseEntity.status(responseCode).body(null);
            } else {
                BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                StringBuilder jsonResponse = new StringBuilder();
                String inputLine;
                while ((inputLine = in.readLine()) != null) {
                    jsonResponse.append(inputLine);
                }
                in.close();

                JSONObject weatherJson = new JSONObject(jsonResponse.toString());
                JSONObject main = weatherJson.getJSONObject("main");
                JSONArray weatherArray = weatherJson.getJSONArray("weather");
                JSONObject weather = weatherArray.getJSONObject(0);

                String description = weather.getString("description");
                double temperature = main.getDouble("temp");
                double windSpeed = weatherJson.getJSONObject("wind").getDouble("speed");
                int cloudiness = weatherJson.getJSONObject("clouds").getInt("all");
                long sunrise = weatherJson.getJSONObject("sys").getLong("sunrise");
                long sunset = weatherJson.getJSONObject("sys").getLong("sunset");
                System.out.println(jsonResponse);

                // Créez un nouvel objet WeatherInfo avec les nouvelles informations
                WeatherInfo weatherInfo = new WeatherInfo(temperature, description, windSpeed, cloudiness, sunrise, sunset);

               // Logging the created WeatherInfo object
                System.out.println("Created WeatherInfo: " + weatherInfo);

            return ResponseEntity.ok(weatherInfo);

            }
        }catch(IOException | JSONException e){
                // En cas d'erreur, renvoyer une réponse avec le code d'état HTTP approprié
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
            }

        }
    }
