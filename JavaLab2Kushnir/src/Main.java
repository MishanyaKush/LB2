import java.io.*;
import java.lang.reflect.Array;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;


public class Main {
    static Scanner scanner = new Scanner(System.in);
    static String fileName = "math.txt";

    public static void main(String[] args) {
        ChooseMenu();
    }

    static void ChooseMenu() {
        int index;
        do {
            System.out.println("1.Завдання з рядком\n2.Робота з файлом\n3.Вихід");
            index = scanner.nextByte();
            switch (index) {
                case 1: {
                    TaskOneA();
                }
                break;
                case 2: {
                    do {
                        System.out.println("1.Добавити в файл\n2.Вивести весь файл\n3.Назад в меню");
                        index = scanner.nextInt();
                        switch (index) {
                            case 1:
                                AddToFile();
                                break;
                            case 2:
                                ReadFile();
                                break;
                        }
                    } while (index != 3);
                    index = 0;
                }
                break;
            }
        } while (index != 3);
    }

    static void TaskOneA() {
        int n;
        System.out.println("Введіть к-сть рядків: ");
        n = scanner.nextByte();
        String[] str = new String[n];
        str[0] = scanner.nextLine();
        for (int i = 0; i < n; i++) {
            System.out.print("Введіть текст: ");
            str[i] = scanner.nextLine();
        }
        int max = 0;
        for (int i = 0; i < n; i++) {
            int countWord = 0;
            if (str[max].length() < str[i].length()) max = i;
            for (int j = 0; j < str[i].length(); j++) {
                if (str[i].charAt(j) == ' ') countWord++;
            }
            System.out.println(str[i] + " | К-сть слів: " + (countWord + 1));
        }
        System.out.println("Найдовше речення: " + str[max]);

    }


    static void AddToFile() {
        String surname, name;
        int mark;
        System.out.print("Введіть прізвище: ");
        surname = scanner.nextLine();
        surname = scanner.nextLine();
        System.out.print("Введіть ім'я: ");
        name = scanner.nextLine();
        System.out.print("Введіть оцінку: ");
        mark = scanner.nextByte();
        try {
            FileOutputStream outStream = new FileOutputStream(fileName, true);
            DataOutputStream dos = new DataOutputStream(outStream);
            dos.writeUTF(surname);
            dos.writeUTF(name);
            dos.write(mark);
            outStream.close();
        } catch (IOException e) {
            System.out.println("Error");
        }
    }

    static void ReadFile() {
        try {
            FileInputStream fis = new FileInputStream(fileName);
            DataInputStream dis = new DataInputStream(fis);
            Scanner sc = new Scanner(fis);

            while (dis.available() > 0) {
                System.out.println("Прізвище: "+dis.readUTF() + "| Ім'я: " + dis.readUTF() + "| Оцінка: " + dis.read());
            }
            dis.close();
        } catch (IOException e) {
            System.out.println("Error");
        }
    }

}
