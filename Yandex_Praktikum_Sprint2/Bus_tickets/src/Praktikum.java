public class Praktikum {
    public static void main(String[] args) {
        Bus bus = new Bus(23765);
        String[] passengersTimestamps = new String[]{
                "08:33",
                "09:42",
                "10:43",
                "17:59",
                "18:01",
                "19:15"
        };

        for (String passengersTimestamp : passengersTimestamps) {
            increaseTicketNumber(bus);
            System.out.println("Оплата поездки в " + passengersTimestamp
                    + ". Номер билета: " + bus.ticketNumber);
        }
    }

    private static void increaseTicketNumber(Bus bus) {
        bus.ticketNumber = increase(bus.ticketNumber);
    }

    private static int increase(int numberToIncrease) {
        int number = numberToIncrease;
        return  ++number;
    }
}