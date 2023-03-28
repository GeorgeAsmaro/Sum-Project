import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Random;

public class Main {
    public static void main(String[] args) {

        boolean finished = false;
        while(!finished) {
            try {
                Scanner input = new Scanner(System.in);
                System.out.println("Enter 1 for calculating the sum of a range that you choose\n");
                System.out.println("Enter 2 for calculating the sum of a range chosen with a random numbers generated");
                int choice = input.nextInt();
                switch (choice) {
                    case 1 -> {
                        System.out.println("Enter the starting number you would like to calculate the sum of the range");
                        int sumCalculationStart = input.nextInt();
                        System.out.println("Enter the ending number you would like to calculate the sum of the range");
                        int sumCalculationEnd = input.nextInt();
                        System.out.println(getTotalSum(sumCalculationStart, sumCalculationEnd));
                        finished = true;
                    }
                    case 2 -> {
                        System.out.println("Enter min integer to generate from");
                        int min = input.nextInt();

                        System.out.println("Enter max integer to generate from");
                        int max = input.nextInt();

                        System.out.println("Enter the amount of integers you would like to randomly generate");
                        int amount = input.nextInt();

                        System.out.println("Total Sum: " + randomNumSum(min, max, amount));
                        finished = true;
                    }
                    default -> System.out.println("Incorrect Input. Try Again\n");
                }
            }
            catch(InputMismatchException exception) {
                System.out.println("Incorrect Input. Try again\n");
            }
        }
    }

    public static int getTotalSum(int rangeStart, int rangeEnd) {
        int totalSum = 0;

        if(rangeEnd < rangeStart) {
            int tempRand2 = rangeEnd;
            rangeEnd = rangeStart;
            rangeStart = tempRand2;
        }

        int start = rangeStart;
        for(int i = rangeStart; i <= rangeEnd; i++) {
               totalSum += start;
               start++;
        }
        return totalSum;
    }

    public static int randomNumSum(int randRange1, int randRange2, int numsToGenerate) {
        int totalSum = 0;

        if(randRange2 < randRange1) {
            int tempRand2 = randRange2;
            randRange2 = randRange1;
            randRange1 = tempRand2;
        }

        ArrayList<Integer> arrayList = new ArrayList<>();
        Random rand = new Random();


        for(int i = 0; i < numsToGenerate; i++) {
            arrayList.add(rand.nextInt(randRange2 - randRange1 + 1) + randRange1);
        }

        int size = arrayList.size();


        for (Integer integer : arrayList) {
            System.out.println(integer);
            totalSum += integer;
        }


        int mostCommon = findMostCommonElement(arrayList);
        System.out.println("Most common element: " + findMostCommonElement(arrayList));
        System.out.println("Average number: " + findAverageDataProduced(size, totalSum));
        System.out.println("Percentage common num appeared: " + findPercentageOfData(mostCommon, arrayList, size) + "%");
        return totalSum;
    }

    // What is the most common value in the output data?
    public static int findMostCommonElement(ArrayList<Integer> list) {
        int mostCommonElement = list.get(0);
        int maxCount = 0;

        for (int i = 0; i < list.size(); i++) {
            int currentElement = list.get(i);
            int count = 0;

            for (Integer integer : list) {
                if (currentElement == integer) {
                    count++;
                }
            }

            if (count > maxCount) {
                maxCount = count;
                mostCommonElement = currentElement;
            }
        }
        return mostCommonElement;
    }

    // What is the average of all data produced?
    public static double findAverageDataProduced(int length, int total){
        // Iterate through the list of data
        return (double)total/length;
    }

    // What % of the time did the most common value appear?
    public static double findPercentageOfData(int mostCommon, ArrayList<Integer> listToSearch, int length) {
        int amountInList = 0;
        for (Integer toSearch : listToSearch) {
            if (toSearch == mostCommon) {
                amountInList++;
            }
        }
        return (double)amountInList/length*100;
    }
}