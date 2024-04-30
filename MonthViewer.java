import java.util.ArrayList;
import java.util.Scanner;

public class MonthViewer {

    private ArrayList<Event> events;
    private EventPlanner newEvents;

    public MonthViewer(ArrayList<Event> events) {
        this.events = events;
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
        }
        else if (month == 2) {
            monthName = "February";
        }
        else if (month == 3) {
            monthName = "March";
        }
        else if (month == 4) {
            monthName = "April";
        }
        else if (month == 5) {
            monthName = "May";
        }
        else if (month == 6) {
            monthName = "June";
        }
        else if (month == 7) {
            monthName = "July";
        }
        else if (month == 8) {
            monthName = "August";
        }
        else if (month == 9) {
            monthName = "September";
        }
        else if (month == 10) {
            monthName = "October";
        }
        else if (month == 11) {
            monthName = "November";
        }
        else if (month == 12) {
            monthName = "December";
        }
        
        System.out.println("Events for " + monthName + ":");
        if (!events.isEmpty()) {
        for (Event event : events) {
            if (event.getDate().getMonthValue() == month) {
                System.out.println(event);
            }
        }
    }
    else {
            // if there are no events for that day...
            System.out.println("No events found for " + monthName + ".");
            System.out.println("Would you like to add a new event for this date? (yes/no)");
            boolean endYesorNo = false;
            while (!endYesorNo) {
                String choice = scanner.next();
                if ("yes".equalsIgnoreCase(choice)) {
                    System.out.println("Redirecting you to the Event Planner! \n+++++++++++++++++++++++++");
                    newEvents.viewEvent(scanner);
                    endYesorNo = true;
                } else if ("no".equalsIgnoreCase(choice)) {
                    System.out.println("Returning to the Main menu... \n+++++++++++++++++++++++++");
                    endYesorNo = true;
                    return;
                } else {
                    System.out.println("Invalid choice! Please try again!");
                }
            }
    }
    }
}