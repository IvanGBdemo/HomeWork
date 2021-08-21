package homework8;

import java.io.IOException;
import java.util.Scanner;

public class UserInterfaceView {
// Устанавливаю связь интерфейса с контроллером
    private Controller controller = new Controller();

    public void runInterface() {
// Создаю возможность ввода пользователем данных в программу
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Введите имя города: ");
            String city = scanner.nextLine();

            System.out.println("Введите 1 для получения погоды на сегодня;" +
                    "Введите 5 для прогноза на 5 дней; Введите 2 для получения данных из базы; Для выхода введите 0:");

            String command = scanner.nextLine();

//TODO* Сделать метод валидации пользовательского ввода

// Вывожу метод получения данных погоды из БД (не успел)
// Реализую выход из программы
            if (command.equals("0")) break;

            try {
                controller.getWeather(command, city);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}