package homework8;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Controller {
    private WeatherModel weatherModel = new AccuweatherModel();
// Создаю интерфейс взаимодействия пользователя и программы
    private Map<Integer, homework8.Period> variants = new HashMap<>();

    public Controller() {
        variants.put(1, homework8.Period.NOW);
        variants.put(5, homework8.Period.FIVE_DAYS);
        variants.put(2, homework8.Period.DB);
    }

    public void getWeather(String userInput, String selectedCity) throws IOException {
// Ввожу алгоритм действий программы на случай некорректного ввода данных пользователем
        Integer userIntegerInput = Integer.parseInt(userInput);

        switch (variants.get(userIntegerInput)) {
            case NOW:
                weatherModel.getWeather(selectedCity, Period.NOW);
                break;
            case FIVE_DAYS:
                throw new IOException("Метод не реализован!");
                //weatherModel.getWeather(selectedCity, Period.FIVE_DAYS);
            case DB:
                weatherModel.getSavedToDBWeather();
        }
    }
}
