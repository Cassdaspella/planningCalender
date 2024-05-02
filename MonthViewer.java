import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class MonthViewer {

    private ArrayList<Event> events;
    private ArrayList<Alarm> alarms;

    public MonthViewer(ArrayList<Event> events, ArrayList<Alarm> alarms) {
        this.events = events;
        this.alarms = alarms;
    }
// ++++++++++++++++++++++++++++++++++++++ Calling the Events and Alarms here ^^^ +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    public void viewMonthEvents(Scanner scanner) {
        boolean endMonth = false;
        int month = 0;
        String monthName = "";
// ++++++++++++++++++++++++++++++++++++++ Initializing Stuff here ^^^ +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
        while (!endMonth) {
            System.out.println("Please enter the month (MM): ");
            while (!scanner.hasNextInt()) {
                System.out.println("Please enter the month's digits (MM)! Try Again!");
                scanner.next();
            }
            month = scanner.nextInt();
            if (month >= 1 && month <= 12) {
                endMonth = true;
            } else {
                System.out.println("Please enter a valid month (1-12)! Try Again");
            }
        }
// ++++++++++++++++++++++++++++++++++++++ Asking for Months here ^^^ +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
        switch (month) {
            case 1:
                monthName = "January";
                break;
            case 2:
                monthName = "February";
                break;
            case 3:
                monthName = "March";
                break;
            case 4:
                monthName = "April";
                break;
            case 5:
                monthName = "May";
                break;
            case 6:
                monthName = "June";
                break;
            case 7:
                monthName = "July";
                break;
            case 8:
                monthName = "August";
                break;
            case 9:
                monthName = "September";
                break;
            case 10:
                monthName = "October";
                break;
            case 11:
                monthName = "November";
                break;
            case 12:
                monthName = "December";
                break;
        }
// ++++++++++++++++++++++++++++++++++++++ Turning Months int to String here ^^^ +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
        System.out.println("Alarms and Events for " + monthName + ":\n");
        if (!alarms.isEmpty()) {
            sortByDate();
            for (Alarm alarm : alarms) {
                if (alarm.getDate().getMonthValue() == month) {
                    System.out.println(alarm);
                }
            }
        }
        else {
            // if there are no events for that day...
            System.out.println("No Alarms found for " + monthName + ".");
            System.out.println("Please make an alarm! \n++++++++++++++++++++++++++++++\n");
        }
        if (!events.isEmpty()) {
            sortByDate();
            for (Event event : events) {
                if (event.getDate().getMonthValue() == month) {
                    System.out.println(event);
                }
            }
        }
        else {
            // if there are no events for that day...
            System.out.println("No events found for " + monthName + ".");
            System.out.println("Please make an event! Redirecting to main menu \n++++++++++++++++++++++++++++++\n");
        }
        // ++++++++++++++++++++++++++++++++++++++ Month View Sorts & Displays here ^^^ +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    }
// ++++++++++++++++++++++++++++++++++++++ View Month Activities here ^^^ +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    public void sortByDate() {
        Comparator<Event> dateEventCompare = new Comparator<Event>() {
            public int compare(Event event1, Event event2) {
                return event1.getDate().compareTo(event2.getDate());
            }
        };
        Comparator<Alarm> dateAlarmCompare = new Comparator<Alarm>() {
            public int compare(Alarm alarm1, Alarm alarm2) {
                return alarm1.getDate().compareTo(alarm2.getDate());
            }
        };
        Collections.sort(events, dateEventCompare);
        Collections.sort(alarms, dateAlarmCompare);
    }
    // ++++++++++++++++++++++++++++++++++++++ View Date Sorts here ^^^ +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
}
