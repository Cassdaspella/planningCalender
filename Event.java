import java.time.LocalDate;

public class Event {
    private LocalDate date;
    private String title;
    private String description;
    private int priority;

    public Event(LocalDate date, String title, String description, int priority) {
        this.date = date;
        this.title = title;
        this.description = description;
        this.priority = priority;
    }

    public LocalDate getDate() {
        return date;
    }
    public int getPriority(){
        return priority;
    }

    @Override
    public String toString() {
        return "   Title: " + title + "\n" +
                "     Date: " + date + "\n" +
                "     Description: " + description + "\n" +
                "     Priority Level: " + priority + "\n";
    }
}
