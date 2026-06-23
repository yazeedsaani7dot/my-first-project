import java.util.Scanner;

public class Main {
    
    public static void main(String[] args) {

        try (Scanner scan = new Scanner(System.in)) {
            System.out.println("=== WELCOME TO HOOP FRANCHISE ===");
            System.out.println("Select a gamemode: ");
            System.out.println("1. Scrimmage");
            System.out.println("2. MyPlayer");
            System.out.print("3. MyLeague");
            int gameMode = scan.nextInt();
            scan.nextLine();
            
            switch (gameMode) {
                //case 1 -> {
                    //System.out.print("- Opening Scrimmage Mode -");
                    //Scrimmage scrimmage = new Scrimmage();
                    //scrimmage.startGame();
                    //}
                    case 2 -> {
                    System.out.println("- Opening MyPlayer Career Mode -\n");
                    runMyPlayerCareer(scan);
                }
                //case 3 -> {
                // System.out.print("- Opening MyLeague Mode -");
                // MyLeague myLeague = new MyLeague();
                //myLeague.startGame();
                //}
                default -> System.out.print ("Invalid input. Please select a valid gamemode.");

            }
        }

    }

    //GAMEMODE 2: MyPLAYER
    public static void runMyPlayerCareer(Scanner scan){
        System.out.println("Welcome To MyPlayer Career Mode! This is where you can create your own player and take them through a career in the NBA. Let's start by creating your player!");
        System.out.println("Enter your player's name: ");
        String userName = scan.nextLine();
        System.out.print("Enter your player's position (PG, SG, SF, PF, C): ");
        String position = scan.nextLine();
        
        if(position.equals("PG") || position.equals("SG") || position.equals("SF") || position.equals("PF") || position.equals("C")) {
            System.out.println("You have selected " + position + " as your player's position.");
        } else {
            System.out.println("Invalid position. Please enter a valid position (PG, SG, SF, PF, C): ");
            position = scan.nextLine();
        }


        System.out.print("Enter your player's height in inches: ");
        int height = scan.nextInt();

        while ((position.equals("PG") && (height < 68 || height > 79))
                || (position.equals("SG") && (height < 72 || height > 81))
                || (position.equals("SF") && (height < 76 || height > 82))
                || (position.equals("PF") && (height < 78 || height > 84))
                || (position.equals("C") && (height < 80 || height > 90))) {
            switch (position) {
                case "PG" -> System.out.println("Invalid height for a Point Guard. Please enter a height between 68 and 79 inches.");
                case "SG" -> System.out.println("Invalid height for a Shooting Guard. Please enter a height between 72 and 81 inches.");
                case "SF" -> System.out.println("Invalid height for a Small Forward. Please enter a height between 76 and 82 inches.");
                case "PF" -> System.out.println("Invalid height for a Power Forward. Please enter a height between 78 and 84 inches.");
                case "C" -> System.out.println("Invalid height for a Center. Please enter a height between 80 and 90 inches.");
                default -> {
                }
            }
            height = scan.nextInt();
        }

        System.out.print("Enter your player's weight in pounds: ");
        int weight = scan.nextInt();

while ((position.equals("PG") && (weight < 175 || weight > 230))
                || (position.equals("SG") && (weight < 185 || weight > 240))
                || (position.equals("SF") && (weight < 200 || weight > 255))
                || (position.equals("PF") && (weight < 225 || weight > 275))
                || (position.equals("C") && (weight < 255 || weight > 310))) {
            switch (position) {
                case "PG" -> System.out.println("Invalid weight for a Point Guard. Please enter a weight between 175 and 230 pounds.");
                case "SG" -> System.out.println("Invalid weight for a Shooting Guard. Please enter a weight between 185 and 240 pounds.");
                case "SF" -> System.out.println("Invalid weight for a Small Forward. Please enter a weight between 200 and 255 pounds.");
                case "PF" -> System.out.println("Invalid weight for a Power Forward. Please enter a weight between 225 and 275 pounds.");
                case "C" -> System.out.println("Invalid weight for a Center. Please enter a weight between 255 and 310 pounds.");
                default -> {
                }
            }
        weight = scan.nextInt();
                }



        //Part 2: PLAYER STATS
        System.out.println("Now let's set your player's stats. You have 20 points to distribute among the following attributes: Shooting, Passing, Defense, and Athleticism.");
        System.out.println("Since you are a " + height + " " + position + ", you will have a bonus of 2 points to distribute in your primary attribute.");
        int totalPoints = 20;
        int shooting = 0;
        int passing = 0;
        int defense = 0; 
        int athleticism = 0; 

            switch (position) {
                case "PG" -> {
                    System.out.println("Your primary attribute is Passing.");
                    passing += 2;
                }
                case "SG" -> {
                    System.out.println("Your primary attribute is Shooting.");
                    shooting += 2;
                }
                case "SF" -> {
                    System.out.println("Your primary attribute is Athleticism.");
                    athleticism += 2;
                }
                case "PF" -> {
                    System.out.println("Your primary attribute is Defense.");
                    defense += 2;
                }
                case "C" -> {
                    System.out.println("Your primary attribute is Defense.");
                    defense += 2;
                }
                default -> {
                }
            }

        while(passing >= 0 || shooting >= 0 || defense >= 0 || athleticism >= 0) {

          if (shooting >= 10 )if(passing >= 10) {
              System.out.println("You have reached the maximum points for Passing. Please allocate points to other attributes.");
              passing -= scan.nextInt();
              totalPoints += passing;
              continue;
          } else if(defense >= 10) {
              System.out.println("You have reached the maximum points for Defense. Please allocate points to other attributes.");
              defense -= scan.nextInt();
              totalPoints += defense;
              continue;
          } else if(athleticism >= 10) {
              System.out.println("You have reached the maximum points for Athleticism. Please allocate points to other attributes.");
              athleticism -= scan.nextInt();
              totalPoints += athleticism;
              continue;
          } else {
              System.out.println("You have reached the maximum points for Shooting. Please allocate points to other attributes.");
              shooting -= scan.nextInt();
              totalPoints += shooting;
              continue;
                }
            System.out.println("You have " + totalPoints + " points remaining to distribute.");
            System.out.print("Enter points to allocate to Shooting: ");
            shooting += scan.nextInt();
            totalPoints -= shooting;
            if(totalPoints < 0) {
                System.out.println("You have exceeded the total points available. Please try again.");
                shooting -= scan.nextInt();
                totalPoints += shooting;
                continue;
            }

            System.out.print("Enter points to allocate to Passing: ");
            passing += scan.nextInt();
            totalPoints -= passing;
            if(totalPoints < 0) {
                System.out.println("You have exceeded the total points available. Please try again.");
                passing -= scan.nextInt();
                totalPoints += passing;
                continue;
            }

            System.out.print("Enter points to allocate to Defense: ");
            defense += scan.nextInt();
            totalPoints -= defense;
            if(totalPoints < 0) {
                System.out.println("You have exceeded the total points available. Please try again.");
                defense -= scan.nextInt();
                totalPoints += defense;
                continue;
            }

            System.out.print("Enter points to allocate to Athleticism: ");
            athleticism += scan.nextInt();
            totalPoints -= athleticism;
            if(totalPoints < 0) {
                System.out.println("You have exceeded the total points available. Please try again.");
                athleticism -= scan.nextInt();
                totalPoints += athleticism;
                continue;
            }

        }
        


}

}