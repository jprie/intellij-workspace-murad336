package at.appdevs.basics;

public class Date {

    private Month month;
    // Vereinfacht als int
    private int year;

    public enum Month {
        JANUARY(31), FEBRUARY(28), MARCH(31);

        private int days;

        private Month(int days) {
            this.days = days;

        }
    }

    public int getDaysInMonth() {

        if (month == Month.FEBRUARY) {
            if (isLeapYear()) {
                return month.days+1;
            }
        }

        return month.days;
    }

    // Schaltjahr-Überprüfung würde man in äusserer Klasse Date machen,
    // da dort year und month vorhanden (Im Sinne des Scope) sind
    private boolean isLeapYear() {

        // hier: Schaltjahr-Berechnung einfügen
        return false;
    }
}
