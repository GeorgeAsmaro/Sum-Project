import java.util.Random;
import java.util.Scanner;
import java.util.ArrayList;

public class OptimalStopping {

    static int maxAttempts = 10;
    static boolean accept;
    static Random rand = new Random();
    static Scanner input = new Scanner(System.in);
    static ArrayList<Integer> approved = new ArrayList<>();
    static ArrayList<Integer> rejected = new ArrayList<>();

    public static void main(String[] args) {
        ratingGenerator();
        getRatingTotal();
        rejectionRating();
        getApprovalRate();
    }

    public static void ratingGenerator() {
        int rating;
        for(int i = 0; i < maxAttempts; i++) {
            rating = rand.nextInt(10)+1;
            if(rating >= 5) {
                approved.add(rating);
            }
            else {
                rejected.add(rating);
            }
        }
    }

    public static void rejectionRating() {
        int totalRejectionRating = 0;
        for(Integer integer : rejected) {
            totalRejectionRating += integer;
        }

        System.out.println("Average Rejected Rating: " + totalRejectionRating/rejected.size());
    }

    public static void getRatingTotal() {
        int totalAccepted = 0;
        for (Integer integer : approved) {
            System.out.println(integer);
            totalAccepted += integer;
        }

        System.out.println("Total: " + totalAccepted);
        System.out.println("Average Accepted: " + (double) totalAccepted /approved.size());
    }

    public static void getApprovalRate() {
        System.out.println("Approval Rate: " + (double)approved.size()/maxAttempts*100 + "%");
    }

}
