import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Date {
    public static void main(String[] args) {
        EventPlanner events = new EventPlanner();
        boolean end = false;
        while (!end){
//this grabs the current date
        currentDate();
        
        System.out.println("Hello and welcome to your Planning Calculator! \n\nPlease choose from the following options:");
        
        Scanner scanner = new Scanner(System.in);
        boolean validInput = false;
        
        System.out.println(events.toString());
// asks users for a int option of 1-4 of the following:
        while (!validInput) {
            System.out.println(events.toString());
            System.out.println("   1. Add/View Events\n   2. Add Alarm\n   3. View a certain month\n   4. Exit Calender   ");

            String numInput = scanner.next();

            if (numInput.equals("1")) {
                validInput = true;
                System.out.println(events.toString());
                events.viewEvent(scanner);
                //Perform action for option 1
            }
            else if (numInput.equals("2")) {
                validInput = true;
                System.out.println("THIS AREA IS A WIP");
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
//grabs current date
    public static void currentDate() {
        LocalDate currentDate = LocalDate.now();
        
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        
        String formattedDate = currentDate.format(formatter);
        
        System.out.println("Today's date is: " + formattedDate);
    }
}
