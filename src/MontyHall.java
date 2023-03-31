import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;

public class MontyHall {

    static Scanner input = new Scanner(System.in);
    static Random rand = new Random();

    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();

        list.add("1. Box 1");
        list.add("2. Box 2");
        list.add("3. Box 3");

        boolean box1 = false;
        boolean box2 = false;
        boolean box3 = false;

        int timesRan = 0;
        int correctBoxChosen = 0;
        int incorrectBoxChosen = 0;



        if(rand.nextInt(3) + 1 == 1) {
            box1 = true;
        }
        else if(rand.nextInt(3) + 1 == 2) {
            box2 = true;
        }
        else {box3 = true;}

        for (String string : list) {
            System.out.println(string);
        }

        System.out.println("2 of these boxes are empty, and 1 has a prize. Pick one that you think has the prize");

        int boxChosen = input.nextInt();

            if(boxChosen == 1 && !box3) {
                list.remove(2);
                System.out.println("You have chosen box 1. Box 3 has been removed as it is empty. Would you like to switch your box?");
            }

            if(boxChosen == 1 && !box2) {
                list.remove(1);
                System.out.println("You have chosen box 1. Box 2 has been removed as it is empty. Would you like to switch your box?");
            }

            System.out.println("1. Yes");
            System.out.println("2. No");

            int switchBox = input.nextInt();

            if(switchBox == 1) {
                if(box2) {
                    System.out.println("You have switched and chosen the correct box");
                    correctBoxChosen++;
                }
                else {
                    System.out.println("You have switched and chosen the wrong box");
                    incorrectBoxChosen++;
                }
            }
            if(switchBox == 2) {
                if(box1) {
                    System.out.println("You chose to keep your box, which was the correct box");
                    correctBoxChosen++;
                }
                else {
                    System.out.println("You chsoe to keep your box, which was the incorrect box");
                    incorrectBoxChosen++;
                }
            }
    }

    public static void dontSwitch() {

    }

    public static void switchBox() {

    }
}
