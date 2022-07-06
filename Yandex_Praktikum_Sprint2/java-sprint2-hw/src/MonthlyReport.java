public class MonthlyReport {
    private String item_name;
    private boolean is_expense;
    private int quantity;
    private int sumOfOne;

    public MonthlyReport(String item_name, boolean is_expense, int quantity, int sumOfOne) {
        this.item_name = item_name;
        this.is_expense = is_expense;
        this.quantity = quantity;
        this.sumOfOne = sumOfOne;
    }

    public String getItem_name() {
        return item_name;
    }

    public boolean isIs_expense() {
        return is_expense;
    }

    public int getQuantity() {
        return quantity;
    }

    public int getSumOfOne() {
        return sumOfOne;
    }

    @Override
    public String toString() {
        return "MonthlyReport{" +
                "item_name='" + item_name + '\'' +
                ", is_expense=" + is_expense +
                ", quantity=" + quantity +
                ", sumOfOne=" + sumOfOne +
                '}';
    }
}

