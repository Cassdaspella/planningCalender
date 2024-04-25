import java.time.LocalDate;

public class Alarm {
    private LocalDate date;
    private String title;
    private LocalDate date2;

    public Alarm(LocalDate date, String title, LocalDate date2) {
        this.date = date;
        this.title = title;
        this.date2 = date2;
    }

    public LocalDate getDate() {
        return date;
    }
    public LocalDate getDate2() {
        return date2;
    }

    @Override
    public String toString() {
        return "   \u001B[31mAlarm Today!: " + title + "\n" +
                "     From: " + date + "\n" +
                "     To: " + date2 + "\n\u001B[0m";
    }
}