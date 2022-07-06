public enum Month {
        JANUARY("Январь"),
        FEBRUARY("Февраль"),
        MARCH("Март"),
        APRIL("Апрель"),
        MAY("Май"),
        JUNE("Июнь"),
        JULY("Июль"),
        AUGUST("Август"),
        SEPTEMBER("Сентябрь"),
        OCTOBER("Октябрь"),
        NOVEMBER("Ноябрь"),
        DECEMBER("Декабрь");
        private String title;

        Month(String title) {
            this.title = title;
        }

        @Override
        public String toString() {
            return title;
        }
}


