import java.util.Scanner;

public class Main {

    public static void print(List<Integer> temp) {
        List<Integer> a = temp;
        System.out.println(" ");
        System.out.print("<");
        // if(temp.length() == 0){
        // System.out.println("> ");
        // System.out.println(ret);
        // return;
        // }
        int a1 = a.currPos();
        a.moveToStart();
        for (int i = 0; i < a.length(); i++) {
            if (i == a1) {
                System.out.print("| ");
            }
            System.out.print(a.getValue() + " ");
            a.next();
        }
        a.moveToPos(a1);
        System.out.println(">");

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int K, X, temp, p, q;
        K = sc.nextInt();
        X = sc.nextInt();
        Integer[] inputarr = new Integer[K];

        for (int i = 0; i < K; i++) {
            temp = sc.nextInt();
            inputarr[i] = temp;
        }

        List<Integer> arr = new AList<Integer>(K, X, inputarr);
        // List<Integer> arr= new LList<Integer>(inputarr);

        print(arr);

        while (true) {
            q = sc.nextInt();
            p = sc.nextInt();
            if (q == 0) {

                break;
            }

            else if (q == 1) {
                arr.clear();
                print(arr);
                System.out.println(-1);

            } else if (q == 2) {
                arr.insert(p);
                print(arr);
                System.out.println(-1);

            } else if (q == 3) {
                arr.append(p);
                print(arr);
                System.out.println(-1);

            } else if (q == 4) {
                int k = (int) arr.remove();
                print(arr);
                System.out.println(k);

            } else if (q == 5) {
                arr.moveToStart();
                print(arr);
                System.out.println(-1);

            } else if (q == 6) {
                arr.moveToEnd();
                print(arr);
                System.out.println(-1);

            } else if (q == 7) {
                arr.prev();
                print(arr);
                System.out.println(-1);

            } else if (q == 8) {
                arr.next();
                print(arr);
                System.out.println(-1);

            } else if (q == 9) {
                print(arr);
                System.out.println(arr.length());

            } else if (q == 10) {

                print(arr);
                System.out.println(arr.currPos());

            } else if (q == 11) {
                arr.moveToPos(p);
                print(arr);
                System.out.println(-1);

            } else if (q == 12) {

                print(arr);
                System.out.println(arr.getValue());

            } else {

                print(arr);
                System.out.println(arr.Search(p));

            }
        }

    }
}
