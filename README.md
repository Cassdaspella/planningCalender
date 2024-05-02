# planningCalender
A Terminal-Based Planning Calender
(Yes I realize that I have been misspelling Calendar this entire time)

option 1: Event Planner

- Event Planner allows users to input a date and if the date is acceptable by the terminal, it shows if there are any events for that date and if users would like to add an event for the day.
- The events that are shown should be sorted by priority and only the inputted date events should be visible!
    -  Testing
        - make sure input dates cannot be out of bounds
        - make sure events created for the dates are placed on the correct dates
        - make sure sorts are priority based with the 1st priority being at the top
    
option 2: Alarm Planner

- Alarm Planner allows users to input a date (just like Event Planner) and shows any alarms for that day (if there are any).
- Users can also add an event but input another date on the same day or have a longer duration.
- And all alarms should be visible on the day they are presented! Duch as if the alarm was due today, it will show up in the Main Menu.
    - Testing
        - make sure that the alarm dates cannot be out of bounds
        - make sure that when creating the alarms, the alarm is bright red on your screen and shown on the main screen
        - make sure that the 2nd phase for alarms is also not out of bounds
      
option 3: Month Viewer
- Month Viewer allows users to see the full month of Alarms and Events that are taking place. It will notify the users if an alarm or event is not created on the month and encourage them to do so.
- The events and alarms should be sorted mainly by date and then the priorities within those dates.
    - Testing
        - make sure it shows all the events you have created for that month
        - make sure no other month is displayed on the month you inputted
        - make sure that although it is priority-based, it is also date based too!
   
Extra Details:
- Priorities are colored! 1 - red, 2 - yellow, 3 - green, 4 - blue, 5 - purple.
- Months are displayed in the Month Viewer as a String and not the Integers: ex (1 - January, 2 - February, etc etc.)
