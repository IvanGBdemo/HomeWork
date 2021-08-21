package homework8;

import java.io.IOException;

public interface WeatherModel {
    void getWeather(String selectedCity, homework8.Period period) throws IOException;

    public void getSavedToDBWeather();
}
