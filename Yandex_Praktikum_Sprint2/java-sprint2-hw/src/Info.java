import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Info {
    private final List<YearlyReport> list = CSV_Parser.getList();
    private final Map<Integer, ArrayList<MonthlyReport>> map = CSV_Parser.getMap();
    private Month[] m = Month.values();

    public void infoMonth() {
        if (!checkListAndMap()) {
            System.out.println("Файлы еще не считаны");
            return;
        }

        String nameIncome = "";
        String nameBadIncome = "";
        int monthIncome = 0;

        for (Map.Entry<Integer, ArrayList<MonthlyReport>> e : map.entrySet()) {
            monthIncome = e.getKey() - 1;
            int sumIncome = 0;
            int sumBadIncome = 0;
            for (int i = 0; i < e.getValue().size(); i++) {
                int sum = e.getValue().get(i).getQuantity() * e.getValue().get(i).getSumOfOne();
                if (!e.getValue().get(i).isIs_expense() && sum > sumIncome) {
                    sumIncome = sum;
                    nameIncome = e.getValue().get(i).getItem_name();
                } else if (e.getValue().get(i).isIs_expense() && sum > sumBadIncome) {
                    sumBadIncome = sum;
                    nameBadIncome = e.getValue().get(i).getItem_name();
                }
            }
            System.out.println(m[monthIncome]);
            System.out.println("Cамый прибыльный товар " + sumIncome + " " + nameIncome);
            System.out.println("Cамый убыточный товар  " + sumBadIncome + " " + nameBadIncome);
        }
    }

    public boolean checkListAndMap() {
        if (list.isEmpty() || map.isEmpty()) return false;
        else return true;
    }

    public void infoYear() {
        if (!checkListAndMap()) {
            System.out.println("Файлы еще не считаны");
            return;
        }

        int income = 0;
        int incomeSum = 0;
        int badIncome = 0;
        int badIncomeSum = 0;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).isIs_expense()) {
                badIncome += list.get(i).getAmount();
                badIncomeSum += list.get(i).getAmount();
            } else {
                income += list.get(i).getAmount();
                incomeSum += list.get(i).getAmount();
            }
            if (i % 2 != 0) {
                System.out.println("Доход за месяц " + m[list.get(i).getMonth() - 1] + " " + (income - badIncome));
                income = 0;
                badIncome = 0;
            }
        }
        System.out.println("Средний  расход " + badIncomeSum / (list.size() / 2));
        System.out.println("Средний  доход " + incomeSum / (list.size() / 2));
    }

    public void check() {
        if (!checkListAndMap()) {
            System.out.println("Файлы еще не считаны");
            return;
        }
        Info fileInfo = new Info();
        int c = 0;

        for (Map.Entry<Integer, ArrayList<MonthlyReport>> e : map.entrySet()) {
            c++;
            int income = 0;
            int badIncome = 0;
            for (int i = 0; i < e.getValue().size(); i++) {
                int count = e.getValue().get(i).getSumOfOne() * e.getValue().get(i).getQuantity();
                if (e.getValue().get(i).isIs_expense()) {
                    badIncome += count;
                } else {
                    income += count;
                }
            }
            int sum = income - badIncome;
            if (fileInfo.check2(e.getKey()) != sum) {
                System.err.println("Ошибка в отчете за " + e.getKey() + " месяце ");
                return;
            }

        }
        System.out.println("Успешно");
    }

    private int check2(int i) {
        int in = 0;
        int bad = 0;

        int c = i - 1;
        for (int j = 0; j < list.size(); j++) {
            if (list.get(j).getMonth() == i && list.get(j).isIs_expense()) {
                bad += list.get(j).getAmount();
            } else if (list.get(j).getMonth() == i && !list.get(j).isIs_expense()) {
                in += list.get(j).getAmount();
            }
        }
        return in - bad;
    }

}
