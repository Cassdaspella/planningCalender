import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class EventPlanner {

    public ArrayList<Event> events;

    public EventPlanner() {
        this.events = new ArrayList<>();
    }

    // This method will have users input a certain date to view an event from today or in the future.
    // If there is no event, it will ask if the user wants to add an event to that day.
    public void viewEvent(Scanner scanner) {
        // this is to check everything inside the saved arraylists ==> System.out.println(events.toString()); asks for month and day
        boolean endMonths = false;
        boolean endDays = false;
        int day = 0;
        int month = 0;
// ++++++++++++++++++++++++++++++++++++++ Initialize stuff here^^^ +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
        while (!endMonths) {
            System.out.println("Please enter the month (MM): ");
            while (!scanner.hasNextInt()) {
                System.out.println("Please enter the month's digits (MM)");
                scanner.next();
            }
            month = scanner.nextInt();
            if (month >= 01 && month <= 12) {
                endMonths = true;
            } else {
                System.out.println("Please enter an appropriate month!");
            }
        }
// ++++++++++++++++++++++++++++++++++++++ Months here ^^^ +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
        while (!endDays) {
            System.out.println("Please enter the date (DD): ");
            while (!scanner.hasNextInt()) {
                System.out.println("Please enter the day's digits (DD)");
                scanner.next();
            }
            day = scanner.nextInt();
            if (day >= 01 && day <= 31) {
                endDays = true;
            } else {
                System.out.println("Please enter an appropriate day! Please try again...");
            }
        }
// ++++++++++++++++++++++++++++++++++++++ Days here ^^^ +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
        // saves those inputs into this LocalDate eventDate
        LocalDate eventDate = LocalDate.of(LocalDate.now().getYear(), month, day);
        // if the user input a date that was in the past, the users won't be able to with this if statement and be asked again.
        if (eventDate.isBefore(LocalDate.now())) {
            System.out.println("Invalid date! Please enter today's date or a future date.");
            viewEvent(scanner);
            return;
        }
        // if there are events on the day, it will show all the events for it
        if (!events.isEmpty()) {
            System.out.println("Events for " + eventDate + ":");
            for (Event event : events) {
                if (event.getDate().equals(eventDate)) {
                    System.out.println(event);
                }
            }
// ++++++++++++++++++++++++++++++++++++++ Checking Events here ^^^ +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
            System.out.println("Would you like to add a new event for this date? (yes/no)");
            boolean endYesorNo = false;
            while (!endYesorNo) {
                String choice = scanner.next();
                if ("yes".equalsIgnoreCase(choice)) {
                    addNewEvent(scanner, eventDate);
                    endYesorNo = true;
                } else if ("no".equalsIgnoreCase(choice)) {
                    System.out.println("Returning to the Main menu... \n+++++++++++++++++++++++++");
                    endYesorNo = true;
                    return;
                } else {
                    System.out.println("Invalid choice! Please try again!");
                }
            }
        } else {
            // if there are no events for that day...
            System.out.println("No events found for " + eventDate + ".");
            System.out.println("Would you like to add a new event for this date? (yes/no)");
            boolean endYesorNo = false;
            while (!endYesorNo) {
                String choice = scanner.next();
                if ("yes".equalsIgnoreCase(choice)) {
                    addNewEvent(scanner, eventDate);
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

// ++++++++++++++++++++++++++++++++++++++ Ending Finding Events here ^^^ +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    // This is where users will continue their questionnaire to create their events on the day.
    private void addNewEvent(Scanner scanner, LocalDate eventDate) {
        boolean endPriority = false;
        int priority = 0;
        while (!endPriority) {
            System.out.println("Please enter the priority level (1-5) of the event: ");
            while (!scanner.hasNextInt()) {
                System.out.println("Please enter a number 1-5");
                scanner.next();
            }
            priority = scanner.nextInt();
            if (priority >= 1 && priority <= 5) {
                endPriority = true;
            } else {
                System.out.println("Please enter a number 1-5!");
            }
        }
// ++++++++++++++++++++++++++++++++++++++ Priority Stuff here ^^^ +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
        System.out.println("Please enter the title of the event: ");
        scanner.nextLine();
        String title = scanner.nextLine();
        System.out.println("Please enter the description of the event: ");
        String description = scanner.nextLine();
// ++++++++++++++++++++++++++++++++++++++ Entering Title and Descriptions here ^^^ +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
        Event event = new Event(eventDate, title, description, priority);
        // The event is saved into the events ArrayList
        events.add(event);
        sortEvents();
        System.out.println("Event added successfully!");
        System.out.println(event + "\n+++++++++++++++++++++++++");
        return;
        // Users are taken to the main menu
    }
    public void sortEvents() {
        Comparator<Event> priorityCompare = new Comparator<Event>() {
            public int compare(Event event1, Event event2) {
                return Integer.compare(event1.getPriority(), event2.getPriority());
            }
        };
        Collections.sort(events, priorityCompare);
    }
}
// ++++++++++++++++++++++++++++++++++++++ Ending the Creation of Events here ^^^ +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++