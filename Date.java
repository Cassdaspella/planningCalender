import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Date {
    public static void main(String[] args) {
        EventPlanner events = new EventPlanner();
        AlarmPlanner alarms = new AlarmPlanner();
        boolean end = false;
        while (!end){
//this grabs the current date
        LocalDate today = currentDate();
        System.out.println("Today's date is: " + today.format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));

// Check and display alarms for today
        displayAlarmsForToday(alarms, today);
        System.out.println("Hello and welcome to your Planning Calculator! \n\nPlease choose from the following options:");
        Scanner scanner = new Scanner(System.in);
        boolean validInput = false;
// asks users for a int option of 1-4 of the following:
        while (!validInput) {
            // save for later for events tostring ==> System.out.println(events.toString());
            System.out.println("   1. Add/View Events\n   2. Add Alarm\n   3. View a certain month\n   4. Exit Calender   ");

            String numInput = scanner.next();

            if (numInput.equals("1")) {
                validInput = true;
                events.viewEvent(scanner);
                //Perform action for option 1
            }
            else if (numInput.equals("2")) {
                validInput = true;
                alarms.viewAlarm(scanner);
                // Perform action for option 2
            }
            else if (numInput.equals("3")) {
                validInput = true;
                System.out.println("THIS AREA IS A WIP");
                // Perform action for option 3
            }
            else if (numInput.equals("4")) {
                validInput = true;
                end = true;
                System.out.println("Exiting Calender...");
                scanner.close();
                return;
                //Perform action for option 4
            }
            else {
                System.out.println("That isn't an option! Please try again");
            }
        }
    }
    }
    public static LocalDate currentDate() {
        return LocalDate.now();
    }
//grabs current date
    public static void displayAlarmsForToday(AlarmPlanner alarms, LocalDate today) {
        if (!alarms.alarms.isEmpty()) {
            System.out.println("\nAlarms for today:");
            for (Alarm alarm : alarms.alarms) {
                if (today.equals(alarm.getDate())) {
                    System.out.println(alarm.toString());
                }
            }
        }
    }
}
