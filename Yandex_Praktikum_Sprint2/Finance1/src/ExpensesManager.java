import java.util.ArrayList; // Импортируйте ArrayList

public class ExpensesManager {
     // Замените массив списком
     ArrayList<Double> expenses;
    ExpensesManager() {
        //expenses = new double[7]; // Создайте список в конструкторе
        expenses = new ArrayList<>();
    }

    // Номер дня больше не нужен
    double saveExpense(double moneyBeforeSalary, double expense) {
        moneyBeforeSalary -= expense;
        //expenses[day - 1] = expenses[day - 1] + expense; // Эту строку нужно убрать
        expenses.add(expense);
        System.out.println("Значение сохранено! Ваш текущий баланс в рублях: " + moneyBeforeSalary);
        if (moneyBeforeSalary < 1000) {
            System.out.println("На вашем счету осталось совсем немного. Стоит начать экономить!");
        }
        return moneyBeforeSalary;
    }

    void printAllExpenses() {
        for (int i = 0; i < expenses.size(); i++) {
            System.out.println("Трата № " + (i + 1) + ". Потрачено " + expenses.get(i) + " рублей");
        }
    }

    double findMaxExpense() {
        double maxExpense = 0;
        for (Double exp : expenses) { // Используйте сокращённую форму цикла
            if (exp > maxExpense) {
                maxExpense = exp;
            }
        }
        return maxExpense;
    }

    void removeAllExpenses(){
        expenses.clear();
    }

    void removeExpense(double expense){
        if (!expenses.isEmpty()){
            System.out.println("Список трат пуст.");
            if (expenses.contains(expense)){
                System.out.println("Такой траты нет.");
                for (int i = 0; i < expenses.size(); i++) {
                    if (expenses.get(i) == expense) {
                        expenses.remove(i);
                        System.out.println("Трата удалена!");
                        break;
                    }
                }
            }
        }

    }

}