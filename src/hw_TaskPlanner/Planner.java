package hw_TaskPlanner;

import java.util.Scanner;

public class Planner {
    static String[][] schedule = new String[7][2];

    static final String EXIT = "exit";
    static final int WRONG_INPUT_CODE = -1;
    static final int EXIT_CODE = -2;
    static boolean exit_flag = false;

    public static void main(String[] args) {
        initializeSchedule();

        while (!exit_flag) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Please, input the day of the week:");
            String userInput = scanner.nextLine();

            int dayOfWeek = parseUserInput(userInput);

            System.out.println(getDayPlans(dayOfWeek));
        }

    }

    static void initializeSchedule() {
        schedule[0][0] = "Sunday";
        schedule[0][1] = "do home work";
        schedule[1][0] = "Monday";
        schedule[1][1] = "go to courses; watch a film";
        schedule[2][0] = "Tuesday";
        schedule[3][0] = "Wednesday";
        schedule[4][0] = "Thursday";
        schedule[5][0] = "Friday";
        schedule[6][0] = "Saturday";
    }

    static String getDayPlans(int dayIdx) {
        switch (dayIdx) {
            case (WRONG_INPUT_CODE):
                return "Sorry, I don't understand you, please try again.";

            case (EXIT_CODE):
                exit_flag = true;
                return "Program will be stopped.";

            default:
                return String.format("Your tasks for %s: %s.", schedule[dayIdx][0], schedule[dayIdx][1]);
        }
    }

    static int parseUserInput(String userInput) {
        if (userInput.equalsIgnoreCase(EXIT)) {
            return EXIT_CODE;
        }

        return getDayOfWeekIdx(userInput);
    }

    static int getDayOfWeekIdx(String userInput) {
        for (int i = 0; i < schedule.length; i++) {
            if (schedule[i][0] != null && schedule[i][0].equalsIgnoreCase(userInput.trim())) {
                return i;
            }
        }

        return -1;
    }
}
