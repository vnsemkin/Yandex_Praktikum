import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        CsvParser csv_parser = new CsvParser();
        Info fileInfo = new Info();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            printInfo();
            int number = scanner.nextInt();
            switch (number) {
                case 1:
                    csv_parser.readMonthFile();
                    break;
                case 2:
                    csv_parser.readFileYear();
                    break;
                case 3:
                    fileInfo.compareReports();
                    break;
                case 4:
                    fileInfo.infoMonth();
                    break;
                case 5:
                    fileInfo.infoYear();
                    break;
                case 6:
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Не верная команда");
                    break;
            }

        }

    }

    private static void printInfo() {
        System.out.println("1: Считать все месячные отчёты");
        System.out.println("2: Считать годовой отчёт");
        System.out.println("3: Сверить отчёты");
        System.out.println("4: Вывести информацию о всех месячных отчётах");
        System.out.println("5: Вывести информацию о годовом отчёте");
        System.out.println("6: Выход из системы ");
    }
}
