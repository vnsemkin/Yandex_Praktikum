public class Converter {
    // Объявляем константы.
    private final double STEP_IN_KKAL = 0.005;
    private final double STEP_IN_KM = 0.00075;
    // Конвертируем шаги в дистанцию.
    public double convertStepToKm(int totalMonthSteps){
        return totalMonthSteps * STEP_IN_KM;
    }

    // Конвертируем шаги в калории.
    public double convertStepToCalories(int totalMonthSteps){
         return totalMonthSteps * STEP_IN_KKAL;
    }
}
