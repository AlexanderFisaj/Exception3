import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите данные в формате: Фамилия Имя Отчество дата_рождения номер_телефона пол");
        String input = scanner.nextLine();
        String[] data = input.split(" ");
        if (data.length != 6) {
            System.err.println("Ошибка! Введено неверное количество параметров.");
            return;
        }
        String surname = data[0];
        String name = data[1];
        String patronymic = data[2];
        String birthDateStr = data[3];
        long phoneNumber;
        try {
            phoneNumber = Long.parseLong(data[4]);
        } catch (NumberFormatException e) {
            System.err.println("Ошибка! Номер телефона должен быть целым числом без форматирования.");
            return;
        }
        char gender = data[5].charAt(0);
        if (gender != 'f' && gender != 'm') {
            System.err.println("Ошибка! Пол должен быть задан символом 'f' или 'm'.");
            return;
        }
        BirthDate birthDate;
        try {
            birthDate = BirthDate.parse(birthDateStr);
        } catch (InvalidBirthDateException e) {
            System.err.println("Ошибка! Неверный формат даты рождения. Должно быть dd.mm.yyyy.");
            return;
        }
        String fileName = surname + ".txt";
        File file = new File(fileName);
        try (FileWriter writer = new FileWriter(file, true)) {
            writer.write("<" + surname + " " + name + " " + patronymic + "><" + birthDateStr + "><" + phoneNumber + "><" + gender + ">\n");
        } catch (IOException e) {
            System.err.println("Ошибка при записи в файл: " + fileName);
            e.printStackTrace();
        }
    }
}



