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
        // ++++++++++++++++++++++++++++++++++++++ Initialize stuff here^^^ +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
        // asks for month and day
        while (!endMonth) {
            System.out.println("Please enter the month (MM): ");
            while (!scanner.hasNextInt()) {
                System.out.println("Please enter the month's digits (MM)! Try Again!");
                scanner.next();
            }
            month = scanner.nextInt();
            if (month >= 01 && month <= 12) {
                endMonth = true;
            } else {
                System.out.println("Please enter an appropriate month! Try Again");
            }
        }
        // ++++++++++++++++++++++++++++++++++++++ Ending Month here ^^^ +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
        while (!endDay) {
            System.out.println("Please enter the date (DD): ");
            while (!scanner.hasNextInt()) {
                System.out.println("Please enter the day's digits (DD)! Try Again!");
                scanner.next();
            }
            day = scanner.nextInt();
            if (day >= 01 && day <= 31) {
                endDay = true;
            } else {
                System.out.println("Please enter an appropriate day! Try again!");
            }
        }
        // ++++++++++++++++++++++++++++++++++++++ Ending Day here ^^^ +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
        // saves those inputs into this LocalDate eventDate
        LocalDate alarmDate = LocalDate.of(LocalDate.now().getYear(), month, day);

        // if the user input a date that was in the past, the users won't be able to with this if statement and be asked again.
        if (alarmDate.isBefore(LocalDate.now())) {
            System.out.println("Invalid date! Please enter today's date or a future date.");
            viewAlarm(scanner);
            return;
        }
        // if there are events on the day, it will show all the events for it
        // SAVE THIS FOR THE MAIN FILE!!! WE NEED IT TO BE RED IN THE TERMINAL!
        if (!alarms.isEmpty()) {
            System.out.println("Alarms for " + alarmDate + ":");
            for (Alarm alarm : alarms) {
                if (alarm.getDate().equals(alarmDate)) {
                    System.out.println(alarm);
                }
            }
            // ++++++++++++++++++++++++++++++++++++++ Saving Alarms here ^^^ +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
            System.out.println("Would you like to add an alarm for this date? (yes/no)");
            String choice = scanner.next();
            boolean endYesorNo = false;
            while (!endYesorNo) {
                if ("yes".equalsIgnoreCase(choice)) {
                    addNewAlarm(scanner, alarmDate);
                    endYesorNo = true;
                } else if ("no".equalsIgnoreCase(choice)) {
                    System.out.println("Returning to the Main menu... \n+++++++++++++++++++++++++");
                    endYesorNo = true;
                    return;
                } else {
                    System.out.println("Invalid choice! Please try again! \n");
                }
            }
        } else {
            // if there are no events for that day...
            System.out.println("No alarms found for " + alarmDate + ".");
            System.out.println("Would you like to add an alarm for this date? (yes/no)");
            String choice = scanner.next();
            boolean endYesorNo = false;
            while (!endYesorNo) {
                if ("yes".equalsIgnoreCase(choice)) {
                    addNewAlarm(scanner, alarmDate);
                    endYesorNo = true;
                } else if ("no".equalsIgnoreCase(choice)) {
                    System.out.println("Returning to the Main menu... \n+++++++++++++++++++++++++");
                    endYesorNo = true;
                    return;
                } else {
                    System.out.println("Invalid choice! Please try again! \n");
                }
            }
        }
    }

    // ++++++++++++++++++++++++++++++++++++++ Ending View Alarms & Yes/No Options here ^^^ +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    // This is where users will continue their questionnaire to create their events on the day.
    // This is where useres are able to add a second date in which will be the duration of the alarm that will shine on the main menu with red! Make sure to edit
    private void addNewAlarm(Scanner scanner, LocalDate alarmDate) {
        // asks for month and day
        boolean endMonth2 = false;
        boolean endDay2 = false;
        int month2 = 0;
        int day2 = 0;
        // ++++++++++++++++++++++++++++++++++++++ Initialize stuff here^^^ +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
        // asks for month and day
        while (!endMonth2) {
            System.out.println("Please enter ANOTHER month (MM): ");
            while (!scanner.hasNextInt()) {
                System.out.println("Please enter the month's digits (MM)! Try Again!");
                scanner.next();
            }
            month2 = scanner.nextInt();
            if (month2 >= 01 && month2 <= 12) {
                endMonth2 = true;
            } else {
                System.out.println("Please enter an appropriate month! Try Again");
            }
        }
        // ++++++++++++++++++++++++++++++++++++++ Ending Months2 here ^^^ +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
        while (!endDay2) {
            System.out.println("Please enter ANOTHER date (DD): ");
            while (!scanner.hasNextInt()) {
                System.out.println("Please enter the day's digits (DD)! Try Again!");
                scanner.next();
            }
            day2 = scanner.nextInt();
            if (day2 >= 01 && day2 <= 31) {
                endDay2 = true;
            } else {
                System.out.println("Please enter an appropriate day! Try Again");
            }
        }
        // ++++++++++++++++++++++++++++++++++++++ Ending Days2 here ^^^ +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
        // saves those inputs into this LocalDate eventDate
        LocalDate alarmDate2 = LocalDate.of(LocalDate.now().getYear(), month2, day2);

        if (alarmDate2.isBefore(LocalDate.now())) {
            System.out.println("Invalid date! Please enter today's date or a future date.");
            addNewAlarm(scanner, alarmDate);
            return;
        }
        if (alarmDate2.isBefore(alarmDate)) {
            System.out.println("Please have your alarm duration be more than 0 days!");
            addNewAlarm(scanner, alarmDate);
            return;
        }
        // ++++++++++++++++++++++++++++++++++++++ Ending Alarm Checks of Current Date & Comapre here ^^^ +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
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
// ++++++++++++++++++++++++++++++++++++++ Ending Alarm Creation here ^^^ +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
