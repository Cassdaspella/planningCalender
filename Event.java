import java.time.LocalDate;

public class Event {
    private LocalDate date;
    private String title;
    private String description;
    private int priority;
    private String color;

    public Event(LocalDate date, String title, String description, int priority) {
        this.date = date;
        this.title = title;
        this.description = description;
        this.priority = priority;

        switch (priority) {
            case 1:
                color = "\u001b[31m";
                break;
            case 2:
                color = "\u001b[33m";
                break;
            case 3:
                color = "\u001b[32m";
                break;
            case 4:
                color = "\u001b[36m";
                break;
            case 5:
                color = "\u001b[35m";
                break;
        }
    }

    public LocalDate getDate() {
        return date;
    }

    public int getPriority() {
        return priority;
    }

    @Override
    public String toString() {
        return color + "   Title: " + title + "\n" +
                "     Date: " + date + "\n" +
                "     Description: " + description + "\n" +
                "     Priority Level: " + priority + "\n \u001b[0m";
    }
}
