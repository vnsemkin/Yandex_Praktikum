public class YearlyReport {
private  int month;
private boolean is_expense;
private int amount;

    public YearlyReport(int month, boolean is_expense, int amount) {
        this.month = month;
        this.is_expense = is_expense;
        this.amount = amount;
    }

    public int getMonth() {
        return month;
    }

    public boolean isIs_expense() {
        return is_expense;
    }

    public int getAmount() {
        return amount;
    }

    @Override
    public String toString() {
        return "YearlyReport{" +
                "month=" + month +
                ", is_expense=" + is_expense +
                ", amount=" + amount +
                '}';
    }
}
