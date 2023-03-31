import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;

public class MontyHall {

    static Scanner input = new Scanner(System.in);
    static Random rand = new Random();

    public static void main(String[] args) {
        dontSwitch();
        switchBox();
    }

    public static void dontSwitch() {
        System.out.println("Case 1: You choose an intial box and you don't change your answer.\nEnter number of generations");
        int numGenerations = input.nextInt();

        int correctBoxChosen = 0;
        int incorrectBoxChosen = 0;

        for(int i = 0; i < numGenerations; i++) {
            ArrayList<String> list = new ArrayList<>();

            list.add("1. Box 1");
            list.add("2. Box 2");
            list.add("3. Box 3");

            boolean box1 = false;
            boolean box2 = false;
            boolean box3 = false;

            int randBox = rand.nextInt(3)+1;

            if(randBox == 1) {box1 = true;}
            if(randBox == 2) {box2 = true;}
            if(randBox == 3) {box3 = true;}

            if(!box3) {
                list.remove(2);
            }
            if(!box2) {
                list.remove(1);
            }

            if(box1) {
                correctBoxChosen++;
            }
            else {
                incorrectBoxChosen++;
            }
            list.clear();
        }

        int total = correctBoxChosen + incorrectBoxChosen;
        double percentage = (double) correctBoxChosen / total * 100.0;
        System.out.println("Percentage of success without switching the box chosen: " + percentage + "%");
    }

    public static void switchBox() {
        System.out.println("Case 2: You choose an initial box but change your answer once one is removed.\nEnter number of generations");
        int numGenerations = input.nextInt();

        int correctBoxChosen = 0;
        int incorrectBoxChosen = 0;

        for(int i = 0; i < numGenerations; i++) {
            ArrayList<String> list = new ArrayList<>();

            list.add("1. Box 1");
            list.add("2. Box 2");
            list.add("3. Box 3");

            boolean box1 = false;
            boolean box2 = false;
            boolean box3 = false;

            int randBox = rand.nextInt(3)+1;

            if(randBox == 1) {box1 = true;}
            if(randBox == 2) {box2 = true;}
            if(randBox == 3) {box3 = true;}

            if(!box3) {
                list.remove(2);

                if(box2) {
                    correctBoxChosen++;
                }
                else {
                    incorrectBoxChosen++;
                }
            }
            if(!box2) {
                list.remove(1);

                if(box3) {
                    correctBoxChosen++;
                }
                else {
                    incorrectBoxChosen++;
                }
            }
            list.clear();
        }

        int total = correctBoxChosen + incorrectBoxChosen;
        double percentage = (double) correctBoxChosen / total * 100.0;
        System.out.println("Percentage of success switching the box after one is removed: " + percentage + "%");
    }
}
