import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void print(AQueue<Integer> temp) {
        // System.out.println("temp l "+temp.length());
        ArrayList<Integer> arr = new ArrayList<Integer>();
        // System.out.println(temp.frontValue());
        while (true) {
            if (temp.length() == 0) {
                break;
            }
            // System.out.println(this.length());
            Integer t = temp.dequeue();
            arr.add(t);

        }
        // System.out.println(temp.frontValue());
        // temp.clear();
        System.out.print("<");
        for (int i = 0; i < arr.size(); i++) {
            System.out.print(arr.get(i) + " ");
        }
        System.out.print(">");
        System.out.println("");
        for (int i = 0; i < arr.size(); i++) {
            temp.enqueue(arr.get(i));
        }
        // System.out.println("frontvalue "+temp.front.next().element());
    }

    public static void print(LQueue<Integer> temp) {
        // System.out.println("temp l "+temp.length());
        ArrayList<Integer> arr = new ArrayList<Integer>();
        // System.out.println(temp.frontValue());
        while (true) {
            if (temp.length() == 0) {
                break;
            }
            // System.out.println(this.length());
            Integer t = temp.dequeue();
            arr.add(t);

        }
        // System.out.println(temp.frontValue());
        // temp.clear();
        System.out.print("<");
        for (int i = 0; i < arr.size(); i++) {
            System.out.print(arr.get(i) + " ");
        }
        System.out.print(">");
        System.out.println("");
        for (int i = 0; i < arr.size(); i++) {
            temp.enqueue(arr.get(i));
        }
        // System.out.println("frontvalue "+temp.front.next().element());
    }

    public static void main(String[] args) {
        // AQueue<Integer> aq = new AQueue<>(1);
        LQueue<Integer> aq = new LQueue<>(1);
        int a;
        Scanner sc = new Scanner(System.in);
        a = sc.nextInt();

        for (int i = 0; i < a; i++) {
            int temp;
            temp = sc.nextInt();
            aq.enqueue(temp);
        }
        print(aq);

        while (true) {
            int p, q;
            q = sc.nextInt();
            p = sc.nextInt();
            if (q == 0) {

                break;
            } else if (q == 1) {

                aq.clear();
                print(aq);
                System.out.println(-1);

            } else if (q == 2) {

                aq.enqueue(p);
                print(aq);
                System.out.println(-1);

            } else if (q == 3) {
                Integer s = aq.dequeue();
                print(aq);
                System.out.println(s);

            } else if (q == 4) {

                print(aq);
                System.out.println(aq.length());

            } else if (q == 5) {
                print(aq);
                System.out.println(aq.frontValue());

            } else if (q == 6) {

                // sta.setDirection(p);
                print(aq);
                System.out.println(aq.rearValue());

            } else {
                Integer s = aq.leaveQueue();
                print(aq);
                System.out.println(s);
            }
        }
    }
}
