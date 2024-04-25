import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class EventPlanner {

    public ArrayList<Event> events;

    public EventPlanner() {
        this.events = new ArrayList<>();
    }

    // This method will have users input a certain date to view an event from today or in the future.
    // If there is no event, it will ask if the user wants to add an event to that day.
    public void viewEvent(Scanner scanner) {
        // this is to check everything inside the saved arraylists ==> System.out.println(events.toString());
        // asks for month and day
        System.out.println("Please enter the month (MM): ");
        while (!scanner.hasNextInt()){
            System.out.println("Please enter the month's digits (MM)");
            scanner.next();
        }
        int month = scanner.nextInt();
        if (month < 00 || month > 12) {
            System.out.println("Please enter an appropriate month!");
            viewEvent(scanner);
        }

        System.out.println("Please enter the date (DD): ");
        while (!scanner.hasNextInt()){
            System.out.println("Please enter the day's digits (DD)");
            scanner.next();
        }
        int day = scanner.nextInt();
        if (day < 00 || day > 31) {
            System.out.println("Please enter an appropriate day! Restarting...");
            viewEvent(scanner);
        }

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

            System.out.println("Would you like to add a new event for this date? (yes/no)");
            String choice = scanner.next();

            if ("yes".equalsIgnoreCase(choice)) {
                addNewEvent(scanner, eventDate);
            } else if ("no".equalsIgnoreCase(choice)) {
                System.out.println("Returning to the Main menu...");
                return;
            } else {
                System.out.println("Invalid choice! Please try again! \n");
                viewEvent(scanner);
            }
        } else {
            // if there are no events for that day...
            System.out.println("No events found for " + eventDate + ".");
            System.out.println("Would you like to add a new event for this date? (yes/no)");
            String choice = scanner.next();
            if ("yes".equalsIgnoreCase(choice)) {
                addNewEvent(scanner, eventDate);
            } else if ("no".equalsIgnoreCase(choice)) {
                System.out.println("Returning to the Main menu...");
                return;
            } else {
                System.out.println("Invalid choice! Please try again! \n");
                viewEvent(scanner);
            }
        }
    }

    // This is where users will continue their questionnaire to create their events on the day.
    private void addNewEvent(Scanner scanner, LocalDate eventDate) {
        System.out.println("Please enter the priority level (1-5) of the event: ");
        while (!scanner.hasNextInt()){
            System.out.println("Please enter a number 1-5");
            scanner.next();
        }
        int priority = scanner.nextInt();
        if (priority < 0 || priority > 5) {
            addNewEvent(scanner, eventDate);
            return;
        }
        System.out.println("Please enter the title of the event: ");
        scanner.nextLine();
        String title = scanner.nextLine();
        System.out.println("Please enter the description of the event: ");
        String description = scanner.nextLine();
        Event event = new Event(eventDate, title, description, priority);
        // The event is saved into the events ArrayList
        events.add(event);
        System.out.println("Event added successfully!");
        System.out.println(event);
        return;
        // Users are taken to the main menu
    }

    /*  This displays the events
    public void displayEvents() {
        System.out.println("Events:");
        if (events.isEmpty()) {
            System.out.println("No events added yet.");
        } else {
            for (Event event : events) {
                System.out.println(event);
            }
        }
    }
    */
}
