import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class BirthdayProblem {

    static int people = 366;
    static int numTrue = 0;
    static int numExperiments = 0;
    static boolean sameBirthday = false;

    public static void main(String[] args) {
        Random rand = new Random();
        Scanner scan = new Scanner(System.in);
        ArrayList<Integer> arrayList = new ArrayList<>();

        System.out.println("Enter number of experiments to be done");
        int numExpTBD = scan.nextInt();

        for(int i = 0; i < numExpTBD; i++) {
            numExperiments++;
            int index = 0;

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
            catch (IndexOutOfBoundsException exception) {
                System.out.println("No duplicates");
            }

            System.out.println(sameBirthday);
        }

        System.out.println((double)numTrue/numExperiments*100);



    }
}
