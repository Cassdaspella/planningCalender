import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class AlarmPlanner {
    public ArrayList<Alarm> alarms;

    public AlarmPlanner() {
        this.alarms = new ArrayList<>();
    }
    public void viewAlarm(Scanner scanner) {
        boolean endMonth = false;
        boolean endDay = false;
        int month = 0;
        int day = 0;
        // asks for month and day
        while(!endMonth){
        System.out.println("Please enter the month (MM): ");
        while (!scanner.hasNextInt()){
            System.out.println("Please enter the month's digits (MM)");
            scanner.next();
        }
        month = scanner.nextInt();
        if (month >= 01 && month <= 12) {
            endMonth = true;
        }
        else {
            System.out.println("Please enter an appropriate month!");
        }
    }
        while (!endDay){
        System.out.println("Please enter the date (DD): ");
        while (!scanner.hasNextInt()){
            System.out.println("Please enter the day's digits (DD)");
            scanner.next();
        }
        day = scanner.nextInt();
        if (day >= 01 && day <= 31) {
            endDay = true;
        }
        else {
            System.out.println("Please enter an appropriate day! Restarting...");
        }
    }
        // saves those inputs into this LocalDate eventDate
        LocalDate alarmDate = LocalDate.of(LocalDate.now().getYear(), month, day);

        // if the user input a date that was in the past, the users won't be able to with this if statement and be asked again.
        if (alarmDate.isBefore(LocalDate.now())) {
            System.out.println("Invalid date! Please enter today's date or a future date.");
            viewAlarm(scanner);
        }
        // if there are events on the day, it will show all the events for it
        //SAVE THIS FOR THE MAIN FILE!!! WE NEED IT TO BE RED IN THE TERMINAL!
        if (!alarms.isEmpty()) {
            System.out.println("Alarms for " + alarmDate + ":");
            for (Alarm alarm : alarms) {
                if (alarm.getDate().equals(alarmDate)) {
                    System.out.println(alarm);
                }
            }

            System.out.println("Would you like to add an alarm for this date? (yes/no)");
            String choice = scanner.next();

            if ("yes".equalsIgnoreCase(choice)) {
                addNewAlarm(scanner, alarmDate);
            } else if ("no".equalsIgnoreCase(choice)) {
                System.out.println("Returning to the Main menu...");
                return;
            } else {
                System.out.println("Invalid choice! Please try again! \n");
                viewAlarm(scanner);
            }
        } else {
            // if there are no events for that day...
            System.out.println("No events found for " + alarmDate + ".");
            System.out.println("Would you like to add an alarm for this date? (yes/no)");
            String choice = scanner.next();
            if ("yes".equalsIgnoreCase(choice)) {
                addNewAlarm(scanner, alarmDate);
            } else if ("no".equalsIgnoreCase(choice)) {
                System.out.println("Returning to the Main menu...");
                return;
            } else {
                System.out.println("Invalid choice! Please try again! \n");
                viewAlarm(scanner);
            }
        }
    }
    // This is where users will continue their questionnaire to create their events on the day.
    // This is where useres are able to add a second date in which will be the duration of the alarm that will shine on the main menu with red! Make sure to edit
    private void addNewAlarm(Scanner scanner, LocalDate alarmDate) {
         // asks for month and day
        System.out.println("Please enter another month (MM): ");
        while (!scanner.hasNextInt()){
            System.out.println("Please enter the month's digits (MM)");
            scanner.next();
        }
        int month2 = scanner.nextInt();
        if (month2 < 00 || month2 > 12) {
            System.out.println("Please enter an appropriate month!");
            addNewAlarm(scanner,alarmDate);
        }

        System.out.println("Please enter another date (DD): ");
        while (!scanner.hasNextInt()){
            System.out.println("Please enter the day's digits (DD)");
            scanner.next();
        }
        int day2 = scanner.nextInt();
        if (day2 < 00 || day2 > 31) {
            System.out.println("Please enter an appropriate day! Restarting...");
            addNewAlarm(scanner,alarmDate);
        }

         // saves those inputs into this LocalDate eventDate
        LocalDate alarmDate2 = LocalDate.of(LocalDate.now().getYear(), month2, day2);

        if (alarmDate2.isBefore(LocalDate.now())) {
            System.out.println("Invalid date! Please enter today's date or a future date.");
            viewAlarm(scanner);
        }

         // if the user input a date that was in the past, the users won't be able to with this if statement and be asked again.
        if (alarmDate.isBefore(LocalDate.now())) {
            System.out.println("Invalid date! Please enter today's date or a future date.");
            addNewAlarm(scanner,alarmDate);
        }
        System.out.println("Please enter the title of the event: ");
        scanner.nextLine();
        String title = scanner.nextLine();
        Alarm alarm = new Alarm(alarmDate, title, alarmDate2);
        // The event is saved into the events ArrayList
        alarms.add(alarm);
        System.out.println("Alarm added successfully!");
        System.out.println(alarm);
        return;
        // Users are taken to the main menu
    }
}