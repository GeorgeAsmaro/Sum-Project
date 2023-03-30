import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class BirthdayProblem {

    static int people;
    static int numTrue = 0;
    static int numExperiments = 0;
    static int numExpTBD;
    static boolean sameBirthday = false;
    static boolean finished = false;

    public static void main(String[] args) {
        Random rand = new Random();
        Scanner scan = new Scanner(System.in);
        ArrayList<Integer> arrayList = new ArrayList<>();
        while(!finished) {
            try {
                numExperiments = 0;
                numExpTBD = 0;
                numTrue = 0;
                sameBirthday = false;

                System.out.println("Enter the number of people in the room");
                people = scan.nextInt();

                System.out.println("Enter number of experiments to be done");
                numExpTBD = scan.nextInt();

                for (int i = 0; i < numExpTBD; i++) {
                    numExperiments++;
                    int index = 0;
                    sameBirthday = false;
                    for (int k = 0; k < people; k++) {
                        int test = rand.nextInt(365);
                        arrayList.add(test);
                    }

                    try {
                        while (!sameBirthday) {
                            for (int j = 0; j < arrayList.size(); j++) {
                                if (arrayList.get(index).equals(arrayList.get(j)) && index != j) {
                                    sameBirthday = true;
                                    numTrue++;
                                    break;
                                }
                            }
                            index++;
                        }
                    } catch (IndexOutOfBoundsException ignored) {
                    }
                    //System.out.println(sameBirthday);
                    arrayList.clear();
                }
                double percentage = (double) numTrue / numExpTBD * 100.0;
                System.out.println("Chance for at least 1 person to share the same birthday: " + percentage + "%\n");

                System.out.println("Try again?\n");
                System.out.println("1. Yes");
                System.out.println("2. No");
                int retry = scan.nextInt();

                finished = retry != 1;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Enter an integer");
                scan.nextLine();
            }

        }
    }
}
