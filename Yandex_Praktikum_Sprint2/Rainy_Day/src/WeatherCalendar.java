class WeatherCalendar {
    // Initilized class variables.
    String month;
    int numberOfDays;
    int rainyDays;
    int year = 2020;
    boolean isRainyMonth;
    // Обьявляем конструктор
    public WeatherCalendar(String month, int numberOfDays){
        this.month = month;
        this.numberOfDays = numberOfDays;
    }



    // Увеличить переменную rainyDays на единицу
    public void addRainyDay() {
        rainyDays++;
    }
}
