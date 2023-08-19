public class BirthDate {
    private int day;
    private int month;
    private int year;

    public BirthDate(int day, int month, int year) throws InvalidBirthDateException {
        if (day < 1 || day > 31 || month < 1 || month > 12 || year < 1900 || year > 2022) {
            throw new InvalidBirthDateException();
        }
        this.day = day;
        this.month = month;
        this.year = year;
    }

    public static BirthDate parse(String str) throws InvalidBirthDateException {
        String[] parts = str.split("\\.");
        if (parts.length != 3) {
            throw new InvalidBirthDateException();
        }
        int day = Integer.parseInt(parts[0]);
        int month = Integer.parseInt(parts[1]);
        int year = Integer.parseInt(parts[2]);
        return new BirthDate(day, month, year);
    }

    @Override
    public String toString() {
        return String.format("%02d.%02d.%04d", day, month, year);
    }
}
