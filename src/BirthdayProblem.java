import java.util.ArrayList;
import java.util.Random;

public class BirthdayProblem {

    static int people = 2;
    static boolean sameBirthday = false;

    public static void main(String[] args) {
        Random rand = new Random();
        ArrayList<Integer> arrayList = new ArrayList<>();

        int index = 0;

        for(int i = 0; i < people; i++) {
            int test = rand.nextInt(365);
            arrayList.add(test);
        }
        while(!sameBirthday) {
            for(int i = 0; i < arrayList.size(); i++) {
                if (arrayList.get(index).equals(arrayList.get(i))) {
                    sameBirthday = true;
                    break;
                }
            }
            index++;
        }

        System.out.println(sameBirthday);
        

    }
}
