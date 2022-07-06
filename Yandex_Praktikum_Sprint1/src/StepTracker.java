import java.util.Scanner;

public class StepTracker {
    // Создаем переменную типа Scanner.
    private final Scanner scanner;
    // Начальное целевое количество шагов.
    private int goalSteps = 10000;
    // Инициализируем 2D массив.
    private final int[][] monthToData = new int[12][30];
    // Создаем объект класса Converter.
    private final Converter converter = new Converter();
    // Объявляем переменную количества дней в месяце.
    private final int dayNumber = monthToData[0].length;
    // Объявляем конструктор.
    public StepTracker(Scanner scanner){
         this.scanner = scanner;
         }
    // Функция подсчета количества шагов за день.
    public void setStepDayNumber(){
        int steps;
        int month;
        int day;
        do {
             System.out.println("Введите месяц : ");
             month = scanner.nextInt();
         }while (month < 1 || month > 12);
         do {
             System.out.println("Введите день : ");
             day = scanner.nextInt();
         }while (day < 1 || day > 30);
         do {
             System.out.println("Введите количество пройденных шагов:");
             steps = scanner.nextInt();
         }while (steps < 0 || steps > 70000);
        monthToData[month - 1][day - 1] = steps;
    }

   // Функция считывания расчетного месяца введенного пользователем.
   public int readMonth(){
       int statMonth;
       do {
           System.out.println("Введите месяц : ");
           statMonth = scanner.nextInt();
       }while (statMonth < 1 || statMonth > 12);
            return statMonth;
   }

   // Функция расчета количества пройденных шагов за месяц.
   public int calcStepCount(int statMonth) {
       int totalMonthSteps =0;
       for (int day = 0; day < dayNumber; day++) {
               totalMonthSteps += monthToData[statMonth - 1][day];
       }
            return totalMonthSteps;
   }

   // Функция вывода количества шагов пройденных за день.
   public void printDayData(int statMonth, int totalMonthSteps) {
       System.out.print(" Статистика за : " + statMonth + " месяц.");
       System.out.println();
       for (int day = 0; day < dayNumber; day++) {
           if (day < dayNumber - 1) {
               System.out.print(" " + (day + 1) + "-й День : " + monthToData[statMonth - 1][day] + ",");
           } else {
               System.out.print(" " + (day + 1) + "-й День : " + monthToData[statMonth - 1][day]);
               System.out.println();
           }
       }
       System.out.print(" Общее количество шагов за месяц : " + totalMonthSteps);
       System.out.println();

   }

   // Функция расчета показателей за месяц.
   public void calcStepCountData(int totalMonthSteps){
       System.out.print(" Среднее количество шагов за месяц : " + totalMonthSteps / dayNumber);
       System.out.println();
       System.out.print(" Пройденная дистанция : " + converter.convertStepToKm(totalMonthSteps) + " км.");
       System.out.println();
       System.out.print(" Количество сожжённых килокалорий : "
               + converter.convertStepToCalories(totalMonthSteps) + " ккал.");
       System.out.println();
   }

    // Функция максимального количества пройденных шагов за 1 день в месяце.
   public void calcMaxMonthSteps(int statMonth) {
       int maxMonthSteps = 0;
       // Счетчик максимального количества пройденных шагов за 1 день в месяце.
       for (int day = 0; day < dayNumber; day++) {
           if (maxMonthSteps < monthToData[statMonth - 1][day]) {
               maxMonthSteps = monthToData[statMonth - 1][day];
           }
       }
       System.out.print(" Максимальное количество шагов за месяц : " + maxMonthSteps);
       System.out.println();
   }

    // Функция расчета лучшей сессии.
    public void calcBestMonthSession(int statMonth) {
        int countBest = 0;
        int bestSession = 0;
        // Счетчик лучшей серии.
        for (int day = 0; day < dayNumber; day++) {
            if (monthToData[statMonth- 1][day] >= goalSteps) {
                bestSession++;
                if (countBest < bestSession) {
                    countBest = bestSession;
                }
            } else {
                bestSession = 0;
            }
        }
        System.out.print(" Лучшая серия : " + countBest);
        System.out.println();
    }

   // Вывод статистики.
   public void  printStatisticResult() {
       int statMonth = readMonth();
       int totalMonthSteps = calcStepCount(statMonth);
       printDayData(statMonth, totalMonthSteps);
       calcMaxMonthSteps(statMonth);
       calcStepCountData(totalMonthSteps);
       calcBestMonthSession(statMonth);
   }

    // Ввод нового целевое количество шагов.
   public void setStepsGoal(){
            do {
                System.out.println("Текущее целевое количество шагов : " + goalSteps);
                System.out.println("Введите новое значение : ");
                goalSteps = scanner.nextInt();
            }while (goalSteps <= 0);
            System.out.println("Новое целевое количество шагов " + goalSteps +" !");
   }
}
