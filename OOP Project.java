import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int i = 0;
        int k = 0;
        int choice = 0;
        int trash = 0;
        int recycle = 0;
        ArrayList<String> daysList = new ArrayList<>(); 
        ArrayList<String> prizesList = new ArrayList<>(); 

        System.out.println("-----Waste Management Tracker-----");
        System.out.println("Please Enter A Choice");
        System.out.println("1. Waste types");
        System.out.println("2. Waste Pickup Reminders ");
        System.out.println("3. Waste Tracker");
        System.out.println("4. Points/Rewards");
        System.out.println("5. Tips On Reducing Waste");
        System.out.println("6. Quit");
        choice = scan.nextInt();

        switch (choice) {
            case 1:
                System.out.println("---Waste Amount---");
                System.out.println("Please Select A Waste Type");
                System.out.println("1. Trash");
                System.out.println("2. Recycling");
                System.out.println("3. Back");
                choice = scan.nextInt();

                switch (choice) {
                    case 1:
                        System.out.println("You've thrown away waste " + trash + " times");
                        choice = 0;
                        break;

                    case 2:
                        System.out.println("You've thrown away recycling " + recycle + " times");
                        choice = 0;
                        break;

                    case 3:
                        choice = 0;
                        break;
                }
                break;

            case 2:
                System.out.println("---Waste Pickup Reminders---");
                System.out.println("1. View days");
                System.out.println("2. Set days");
                System.out.println("3. Back");
                choice = scan.nextInt();

                switch (choice) {
                    case 1:
                        if (daysList.size() != 0) {
                            for (int n = 0; n < daysList.size(); n++) {
                                System.out.println(daysList.get(n));
                            }
                        } else {
                            System.out.println("There are no days entered");
                        }
                        break;

                    case 2:
                        System.out.println("Enter days for trash pickup, enter Q to quit");
                        scan.nextLine();
                        String input = scan.nextLine();
                        while (!input.equals("Q")) { 
                            daysList.add(input);
                            input = scan.nextLine();
                        }
                        break;

                    case 3:
                        break;
                }
                break;

            case 3:
                System.out.println("---Waste Tracker---");
                System.out.println("1. Waste");
                System.out.println("2. Recycling");
                System.out.println("3. Back");
                choice = scan.nextInt();

                switch (choice) {
                    case 1:
                        System.out.println("Enter amount of total waste trashed: ");
                        trash = scan.nextInt();
                        break;

                    case 2:
                        System.out.println("Enter amount of total recycling trashed: ");
                        recycle = scan.nextInt();
                        break;

                    case 3:
                        break;
                }
                break;

            case 4:
                int total = trash + recycle; 
                System.out.println("---Points and Rewards---");
                System.out.println("1. Rules");
                System.out.println("2. Points");
                System.out.println("3. Rewards");
                System.out.println("4. Back");
                choice = scan.nextInt();

                switch (choice) {
                    case 1:
                        System.out.println("---Rules---");
                        System.out.println("Every piece of waste and recycling trashed will reward one point\n");
                        System.out.println("You can spend these points in the REWARDS section to claim a reward");
                        break;

                    case 2:
                        System.out.println("Total number of points: " + total);
                        break;

                    case 3:
                        System.out.println("---Rewards---");
                        System.out.println("1. View Available Rewards");
                        System.out.println("2. View Claimed Rewards");
                        System.out.println("3. Back");
                        choice = scan.nextInt();

                        switch (choice) {
                            case 1:
                                System.out.println("1. $20 Amazon gift card (100 points)");
                                System.out.println("2. Spotify Premium for 6 months (200 points)");
                                System.out.println("3. Netflix for a year (500 points)");
                                System.out.println("4. New Apple/Samsung Watch (1000 points)");
                                choice = scan.nextInt();

                                if ((choice == 1) && (total >= 100)) { 
                                    System.out.println("You have claimed the $20 Amazon Gift Card!");
                                    System.out.println("You now have " + (total - 100) + " points remaining!");
                                    prizesList.add("$20 Amazon Gift Card");
                                } else if ((choice == 1) && (total < 100)) {
                                    System.out.println("You dont have enough points to claim this prize!");
                                } else if ((choice == 2) && (total >= 200)) {
                                    System.out.println("You have claimed Spotify Premium for 6 months!");
                                    System.out.println("You now have " + (total - 200) + " points remaining!");
                                    prizesList.add("Spotify Premium for 6 months");
                                } else if ((choice == 2) && (total < 200)) {
                                    System.out.println("You dont have enough points to claim this prize!");
                                } else if ((choice == 3) && (total >= 500)) {
                                    System.out.println("You have claimed Netflix for a year!");
                                    System.out.println("You now have " + (total - 500) + " points remaining!");
                                    prizesList.add("Netflix for a year");
                                } else if ((choice == 3) && (total < 500)) {
                                    System.out.println("You dont have enough points to claim this prize!");
                                } else if ((choice == 4) && (total >= 1000)) {
                                    System.out.println("You have claimed the New Apple/Samsung Watch!");
                                    System.out.println("You now have " + (total - 1000) + " points remaining!");
                                    prizesList.add("New Apple/Samsung Watch");
                                } else if ((choice == 4) && (total < 1000)) {
                                    System.out.println("You dont have enough points to claim this prize!");
                                }
                                break;

                            case 2:
                                System.out.println("---Claimed Rewards---");
                                for (int j = 0; j < prizesList.size(); j++) {
                                    System.out.println(j + ". " + prizesList.get(j));
                                }
                                break;

                            case 3:
                                break;
                        }
                        break;

                    case 4:
                        break;
                }
                break;

            case 5:
                System.out.println("---Tips On Reducing Waste---");
                System.out.println("1. Use reusable shopping bags, water bottles, and travel mugs to avoid single-use plastics.");
                System.out.println("2. Buy in bulk, choose products with minimal packaging, and select items with recycled content.");
                System.out.println("3. Switch to paperless billing and digital receipts to reduce paper waste.");
                break;

            case 6:
                break;
        }

        scan.close(); 
    }
}