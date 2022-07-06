import java.util.Scanner;

public class Praktikum {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int year = 1900;
        do {
            System.out.println("Введите год:");
            year = scanner.nextInt();
        } while (year < 1900 || year > 2200);

        if (isLeapYear(year)) {
            System.out.println("В этом году отмечаем 12 сентября " + year + " !");
        }else {
            System.out.println("В этом году отмечаем 13 сентября " + year + " !");
        }
    }

    public static boolean isLeapYear(int year) {
        if  (( ( year % 4 == 0 ) && ( year % 100 != 0 ) ) || ( year % 400 == 0 ) ){
            return false;
        }else {
            return true;
        }
    }
}