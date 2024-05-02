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

    public void viewMonthEvents(Scanner scanner) {
        boolean endMonth = false;
        int month = 0;
        String monthName = "";

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

        if (month == 1) {
            monthName = "January";
        } else if (month == 2) {
            monthName = "February";
        } else if (month == 3) {
            monthName = "March";
        } else if (month == 4) {
            monthName = "April";
        } else if (month == 5) {
            monthName = "May";
        } else if (month == 6) {
            monthName = "June";
        } else if (month == 7) {
            monthName = "July";
        } else if (month == 8) {
            monthName = "August";
        } else if (month == 9) {
            monthName = "September";
        } else if (month == 10) {
            monthName = "October";
        } else if (month == 11) {
            monthName = "November";
        } else if (month == 12) {
            monthName = "December";
        }

        System.out.println("Alarms and Events for " + monthName + ":\n");
        if (!alarms.isEmpty()) {
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
    }
    public void sortByDate() {
        Comparator<Event> dateCompare = new Comparator<Event>() {
            public int compare(Event event1, Event event2) {
                return event1.getDate().compareTo(event2.getDate());
            }
        };
        Collections.sort(events, dateCompare);
    }
}
