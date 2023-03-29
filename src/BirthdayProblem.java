import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class BirthdayProblem {

    static int people;
    static int numTrue = 0;
    static int numExperiments = 0;
    static boolean sameBirthday = false;

    public static void main(String[] args) {
        Random rand = new Random();
        Scanner scan = new Scanner(System.in);
        ArrayList<Integer> arrayList = new ArrayList<>();

        System.out.println("Enter the number of people in the room");
        people = scan.nextInt();

        System.out.println("Enter number of experiments to be done");
        int numExpTBD = scan.nextInt();

        for(int i = 0; i < numExpTBD; i++) {
            numExperiments++;
            int index = 0;
            sameBirthday = false;
            for(int h = 0; h < people; h++) {
                int test = rand.nextInt(365);
                arrayList.add(test);
            }

            try {
                while(!sameBirthday) {
                    for(int j = 0; j < arrayList.size(); j++) {
                        if (arrayList.get(index).equals(arrayList.get(j)) && index != j) {
                            sameBirthday = true;
                            numTrue++;
                            break;
                        }
                    }
                    index++;
                }
            }
            catch (IndexOutOfBoundsException ignored) {}
            System.out.println(sameBirthday);
            arrayList.clear();
        }
        double percentage = (double)numTrue / numExpTBD * 100.0;
        System.out.println("Chance for at least 1 person to share the same birthday: " + percentage + "%");

    }
}
